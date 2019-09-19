package com.gtdq.consumer.consumer.service;

import com.gtdq.common.common.api.IProductService;
import com.gtdq.common.common.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author  : LiuMing
 * @date : 2019/8/14 11:57
 * @description :   TODO
 */
@Service
public class ProductService implements IProductService {

    @Autowired
    private RestTemplate restTemplate;

    public Product queryProductById(int id) {
        //可以通过服务名访问，内部会找到注册中心服务名为producer的服务提供者
        ResponseEntity<Product> responseEntity = restTemplate.getForEntity("http://producer/product/{1}", Product.class, id);
        return responseEntity.getBody();
    }


    public List<Product> queryAllProducts() {
        ResponseEntity<List> responseEntity = restTemplate.getForEntity("http://producer/products", List.class);
        List<Product> productList = responseEntity.getBody();
        return productList;
    }

    public void saveProduct(Product product) {
        restTemplate.postForObject("http://producer/product", product, Void.class);
    }
}
