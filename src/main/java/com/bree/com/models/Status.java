package com.bree.com.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@Document(collection = "status")
public class Status {
    public static final String SEQUENCE_NAME = "status";
    @Id
    private Long id;
    private String name;
    private String description;
}

