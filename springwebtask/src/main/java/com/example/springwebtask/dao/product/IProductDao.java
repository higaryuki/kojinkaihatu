package com.example.springwebtask.dao.product;

import com.example.springwebtask.Entity.record.ProductsRecord;

import java.util.List;

public interface IProductDao {

    List<ProductsRecord> findAll();

    List<ProductsRecord> findName(String name);

    ProductsRecord findProId(int id);

    //ProductsRecord findId(String product_id);
}
