package com.example.springwebtask.service.product;

import com.example.springwebtask.Entity.record.ProductsRecord;

import java.util.List;

public interface IProductService {
    public List<ProductsRecord> findAll();

    public List<ProductsRecord> findName(String name);

    public ProductsRecord findProId(int id);

    //public ProductsRecord findId(String product_id);
}
