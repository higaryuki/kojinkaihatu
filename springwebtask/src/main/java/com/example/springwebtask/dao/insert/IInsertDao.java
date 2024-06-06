package com.example.springwebtask.dao.insert;

import com.example.springwebtask.Entity.record.CategoryRecord;
import com.example.springwebtask.Entity.record.InsertRecord;

import java.util.List;

public interface IInsertDao {

    int insert(InsertRecord insertRecord);

    List<CategoryRecord> findCategory();

    InsertRecord findById(String id);
}
