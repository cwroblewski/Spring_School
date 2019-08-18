package com.szkola.Szkola.serviceImpl;


import com.szkola.Szkola.model.SchoolClass;
import com.szkola.Szkola.repository.SchoolClassRepository;
import com.szkola.Szkola.service.SchoolClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolClassServiceImpl implements SchoolClassService
{
    @Autowired
    SchoolClassRepository schoolClassRepository;

    @Override
    public void save(SchoolClass schoolClass){
        schoolClassRepository.save(schoolClass);
    }

    @Override
    public Optional<SchoolClass> findById(Long id){ return schoolClassRepository.findById(id); }

    @Override
    public List<SchoolClass> findAll() { return schoolClassRepository.findAll(); }

}
