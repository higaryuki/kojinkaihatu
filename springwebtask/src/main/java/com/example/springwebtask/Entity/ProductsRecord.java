package com.example.springwebtask.Entity;

import java.sql.Timestamp;

public record ProductsRecord(int id,String product_id,String name,int price,String categories_name,String description) {
}



// String image_path, String description,Timestamp created_at,Timestamp updated_at
