package com.example.springwebtask.service;

import com.example.springwebtask.Entity.ProductsRecord;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductService {
    public List<ProductsRecord> findAll();

    public List<ProductsRecord> findName(String name);

    public ProductsRecord findProId(int id);
}
