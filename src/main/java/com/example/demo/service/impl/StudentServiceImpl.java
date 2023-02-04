package com.example.demo.service.impl;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-12 16:13
 * @LastEditTime: 2022-07-12 16:13
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    @Override
    public void saveStudent(Student student) {
        studentDao.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.update(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentDao.delete(id);
    }

    @Override
    public Student getStudent(Long id) throws EmptyResultDataAccessException {
        if(studentDao.findById(id) == null){
            System.out.println("查無id");
            throw new EmptyResultDataAccessException(Integer.valueOf("id為空值"));
        }
       return studentDao.findById(id);

    }


    @Override
    public List<Student> getALL() {
        return studentDao.findAll();
    }
}
