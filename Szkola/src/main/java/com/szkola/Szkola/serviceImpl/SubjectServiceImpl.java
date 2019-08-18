package com.szkola.Szkola.serviceImpl;


import com.szkola.Szkola.model.SchoolClass;
import com.szkola.Szkola.model.Subject;
import com.szkola.Szkola.repository.SchoolClassRepository;
import com.szkola.Szkola.repository.SubjectRepository;
import com.szkola.Szkola.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService
{
    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    SchoolClassRepository schoolClassRepository;

    @Override
    public List<Subject> findSubjectsBySchoolClassId(Long schoolClassId)
    {
        SchoolClass schoolClass = schoolClassRepository.findById(schoolClassId).get();

        return schoolClass.getSubjectList();
    }


    @Override
    public Optional<Subject> findById(Long id){ return subjectRepository.findById(id); }

    @Override
    public List<Subject> findAll() { return subjectRepository.findAll();}

    @Override
    public Subject save(Subject subject){
        return subjectRepository.save(subject);
    }

}
