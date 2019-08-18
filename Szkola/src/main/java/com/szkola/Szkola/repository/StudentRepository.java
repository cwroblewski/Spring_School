package com.szkola.Szkola.repository;

import com.szkola.Szkola.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long>
{

    @Query(value = "Select s from Student s where school_class_id = null")
    List<Student> findNoClassStudents();

}
