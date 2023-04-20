package com.bree.com.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document("Admin")
public class Admin extends Person {

    @Id
    @MongoId
    private String id;
}
