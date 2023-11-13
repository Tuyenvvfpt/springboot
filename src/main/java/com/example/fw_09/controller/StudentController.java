package com.example.fw_09.controller;

import com.example.fw_09.entities.Student;
import com.example.fw_09.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin") //them tien to /admin vao duong dan
public class StudentController {

    @Autowired
    IStudentService studentService;
    @GetMapping("/student") //html
    public String homeStudent(){
        List<Student> studentList = studentService.getAll();
        return "admin/student"; //day ko phai duong dan
    }
}
