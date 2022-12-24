package com.izzat.sms.controller;

import com.izzat.sms.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping("students")
    public String getAllStudents(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return "students";
    }
}
