package com.blog.controller;

import com.blog.model.Category;
import com.blog.model.Blog;
import com.blog.service.ICategoryService;
import com.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService iBlogService;
    @Autowired
    ICategoryService iCategoryService;
    @ModelAttribute("categories")
    public List<Category> categories(){
        return iCategoryService.getAll();
    }
    @GetMapping
    public ModelAndView getAll(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("blogs", iBlogService.getAll());
        return modelAndView;
    }
    @GetMapping("/news/{idBlog}")
    public ModelAndView showBlog(@PathVariable int idBlog){
        ModelAndView modelAndView = new ModelAndView("single-standard");
        modelAndView.addObject("blogs", iBlogService.findById(idBlog));
        return modelAndView;
    }
    @GetMapping("/admin")
    public ModelAndView getAllManager(){
        ModelAndView modelAndView = new ModelAndView("blog-manager");
        modelAndView.addObject("blogs", iBlogService.getAll());
        return modelAndView;
    }
    @GetMapping("/add")
    public ModelAndView showFormAdd(@ModelAttribute Blog blog){
        ModelAndView modelAndView = new ModelAndView("add-Blog");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }
    @PostMapping("/add")
    public String AddNews(@ModelAttribute Blog blog, @RequestParam int idCategory){
        iBlogService.save(blog, idCategory);
        return "redirect:/blog/admin";
    }
    @GetMapping("/delete/{idBlog}")
    public String delete(@PathVariable int idBlog){
        iBlogService.delete(idBlog);
        return "redirect:/blog/admin";
    }
    @GetMapping("/edit/{idBlog}")
    public ModelAndView showFormEdit(@PathVariable int idBlog){
        ModelAndView modelAndView = new ModelAndView("edit-Blog");
        modelAndView.addObject("blog", iBlogService.findById(idBlog));
        return modelAndView;
    }
    @PostMapping("/edit")
    public String showFormEdit(@ModelAttribute Blog blog, @RequestParam int idCategory){
        iBlogService.save(blog, idCategory);
        return "redirect:/blog/admin";
    }
}

