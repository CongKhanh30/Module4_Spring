package com.demo_springmvc.controller;

import com.demo_springmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Home {
    @Autowired
    ProductService productService;


}
