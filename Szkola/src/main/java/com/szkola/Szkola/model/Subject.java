package com.szkola.Szkola.model;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "subject")
    private List<Teacher> teacherList = new ArrayList<>();

    @ManyToMany
    private List<SchoolClass> schoolClassList = new ArrayList<>();


}
