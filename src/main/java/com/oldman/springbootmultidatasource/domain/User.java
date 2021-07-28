package com.oldman.springbootmultidatasource.domain;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = -7467433139967569855L;

    private Integer id;
    private String username;
    private Integer age;
}
