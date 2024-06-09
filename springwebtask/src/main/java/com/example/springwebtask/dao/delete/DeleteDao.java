package com.example.springwebtask.dao.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
<<<<<<< HEAD
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
=======
>>>>>>> origin/master
import org.springframework.stereotype.Repository;

@Repository
public class DeleteDao implements IDeleteDao{

    @Autowired
<<<<<<< HEAD
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public int delete(int id){
        var param = new MapSqlParameterSource();
        param.addValue("id",id);
        return jdbcTemplate.update("DELETE FROM products WHERE id = :id",param);
=======
    JdbcTemplate jdbcTemplate;

    @Override
    public int delete(int id){
        //var param = new MapSqlParameterSource();
        //param.addValue("id",id);
        return jdbcTemplate.update("DELETE FROM products WHERE id = "+id);
>>>>>>> origin/master
    }
}
