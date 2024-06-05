package com.example.springwebtask.service;

import com.example.springwebtask.Entity.ProductsRecord;
import com.example.springwebtask.dao.IUserDao;
import com.example.springwebtask.dao.UserDao;
import com.example.springwebtask.Entity.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserDao userDao;

    @Override
    public UserRecord findloginId(String loginId){
        return userDao.findloginId(loginId);
    }

}
