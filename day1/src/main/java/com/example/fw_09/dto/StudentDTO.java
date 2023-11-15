package com.example.fw_09.dto;

import com.example.fw_09.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentDTO {
    private String name;
    private int age;

    public Student toEntity(){
        return new Student(0, this.name, this.age);
    }
}
