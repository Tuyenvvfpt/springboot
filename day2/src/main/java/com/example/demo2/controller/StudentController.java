package com.example.demo2.controller;

import com.example.demo2.entities.Student;
import com.example.demo2.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin") //them tien to /admin vao duong dan
public class StudentController {

    @Autowired
    IStudentService studentService;

    @GetMapping("/student") //html
    public String homeStudent(Model model){
        List<Student> studentList = studentService.getAll();
        model.addAttribute("student", studentList);


        return "admin/student"; //day ko phai duong dan == front-end
    }
}
