package com.szkola.Szkola.service;

import com.szkola.Szkola.model.SchoolClass;

import java.util.List;
import java.util.Optional;

public interface SchoolClassService
{
    void save(SchoolClass schoolClass);

    Optional<SchoolClass> findById(Long id);

    List<SchoolClass> findAll();
}
