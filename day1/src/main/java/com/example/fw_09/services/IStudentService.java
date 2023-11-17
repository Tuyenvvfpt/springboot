package com.example.fw_09.services;

import com.example.fw_09.dto.StudentDTO;
import com.example.fw_09.entities.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAll(); //interface ko can annotation
    int save(StudentDTO studentDTO);
    List<Student> search(String txt);
    Student findById(Long id);
}
