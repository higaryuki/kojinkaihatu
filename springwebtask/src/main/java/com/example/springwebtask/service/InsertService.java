package com.example.springwebtask.service;

import com.example.springwebtask.Entity.CategoryRecord;
import com.example.springwebtask.Entity.InsertRecord;
import com.example.springwebtask.Entity.ProductsRecord;
import com.example.springwebtask.dao.InsertDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsertService implements IInsertService{

    @Autowired
    InsertDao insertDao;
    @Override
    public int insert(InsertRecord insertRecord){
        return insertDao.insert(insertRecord);
    }

    @Override
    public List<CategoryRecord> findCategory(){
        return insertDao.findCategory();
    }

    @Override
    public InsertRecord findById(String id){
        return insertDao.findById(id);
    }

}
