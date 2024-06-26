package com.example.springwebtask.dao.user;

import com.example.springwebtask.Entity.record.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements IUserDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public UserRecord findloginId(String login_Id){
        var param = new MapSqlParameterSource();
        param.addValue("login_id",login_Id);
        var list = jdbcTemplate.query("SELECT * FROM users WHERE login_id = :login_id",param,new DataClassRowMapper<>(UserRecord.class));
        return list.isEmpty() ? null : list.get(0);
    }

}
