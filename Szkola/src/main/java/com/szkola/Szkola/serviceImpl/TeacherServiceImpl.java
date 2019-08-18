package com.szkola.Szkola.serviceImpl;


import com.szkola.Szkola.repository.TeacherRepository;
import com.szkola.Szkola.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService
{

    @Autowired
    TeacherRepository teacherRepository;

}
