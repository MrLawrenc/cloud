package com.gtdq.producer.producer.controller;


import com.gtdq.common.common.api.IProductService;
import com.gtdq.common.common.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : LiuMing
 * @date : 2019/8/14 11:49
 * @description :   生产者接口
 */
@RestController
public class ProducerController {

    @Autowired
    private IProductService productService;

    @GetMapping("products")
    public List<Product> productList() {
        return productService.queryAllProducts();
    }

    @GetMapping("product/{id}")
    public Product productDetail(@PathVariable int id) {
        return productService.queryProductById(id);
    }

    @PostMapping("product")
    public void save(@RequestBody Product product) {
        productService.saveProduct(product);
    }
}
