package com.demo_springmvc.service;

import com.demo_springmvc.model.Product;

import java.util.ArrayList;

public class ProductService {
    public ArrayList<Product> products;
    public ProductService(){
        products = new ArrayList<>();
        products.add(new Product(1, "Vanh", 500000, "https://nguoinoitieng.tv/images/nnt/104/0/bhiy.jpg"));
        products.add(new Product(2, "Amee", 500000, "https://phunuvietnam.mediacdn.vn/179072216278405120/2021/12/3/amee202102-1638541792005741900734.jpg"));
        products.add(new Product(3, "Myra Trần", 500000, "https://images2.thanhnien.vn/528068263637045248/2023/3/16/edit-myra-tran-9-16789572494021490104536.png"));
        products.add(new Product(4, "Juky San", 500000, "https://images2.thanhnien.vn/Uploaded/hoangnam/2022_02_04/juky-san-1-7342.jpg"));
    }

    public Product findById(int id){
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void edit (Product product1){
        Product product = findById(product1.getId());
        product.setName(product1.getName());
        product.setImg(product1.getImg());
        product.setPrice(product1.getPrice());
    }
}
