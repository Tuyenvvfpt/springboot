package com.example.fw_09.services.StudentServiceImplement;

import com.example.fw_09.entities.Student;
import com.example.fw_09.repositories.StudentRepository;
import com.example.fw_09.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IStudentService {
    @Autowired //2nd
    StudentRepository studentRepository;

    @Override
    public List<Student> getAll() {
        List<Student> students = studentRepository.findAll();
        return null;
    }
}
