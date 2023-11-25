package com.example.fw_09.services.StudentServiceImplement;

import com.example.fw_09.dto.StudentDTO;
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
        return students; // tôi sửa thế này
//        return null; -> bạn ghi thế này
    }

    @Override
    public int save(StudentDTO studentDTO) {
        try {
            studentRepository.save(studentDTO.toEntity());
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<Student> search(String txt) {
        return studentRepository.findByName(txt);
    }

    @Override
    public Student findById(Long id) {

        return studentRepository.findById(id).get();
    }

    @Override
    public int delete(Long id) {
        try {
            studentRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
