package com.example.springwebtask.dao.user;

import com.example.springwebtask.Entity.record.UserRecord;

public interface IUserDao {

    UserRecord findloginId(String loginId);;
}
