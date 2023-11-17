package com.example.fw_09.controller;

import com.example.fw_09.dto.StudentDTO;
import com.example.fw_09.entities.Student;
import com.example.fw_09.repositories.StudentRepository;
import com.example.fw_09.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("admin") //them tien to /admin vao duong dan
public class StudentController {

    @Autowired
    IStudentService studentService;
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/getAll") //html
    public String homeStudent(Model model) {
        List<Student> studentList = studentService.getAll();
        studentList.forEach(s -> System.out.println(s.getId()));
        model.addAttribute("student", studentList);

        return "admin/student"; //day ko phai duong dan == front-end
    }

    @GetMapping("/add") //html
    public String add(Model model) {
//        List<Student> studentList = studentService.getAll();
//        studentList.forEach(s -> System.out.println(s.getId()));
//        model.addAttribute("student", studentList);
        model.addAttribute("student", new StudentDTO());
        return "admin/add"; //day ko phai duong dan == front-end
    }

    @PostMapping("/add")
    public String add(@ModelAttribute StudentDTO studentDTO) {
        System.out.println(studentDTO);
        studentService.save(studentDTO);
//        return "admin/student"; //day ko phai duong dan == front-end
        return "redirect:/admin/getAll";
    }

    @GetMapping("/search") //html
    public String search(Model model, @RequestParam("text_search") String text_search) {
        System.out.println(text_search);

        List<Student> studentList = new ArrayList<>();
        if (text_search.equals("")) {
            studentList = studentService.getAll();
        } else {
            studentList = studentService.search(text_search);
        }
//        studentList.forEach(s -> System.out.println(s.getId()));
        model.addAttribute("student", studentList);
         return "admin/student"; //day ko phai duong dan == front-end
    }

    @GetMapping("/edit/{id}") //html
    public String edit(Model model, @PathVariable("id") Long id) {
        System.out.println(id);
        Student student = studentService.findById(id);
        model.addAttribute("student", student);

        return "admin/edit"; //day ko phai duong dan == front-end
    }

    @PostMapping("/edit") //html
    public String edit(Model model, @ModelAttribute("student") Student student) {
//        System.out.println(student);
        studentRepository.save(student);
        return "redirect:/admin/getAll";
    }
}
