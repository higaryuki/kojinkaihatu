package com.example.springwebtask.dao.update;

import com.example.springwebtask.Entity.record.InsUpdRecord;

public interface IUpdateDao {

    int update(InsUpdRecord insUpdRecord,int before_id);
}
