package com.liujin.springbootstartup.service;

import com.liujin.springbootstartup.dao.ProductRepository;
import com.liujin.springbootstartup.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Iterator;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    boolean createProduct(Product product) {

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

    @Transactional
    private  boolean deleteByIdList(List<Long> idList) {
        Iterator i = idList.iterator();
        while (i.hasNext()) {
            Product pro = (Product)i.next();
            Long proId = pro.getId();
            if(!(productRepository.existsById(proId))) {
                return false;
            } else {
                productRepository.deleteByProductId(proId);
            }
        }
        return true;
    }

    List<Product> getRecommendedProduct() {

        return productRepository.findFirst5ByPrice();
    }
}
