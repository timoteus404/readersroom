package com.example.readersroom.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Books extends BaseEntity{

    private String name;
    private String author;
    private String publisher;
    private Integer year;
    private String genre;
    private Integer isnb;
}
