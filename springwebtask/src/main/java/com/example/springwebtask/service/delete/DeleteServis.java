package com.example.springwebtask.service.delete;

import com.example.springwebtask.dao.delete.DeleteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteServis implements IDeleteServis{

    @Autowired
    DeleteDao deleteDao;

    @Override
    public int delete(int id){
        return deleteDao.delete(id);
    }
}
