package com.bree.com.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Document("Product")
@Builder
@EqualsAndHashCode(callSuper = false)
public class Product {
    public static final String SEQUENCE_NAME = "product";
    @Id
    @MongoId
    @Field("_id")
    private String id;
    @Field(name = "Name")
    private String name;
    @Field(name = "Price")
    private BigDecimal price;
    @Field(name = "Discount")
    private BigDecimal discount;
    @Field(name = "Category")
    private String category;
    @Field(name = "Weight")
    private Double weight;
    @Field(name = "Quantity")
    private Long quantity;
    @Field(name = "AdminId")
    private String adminId;
    @Field(name = "Processed")
    private Boolean processed;
    private Instant createdDate;
}
