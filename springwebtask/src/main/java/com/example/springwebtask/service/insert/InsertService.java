package com.example.springwebtask.service.insert;

import com.example.springwebtask.Entity.record.CategoryRecord;
<<<<<<< HEAD
import com.example.springwebtask.Entity.record.InsUpdRecord;
import com.example.springwebtask.dao.insert.InsertDao;
=======
import com.example.springwebtask.Entity.record.InsertRecord;
import com.example.springwebtask.dao.insert.InsertDao;
import com.example.springwebtask.service.insert.IInsertService;
>>>>>>> origin/master
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsertService implements IInsertService {

    @Autowired
    InsertDao insertDao;
    @Override
<<<<<<< HEAD
    public int insert(InsUpdRecord insUpdRecord){
        return insertDao.insert(insUpdRecord);
=======
    public int insert(InsertRecord insertRecord){
        return insertDao.insert(insertRecord);
>>>>>>> origin/master
    }

    @Override
    public List<CategoryRecord> findCategory(){
        return insertDao.findCategory();
    }

    @Override
<<<<<<< HEAD
    public InsUpdRecord findById(String id){
=======
    public InsertRecord findById(String id){
>>>>>>> origin/master
        return insertDao.findById(id);
    }

}
