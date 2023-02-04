package com.example.demo.dao;

import com.example.demo.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-13 18:33
 * @LastEditTime: 2022-07-13 18:33
 */
@Component //dao層必須打
public interface Student2Dao {

    List<Student> getALLStudents();
    Student getStudentById(Long id);
    String saveStudents(List<Student> student);
    String saveStudent(Student student);
    String updateStudents(Student student,Long id);
    String deleteStudentsById(Long id);


}
