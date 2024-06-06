package com.example.springwebtask.dao.insert;

import com.example.springwebtask.Entity.record.CategoryRecord;
import com.example.springwebtask.Entity.record.InsUpdRecord;

import java.util.List;

public interface IInsertDao {

    int insert(InsUpdRecord insUpdRecord);

    List<CategoryRecord> findCategory();

    InsUpdRecord findById(String id);
}
