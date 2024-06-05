package com.example.springwebtask.service;

import com.example.springwebtask.Entity.ProductsRecord;
import com.example.springwebtask.Entity.UserRecord;

import java.util.List;

public interface IUserService {

    public UserRecord findloginId(String loginId);
}
