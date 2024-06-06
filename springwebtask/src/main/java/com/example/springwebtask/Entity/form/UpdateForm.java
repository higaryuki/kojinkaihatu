package com.example.springwebtask.Entity.form;

import lombok.Data;

@Data
public class UpdateForm {

    int id;

    String product_id;

    String name;

    int price;

    String categories_name;

    String description;
}
