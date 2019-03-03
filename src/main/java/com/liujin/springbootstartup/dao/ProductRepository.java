package com.liujin.springbootstartup.dao;

import com.liujin.springbootstartup.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
