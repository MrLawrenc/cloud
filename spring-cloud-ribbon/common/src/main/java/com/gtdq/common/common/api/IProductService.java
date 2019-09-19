package com.gtdq.common.common.api;


import com.gtdq.common.common.bean.Product;

import java.util.List;
/**
 * @author  : LiuMing
 * @date : 2019/8/14 11:47
 * @description :   产品服务接口类
 */
public interface IProductService {

    Product queryProductById(int id);

    List<Product> queryAllProducts();

    void saveProduct(Product product);
}
