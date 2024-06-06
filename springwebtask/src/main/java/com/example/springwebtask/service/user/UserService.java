package com.example.springwebtask.service.user;

import com.example.springwebtask.dao.user.UserDao;
import com.example.springwebtask.Entity.record.UserRecord;
import com.example.springwebtask.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserRecord findloginId(String loginId){
        return userDao.findloginId(loginId);
    }

}
