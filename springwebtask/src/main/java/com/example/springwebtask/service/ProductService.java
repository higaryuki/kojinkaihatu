package com.example.springwebtask.service;

import com.example.springwebtask.Entity.ProductsRecord;
import com.example.springwebtask.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    ProductDao productDao;

    @Override
    public List<ProductsRecord> findAll(){
        return productDao.findAll();
    }

    @Override
    public List<ProductsRecord> findName(String name){
        return productDao.findName(name);
    }

    @Override
    public ProductsRecord findProId(int id){
        return productDao.findProId(id);
    }
}
