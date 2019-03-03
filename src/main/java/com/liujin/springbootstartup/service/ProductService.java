package com.liujin.springbootstartup.service;

import com.liujin.springbootstartup.dao.ProductRepository;
import com.liujin.springbootstartup.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;


public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void createProduct(Product product) {
        if(product.getName().equals("")) {
            System.out.println("has no name");
        } else if(product.getId() == null) {
            System.out.println("has no id");
        } else if(product.getPrice() == null) {
            System.out.println("has no prise");
        } else if(!(product.getImage().startsWith("http"))) {
            System.out.println("image error");
        } else {
            productRepository.save(product);
        }
    }

}
