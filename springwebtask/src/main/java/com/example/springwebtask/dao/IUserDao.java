package com.example.springwebtask.dao;

import com.example.springwebtask.Entity.ProductsRecord;
import com.example.springwebtask.Entity.UserRecord;

import java.util.List;

public interface IUserDao {

    UserRecord findloginId(String loginId);;
}
