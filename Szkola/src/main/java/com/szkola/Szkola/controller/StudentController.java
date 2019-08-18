package com.szkola.Szkola.controller;

import com.szkola.Szkola.model.SchoolClass;
import com.szkola.Szkola.model.Student;
import com.szkola.Szkola.service.SchoolClassService;
import com.szkola.Szkola.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController
{
    @Autowired
    StudentService studentService;

    @Autowired
    SchoolClassService schoolClassService;

    @GetMapping("/addStudentBind")
    public String createNewStudent(Model model)
    {
        List<SchoolClass> schoolClassList = schoolClassService.findAll();
        model.addAttribute("student", new Student());
        model.addAttribute("schoolClassList", schoolClassList);

        return "addStudentForm";
    }

    @PostMapping("addStudentBind")
    public String createNewStudent(Student student)
    {
        Long student_id = studentService.save(student).getId();
        Student currentStudent = studentService.findById(student_id).get();
        if (currentStudent.getSchoolClass() != null)
        {
            SchoolClass schoolClass = schoolClassService.findById(student_id).get();
            schoolClassService.save(schoolClass);
        }

        return "redirect:/showAllStudents";
    }

        @GetMapping("/addStudentsToClass/{schoolClass_id}")
    public String chooseStudentToClass(@PathVariable Long schoolClass_id, Model model)
    {
        SchoolClass schoolClass = schoolClassService.findById(schoolClass_id).get();
        List<Student> studentList = studentService.findNoClassStudents();
        model.addAttribute("schoolClass", schoolClass);
        model.addAttribute("studentList", studentList);

        return "addStudentToClass";
    }

    @GetMapping("/addStudentToClass/{schoolClass_id}/{student_id}")
    public String addStudentToClass(@PathVariable Long schoolClass_id, @PathVariable Long student_id, Model model)
    {
        SchoolClass schoolClass = schoolClassService.findById(schoolClass_id).get();
        Student student = studentService.findById(student_id).get();

        schoolClass.getStudentList().add(student);
        student.setSchoolClass(schoolClass);

        schoolClassService.save(schoolClass);

        List<Student> classStudentsList = studentService.findStudentsBySchoolClassId(schoolClass_id);

        model.addAttribute("schoolClass", schoolClass);
        model.addAttribute("classStudentsList", classStudentsList);


        return "showClassStudents";
    }

    @GetMapping("/showClassStudents/{schoolClass_id}")
    public String showClassStudents(@PathVariable Long schoolClass_id, Model model)
    {
        List<Student> classStudentsList = studentService.findStudentsBySchoolClassId(schoolClass_id);
        SchoolClass schoolClass = schoolClassService.findById(schoolClass_id).get();

        model.addAttribute("schoolClass", schoolClass);
        model.addAttribute("classStudentsList", classStudentsList);

        return "showClassStudents";
    }

    @GetMapping("/showAllStudents")
    public String showAllStudents(Model model)
    {
        List<Student> allStudentsList = studentService.findAll();
        model.addAttribute("allStudentsList", allStudentsList);


        return "showAllStudents";
    }

//    @GetMapping("/editStudent/{student_id}")
//    public String editStudent(@PathVariable Long student_id, Model model)
//    {
//        Student student = studentService.findById(student_id).get();
//
//        model.addAttribute("student", student);
//
//        return "addStudentForm";
//
//    }


}
