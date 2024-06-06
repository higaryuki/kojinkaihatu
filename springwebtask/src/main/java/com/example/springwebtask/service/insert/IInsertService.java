package com.example.springwebtask.service.insert;

import com.example.springwebtask.Entity.record.CategoryRecord;
import com.example.springwebtask.Entity.record.InsUpdRecord;

import java.util.List;

public interface IInsertService {

    int insert(InsUpdRecord insUpdRecord);

    List<CategoryRecord> findCategory();

    InsUpdRecord findById(String id);
}
