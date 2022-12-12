package com.example.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

@Document("employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

    @Field("id")
    private Integer id;
    @Field("name")
    private String name;
    @Field("age")
    private Integer age;
    @Field("salary")
    private Double salary;
    @Field("birthday")
    private Date birthday;
}
