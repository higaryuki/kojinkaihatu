package com.example.springwebtask.service.insert;

import com.example.springwebtask.Entity.record.CategoryRecord;
import com.example.springwebtask.Entity.record.InsUpdRecord;
import com.example.springwebtask.dao.insert.InsertDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsertService implements IInsertService {

    @Autowired
    InsertDao insertDao;
    @Override
    public int insert(InsUpdRecord insUpdRecord){
        return insertDao.insert(insUpdRecord);
    }

    @Override
    public List<CategoryRecord> findCategory(){
        return insertDao.findCategory();
    }

    @Override
    public InsUpdRecord findById(String id){
        return insertDao.findById(id);
    }

}
