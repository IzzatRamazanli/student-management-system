package com.izzat.sms.controller;

import com.izzat.sms.entity.Student;
import com.izzat.sms.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    @GetMapping
    public String getAllStudents(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return "students";
    }

    @GetMapping("/new")
    public String creatStudentForm(Model model) {
        //create student object for hold the data
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping
    public String saveStudent(@ModelAttribute("student") Student student) {
        service.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/update/{id}")
    public String updateStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", service.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student) {
        Student currentStudent = service.getStudentById(id);
        currentStudent.setId(id);
        currentStudent.setFirstName(student.getFirstName());
        currentStudent.setLastName(student.getLastName());
        currentStudent.setEmail(student.getEmail());
        service.updateStudent(currentStudent);
        return "redirect:students";
    }


    @GetMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteStudentById(id);
        return "redirect:students";

    }
}
