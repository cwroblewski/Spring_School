package com.szkola.Szkola.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class SchoolClass
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer year;

    private String signature;

    private String profile;

    @ManyToMany(mappedBy = "schoolClassList")
    private List<Subject> subjectList = new ArrayList<>();

    @OneToMany(mappedBy = "schoolClass")
    private List<Student> studentList = new ArrayList<>();
}
