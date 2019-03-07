package com.liujin.springbootstartup.controller;

import com.liujin.springbootstartup.SpringBootStartupApplicationTests;
import com.liujin.springbootstartup.service.ProductService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ProductControllerTest extends SpringBootStartupApplicationTests {

    @Mock
    ProductService productService;

    @InjectMocks
    ProductController productController;

    @Autowired
    WebApplicationContext context;

    private MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetPagedProduct() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product/page")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("index", "1")
                .param("size","5")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testAddProduct() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/product/boolean")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("id","155")
                .param("image","http")
                .param("name", "name")
                .param("price", "100")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print());
    }
}