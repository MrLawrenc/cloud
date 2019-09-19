package com.gtdq.consumer.consumer.controller;


import com.gtdq.common.common.api.IProductService;
import com.gtdq.common.common.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author  : LiuMing
 * @date : 2019/8/14 13:19
 * @description :   TODO
 */
@Controller
@RequestMapping("sell")
public class SellController {

    @Autowired
    private IProductService productService;

    @GetMapping("products")
    public String productList(Model model) {
        List<Product> products = productService.queryAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("product/{id}")
    public String productDetail(@PathVariable int id, Model model) {
        Product product = productService.queryProductById(id);
        model.addAttribute("product", product);
        return "product";
    }

    @PostMapping("product")
    public String save(@RequestParam String productName) {
        long id = Math.round(Math.random() * 100);
        Product product = new Product(id, productName, false, new Date(), 88);
        productService.saveProduct(product);
        return "redirect:products";
    }
}
