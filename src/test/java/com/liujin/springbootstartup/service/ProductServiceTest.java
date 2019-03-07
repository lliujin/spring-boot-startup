package com.liujin.springbootstartup.service;

import com.liujin.springbootstartup.SpringBootStartupApplicationTests;
import com.liujin.springbootstartup.dao.ProductRepository;
import com.liujin.springbootstartup.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ProductServiceTest extends SpringBootStartupApplicationTests {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductService productService = new ProductService();
    @Before
    public void setUp() throws Exception {
        when(productRepository.save(any())).thenReturn(null);
    }

    @Test
    public void testCreateProduct() {
        Product invalidProduct1 = new Product(1L, "ftp://localhost","cat", 0L);
        Product invalidProduct2 = new Product(1L, "http://", null, 12L);
        Product invalidProduct3 = new Product(null, "http://", "kat", 1L);
        Product invalidProduct4 = new Product(2L, "http29", "kat", null);
        Product invalidProduct5 = new Product(1L, null, "kat", 2L);

        Product validProduct1 = new Product(3L, "http://localhost", "cat", 12L);
        Product validProduct2 = new Product(4L, "http://localhost", "cat", 12L);


        assertFalse(productService.createProduct(invalidProduct1));
        assertFalse(productService.createProduct(invalidProduct2));
        assertFalse(productService.createProduct(invalidProduct3));
        assertFalse(productService.createProduct(invalidProduct4));
        assertFalse(productService.createProduct(invalidProduct5));

        when(productRepository.existsById(validProduct1.getId())).thenReturn(true);
        assertFalse(productService.createProduct(validProduct1));
        verify(productRepository, never()).save(validProduct1);

        when(productRepository.existsById(validProduct2.getId())).thenReturn(false);
        assertTrue(productService.createProduct(validProduct2));
        verify(productRepository, times(1)).save(validProduct2);
    }

    @Test
    public void addProducts() {
        //TODO move the test to dao
        for(long i=1000L; i<1100L; i++) {
           productService.createProduct(new Product(i,"http", "product", 100L));
        }
    }
}