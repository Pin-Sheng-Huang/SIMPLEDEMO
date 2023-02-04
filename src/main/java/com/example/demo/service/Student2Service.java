package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-13 18:30
 * @LastEditTime: 2022-07-13 18:30
 */
@Service
public interface Student2Service  {
        List<Student>getALLStudents();
        Student getStudentById(Long id);
        String saveStudent(Student student);
        String saveStudents(List<Student> students);
        String updateStudent (Student student, Long id);
        String deleteStudentsById(Long id);
}
