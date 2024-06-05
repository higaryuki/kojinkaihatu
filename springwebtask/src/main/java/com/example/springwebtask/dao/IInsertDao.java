package com.example.springwebtask.dao;

import com.example.springwebtask.Entity.CategoryRecord;
import com.example.springwebtask.Entity.InsertRecord;
import com.example.springwebtask.Entity.ProductsRecord;

import java.util.List;

public interface IInsertDao {

    int insert(InsertRecord insertRecord);

    List<CategoryRecord> findCategory();

    InsertRecord findById(String id);
}
