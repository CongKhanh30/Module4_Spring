package com.fpt_management.controller;

import com.fpt_management.model.Branch;
import com.fpt_management.model.Staff;
import com.fpt_management.service.BranchService;
import com.fpt_management.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.File;

@Controller
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    StaffService staffService;
    @Autowired
    BranchService branchService;

    @GetMapping
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("staffList" , staffService.findAll());
        return modelAndView;
    }
    @GetMapping("showFormAdd")
    public ModelAndView showFormAdd(){
        ModelAndView modelAndView = new ModelAndView("formAdd");
        modelAndView.addObject("branchList",branchService.getAll());
        modelAndView.addObject("staff" , new Staff());
        return modelAndView;
    }
    @PostMapping("/add")
    public String add(@ModelAttribute Staff staff , @RequestParam MultipartFile fileImg, int branchId){

        try {
            String nameFile = fileImg.getOriginalFilename();
            fileImg.transferTo(new File("F:/CodeGYM/Module4_Spring/FPT_Management/src/main/webapp/img/" + nameFile));
            Branch branch = branchService.findById(branchId);
            staff.setBranch(branch);
            staff.setImg(nameFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        staffService.add(staff);
        return "redirect:/staff";
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("redirect:/staff");
        staffService.delete(id);
        return  modelAndView;
    }
    @GetMapping("/formEdit/{id}")
    public ModelAndView formEdit(@PathVariable int id){
        Staff staff = staffService.findById(id);

        ModelAndView modelAndView = new ModelAndView("formEdit");
        modelAndView.addObject("staff" , staff);
        modelAndView.addObject("brandList",branchService.getAll());
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute Staff staff){
        ModelAndView modelAndView = new ModelAndView("redirect:/staff");
        Staff newStaff = new Staff(staff.getStaffCode(), staff.getStaffName() , staff.getAge() , staff.getSalary() , staff.getBranch(), staff.getImg());
        staffService.edit(newStaff);
        return modelAndView;
    }
    @GetMapping("/information/{id}")
    public ModelAndView showInformation(@PathVariable int id){
        Staff staff = staffService.findById(id);
        ModelAndView modelAndView = new ModelAndView("information");
        modelAndView.addObject("staff" , staff);
        return modelAndView;
    }

}
