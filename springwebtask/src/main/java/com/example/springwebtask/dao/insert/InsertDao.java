package com.example.springwebtask.dao.insert;

import com.example.springwebtask.Entity.record.CategoryRecord;
import com.example.springwebtask.Entity.record.InsUpdRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InsertDao implements IInsertDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public int insert(InsUpdRecord insUpdRecord){
        var param = new MapSqlParameterSource();
        param.addValue("product_id", insUpdRecord.product_id());
        param.addValue("name", insUpdRecord.name());
        param.addValue("price", insUpdRecord.price());
        param.addValue("category_id", insUpdRecord.category_id());
        param.addValue("description", insUpdRecord.description());
        return jdbcTemplate.update("INSERT INTO products(product_id, name, price,category_id, description) VALUES(:product_id, :name,:price,:category_id,:description)", param);
    }

    @Override
    public List<CategoryRecord> findCategory(){
        return jdbcTemplate.query("SELECT * FROM categories",new DataClassRowMapper<>(CategoryRecord.class));
    }

    @Override
    public InsUpdRecord findById(String id){
        var param = new MapSqlParameterSource();
        param.addValue("id",id);
        var list = jdbcTemplate.query("SELECT * FROM products WHERE product_id = :id",  param, new DataClassRowMapper<>(InsUpdRecord.class));
        return list.isEmpty() ? null : list.get(0);
    }
}
