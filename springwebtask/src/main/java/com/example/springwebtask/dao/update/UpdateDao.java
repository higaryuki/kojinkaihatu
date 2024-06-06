package com.example.springwebtask.dao.update;

import com.example.springwebtask.Entity.record.InsUpdRecord;
import com.example.springwebtask.Entity.record.ProductsRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UpdateDao implements IUpdateDao{

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public int update(InsUpdRecord insUpdRecord,int before_id){
        var param = new MapSqlParameterSource();
        System.out.println(insUpdRecord);
        param.addValue("id",before_id);

        param.addValue("product_id",insUpdRecord.product_id());
        param.addValue("name",insUpdRecord.name());
        param.addValue("price",insUpdRecord.price());
        param.addValue("category_id",insUpdRecord.category_id());
        param.addValue("description",insUpdRecord.description());
        return jdbcTemplate.update("UPDATE products SET product_id = :product_id,name = :name, price = :price,category_id=:category_id,description=:description WHERE id = :id", param);
    }
}
