package com.szkola.Szkola.serviceImpl;


import com.szkola.Szkola.model.SchoolClass;
import com.szkola.Szkola.model.Student;
import com.szkola.Szkola.repository.SchoolClassRepository;
import com.szkola.Szkola.repository.StudentRepository;
import com.szkola.Szkola.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService
{
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SchoolClassRepository schoolClassRepository;

    @Override
    public Student save(Student student){
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() { return studentRepository.findAll();}

    @Override
    public Optional<Student> findById(Long id) {return studentRepository.findById(id);}

    @Override
    public List<Student> findStudentsBySchoolClassId(Long schoolClassId)
    {
        SchoolClass schoolClass = schoolClassRepository.findById(schoolClassId).get();

        return schoolClass.getStudentList();
    }

    @Override
    public List<Student> findNoClassStudents()
    {
        return studentRepository.findNoClassStudents();
    }

}
