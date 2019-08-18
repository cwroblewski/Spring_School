package com.szkola.Szkola.controller;


import com.szkola.Szkola.model.SchoolClass;
import com.szkola.Szkola.service.SchoolClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SchoolClassController
{
    @Autowired
    SchoolClassService schoolClassService;

    @GetMapping("/addClassBind")
    public String createSchoolClass(Model model)
    {
        model.addAttribute("schoolClass", new SchoolClass());

        return "addSchoolClassForm";

    }

    @PostMapping("/addClassBind")
    public String createClassPostBind(SchoolClass schoolClass)
    {
        schoolClassService.save(schoolClass);

        return "redirect:/showAllClasses";
    }

    @GetMapping("/showAllClasses")
    public String showAllClasses(Model model)
    {
        List<SchoolClass> schoolClassList = schoolClassService.findAll();
        model.addAttribute("schoolClassList", schoolClassList);

        return "showAllClasses";
    }

    @GetMapping("/editSchoolClass/{schoolClass_id}")
    public String editschoolClass (@PathVariable Long schoolClass_id, Model model)
    {
        SchoolClass schoolClass = schoolClassService.findById(schoolClass_id).get();

        model.addAttribute("schoolClass", schoolClass);

        return "addSchoolClassForm";
    }

    @PostMapping("/saveClassEdits")
    public String saveClassEdits(SchoolClass schoolClass)
    {
        schoolClassService.save(schoolClass);

        return "redirect:/showAllClasses";
    }

}
