package com.example.springwebtask.dao.insert;

import com.example.springwebtask.Entity.record.CategoryRecord;
<<<<<<< HEAD
import com.example.springwebtask.Entity.record.InsUpdRecord;
=======
import com.example.springwebtask.Entity.record.InsertRecord;
>>>>>>> origin/master

import java.util.List;

public interface IInsertDao {

<<<<<<< HEAD
    int insert(InsUpdRecord insUpdRecord);

    List<CategoryRecord> findCategory();

    InsUpdRecord findById(String id);
=======
    int insert(InsertRecord insertRecord);

    List<CategoryRecord> findCategory();

    InsertRecord findById(String id);
>>>>>>> origin/master
}
