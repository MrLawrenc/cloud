package com.gtdq.producer.producer.service;

import com.gtdq.common.common.api.IProductService;
import com.gtdq.common.common.bean.Product;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author  : LiuMing
 * @date : 2019/8/14 13:27
 * @description :   TODO
 */
@Service
public class ProductService implements IProductService, ApplicationListener<WebServerInitializedEvent> {

    private static List<Product> productList = new ArrayList<>();

    public Product queryProductById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }


    public List<Product> queryAllProducts() {
        return productList;
    }

    @Override
    public void saveProduct(Product product) {
        productList.add(product);
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        int port = event.getWebServer().getPort();
        for (long i = 0; i < 20; i++) {
            productList.add(new Product(i, port + "产品" + i, i / 2 == 0, new Date(), 66.66f * i));
        }
    }
}
