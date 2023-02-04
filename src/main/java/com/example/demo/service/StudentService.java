package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {


    void saveStudent(Student student);
    void updateStudent(Student student);
//    void updateStudent1(Long id));
    void deleteStudent(Long id);
    Student getStudent(Long id) ;
    List <Student> getALL();
}
