package com.example.springwebtask.Entity.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductForm {

    int id;

    @NotEmpty(message = "商品IDは必須です")
    String product_id;

    @NotEmpty(message = "商品名は必須です")
    String name;

    @NotNull(message = "単価は必須です")
    Integer price;

    //@NotEmpty(message = "カテゴリは必須です")
    int categories_id;

    String description;
}
