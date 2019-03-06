package com.liujin.springbootstartup.service;

import com.liujin.springbootstartup.dao.ProductRepository;
import com.liujin.springbootstartup.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    private  boolean deleteByIdList(List<Long> idList) {
        if(!(productRepository.findAll().containsAll(idList))) {
            return false;
        } else {
            productRepository.deleteInBatchById(idList);
            return true;
        }
    }

    List<Product> getRecommendedProduct() {

        return productRepository.findTop6ByOrderByPriceAsc();
    }

    public Page<Product> pagingQueryProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
