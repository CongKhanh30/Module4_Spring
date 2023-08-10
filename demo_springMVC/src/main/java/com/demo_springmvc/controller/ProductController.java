package com.demo_springmvc.controller;

import com.demo_springmvc.model.Product;
import com.demo_springmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/products")
@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    // đang null
    // để lấy list có giá trị từ ProductService
    // khi gọi ProductService thì lấy List<Product> productList ở đâu ?????
    // vào file dispatcher-servlet.xml cấu hình cho Spring cái List<Product> productList là cái gì
   /* <!--

    <bean class="com.demo_spring_mvc.service.ProductService" name="productService"></bean>

    -->*/
    // sau đó thêm  @Autowired ở trên private ProductService productService ; để nó xác đinh productService

    @GetMapping
    public String home(Model model){
        model.addAttribute("productList" , productService.findAll());
        return "products";
    }
    @GetMapping("/formAdd")
    public String add(){
        return "formAdd";
    }
    @GetMapping("/delete")
    public String delete(int idProduct){
        productService.delete(idProduct);
        return "redirect:/products";
    }
    @GetMapping("/formEdit")
    public String showFormEdit(int idProduct , Model model){
        Product product = productService.findById(idProduct);
        model.addAttribute("product" , product);
        return "formEdit";
    }
    @GetMapping("/search")
    public String search(String name, Model model){
        model.addAttribute("productList" , productService.searchByName(name));
        return "search";
    }
    @PostMapping("/edit")
    public String edit(@RequestParam int id, String name , int price , String img){
        Product product = new Product(id, name , price , img);
        productService.edit(product);
        return "redirect:/products";
    }
    @PostMapping("/add")
    public String add(String name , int price , String img){
        Product product = new Product(name , price , img);
        productService.add(product);
        return "redirect:/products";
    }

}
