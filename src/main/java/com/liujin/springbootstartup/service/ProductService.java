package com.liujin.springbootstartup.service;

import com.liujin.springbootstartup.dao.ProductRepository;
import com.liujin.springbootstartup.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public boolean createProduct(Product product) {

        if(validateProduct(product)) {
            if(productRepository.existsById(product.getId())) {
                return false;
            } else {
                productRepository.save(product);
                return true;
            }
        }
        return false;
    }

    private boolean validateProduct(Product product) {
        if(StringUtils.isEmpty(product.getName())) {
            return false;
        } else if(product.getId() == null) {
            return false;
        } else if(product.getPrice() == null) {
            return false;
        } else if(product.getImage() == null || !(product.getImage().startsWith("http"))) {
            return false;
        } else {
            return true;
        }
    }
}
