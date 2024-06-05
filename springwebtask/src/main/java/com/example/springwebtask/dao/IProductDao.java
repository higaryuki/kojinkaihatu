package com.example.springwebtask.dao;

import com.example.springwebtask.Entity.ProductsRecord;

import java.util.List;

public interface IProductDao {

    List<ProductsRecord> findAll();

    List<ProductsRecord> findName(String name);

    ProductsRecord findProId(int id);
}
