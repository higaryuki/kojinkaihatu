package com.example.springwebtask.service.update;

import com.example.springwebtask.Entity.record.InsUpdRecord;
import com.example.springwebtask.dao.update.UpdateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateService implements  IUpdateService{

    @Autowired
    UpdateDao updateDao;

    @Override
    public int update(InsUpdRecord insUpdRecord,int before_id){
        return updateDao.update(insUpdRecord,before_id);
    }
}
