package com.example.fw_09.resource;

import com.example.fw_09.dto.StudentDTO;
import com.example.fw_09.entities.Student;
import com.example.fw_09.repositories.StudentRepository;
import com.example.fw_09.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api") //dat prefix
public class StudentRest {
    @Autowired
    IStudentService studentService;
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> list_student = studentService.getAll();
        return new ResponseEntity<>(list_student, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody StudentDTO studentDTO) {
        int result = studentService.save(studentDTO);
        if (result == 1) {
            return new ResponseEntity<>("Add successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Add fail", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> findByName(@RequestParam("txt_search")String text){
        List<Student> studentList = new ArrayList<>();
        if (text.equals("")) {
            studentList = studentService.getAll(); //service
        } else {
            studentList = studentService.search(text); //service
        }
        return new ResponseEntity<>(studentList, HttpStatus.OK); //day ko phai duong dan == front-end
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable("id") Long id, @RequestBody StudentDTO studentDTO) {

//        studentRepository.save(new Student(id, studentDTO.getName(), studentDTO.getAge()));
        studentRepository.save(new Student(id, studentDTO.getName(), studentDTO.getAge()));
        return new ResponseEntity<>("Update successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
//    public String delete(@PathVariable("id") Long id) {

    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        int result = studentService.delete(id);
        if (result == 1) {
//            return "redirect:/admin/getAll"; //405 not allowed - getmapping
            return new ResponseEntity<>("Delete successfully", HttpStatus.OK);
        }
//        return "";
        return new ResponseEntity<>("Delete fail", HttpStatus.BAD_REQUEST);
    }
}
