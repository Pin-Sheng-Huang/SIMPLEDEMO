package com.example.demo.service.impl;

import com.example.demo.dao.Student2Dao;
import com.example.demo.model.Student;
import com.example.demo.service.Student2Service;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-13 18:32
 * @LastEditTime: 2022-07-13 18:32
 */
@Component
//@Service
public class Student2ServiceImpl implements Student2Service {
    @Resource
    Student2Dao student2Dao;
    @Override
    public List<Student> getALLStudents() {
        List<Student> getAll = student2Dao.getALLStudents();
        return getAll;
    }

    @Override
    public Student getStudentById(Long id) {
        Student student = student2Dao.getStudentById(id);
        return student;
    }

    @Override
    public String saveStudent(Student student) {
       String saveStudent =  student2Dao.saveStudent(student);
        return saveStudent;
    }

    @Override
    public String saveStudents(List<Student> students) {
        String saveStudents = student2Dao.saveStudents(students);
        return saveStudents;
    }

    @Override
    public String updateStudent(Student student , Long id) {
        String updateStudents = student2Dao.updateStudents(student,id);
        return updateStudents;
    }


    @Override
    public String deleteStudentsById(Long id) {
        String deleteStudentsById = student2Dao.deleteStudentsById(id);
        return deleteStudentsById;
    }
}
