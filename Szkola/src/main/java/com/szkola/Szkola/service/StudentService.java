package com.szkola.Szkola.service;

import com.szkola.Szkola.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService
{
    Student save(Student subject);

    List<Student> findAll();

    Optional<Student> findById(Long id);

    List<Student> findStudentsBySchoolClassId(Long schoolClassId);

    List<Student> findNoClassStudents();
}
