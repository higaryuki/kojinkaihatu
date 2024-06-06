package com.example.springwebtask.dao.product;

import com.example.springwebtask.Entity.record.ProductsRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao implements IProductDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<ProductsRecord> findAll(){
        return jdbcTemplate.query("SELECT products.id,product_id,products.name,price,categories.name AS categories_name,description FROM products INNER JOIN categories ON products.category_id = categories.id",new DataClassRowMapper<>(ProductsRecord.class));
    }

    @Override
    public List<ProductsRecord> findName(String name){
        var param = new MapSqlParameterSource();
        param.addValue("product_name",name);
        return jdbcTemplate.query("SELECT products.id,products.id,product_id,products.name,price,categories.name AS categories_name,description FROM products INNER JOIN categories ON products.category_id = categories.id WHERE products.name LIKE '%"+name+"%'",param,new DataClassRowMapper<>(ProductsRecord.class));
    }

    @Override
    public ProductsRecord findProId(int id){
        var param = new MapSqlParameterSource();
        param.addValue("id",id);
        var list = jdbcTemplate.query("SELECT products.id,product_id,products.name,price,categories.name AS categories_name,description FROM products INNER JOIN categories ON products.category_id = categories.id WHERE products.id = :id",param,new DataClassRowMapper<>(ProductsRecord.class));
        return list.isEmpty() ? null : list.get(0);
    }


    /*public ProductsRecord findId(String product_id){
        var param = new MapSqlParameterSource();
        param.addValue("product_id",product_id);
        var list = jdbcTemplate.query("SELECT products.id,product_id,products.name,price,categories.name AS categories_name,description FROM products INNER JOIN categories ON products.category_id = categories.id WHERE product_id = :product_id",param,new DataClassRowMapper<>(ProductsRecord.class));
        return list.isEmpty() ? null : list.get(0);
    }*/
}
