package com.szkola.Szkola.service;

import com.szkola.Szkola.model.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    List<Subject> findSubjectsBySchoolClassId(Long schoolClassId);

    Subject save(Subject subject);

    List<Subject> findAll();

    Optional<Subject> findById(Long id);
}
