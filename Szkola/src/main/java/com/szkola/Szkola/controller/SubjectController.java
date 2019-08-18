package com.szkola.Szkola.controller;

import com.szkola.Szkola.model.SchoolClass;
import com.szkola.Szkola.model.Subject;
import com.szkola.Szkola.service.SchoolClassService;
import com.szkola.Szkola.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SubjectController
{
    @Autowired
    SubjectService subjectService;

    @Autowired
    SchoolClassService schoolClassService;

    @GetMapping("/addSubjectBind")
    public String addSubject(Model model)
    {
        model.addAttribute("subject", new Subject());

        return "addSubjectForm";
    }

    @PostMapping("/addSubjectBind")
    public String createNewSubject(Subject subject)
    {
        subjectService.save(subject);

        return "redirect:/showAllSubjects";
    }

    @GetMapping("/addSubjects/{schoolClass_id}")
    public String chooseSubjecttoClass(@PathVariable Long schoolClass_id, Model model)
    {
        SchoolClass schoolClass = schoolClassService.findById(schoolClass_id).get();
        List<Subject> subjectList = subjectService.findAll();
        model.addAttribute("schoolClass", schoolClass);
        model.addAttribute("subjectList", subjectList);

        return "addSubjectToClass";


    }

    @GetMapping("/addSubjects/{schoolClass_id}/{subject_id}")
    public String addSubjectToClass(@PathVariable Long schoolClass_id, @PathVariable Long subject_id, Model model)
    {
        SchoolClass schoolClass = schoolClassService.findById(schoolClass_id).get();
        Subject subject = subjectService.findById(subject_id).get();

        subject.getSchoolClassList().add(schoolClass);
        schoolClass.getSubjectList().add(subject);

        schoolClassService.save(schoolClass);

        return "redirect:/showClassSubjects/"+schoolClass_id;
    }

    @GetMapping("/showClassSubjects/{schoolClass_id}")
    public String showClassSubjects(@PathVariable Long schoolClass_id, Model model)
    {
        List<Subject> classSubjectList = subjectService.findSubjectsBySchoolClassId(schoolClass_id);
        SchoolClass schoolClass = schoolClassService.findById(schoolClass_id).get();

        model.addAttribute("schoolClass", schoolClass);
        model.addAttribute("classSubjectList", classSubjectList);

        return "showClassSubjects";
    }

    @GetMapping("/showAllSubjects")
    public String showAllSubjects(Model model)
    {
        List<Subject> allSubjectsList = subjectService.findAll();

        model.addAttribute("allSubjectsList", allSubjectsList);

        return "showAllSubjects";
    }

}
