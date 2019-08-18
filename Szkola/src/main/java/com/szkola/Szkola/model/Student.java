package com.szkola.Szkola.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @ManyToOne
    private SchoolClass schoolClass;
}
