package com.example.readersroom.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;


@Getter
@Setter
@Entity
public class Members extends BaseEntity{

    private String firstname;
    private String lastname;
    private Date birthday;
    private String sex;
    private Integer booksTaken;

}
