package com.example.demo.dao;

import com.example.demo.model.Article;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-12 16:15
 * @LastEditTime: 2022-07-12 16:15
 */
@Repository
public class StudentDao {

    @Resource
//    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Student student){
        jdbcTemplate.update("INSERT INTO student(name ,age ,tel ,sex) values(?, ?, ?, ?)",
//                student.getId(),
                student.getName(),
                student.getAge(),
                student.getTel(),
                student.getSex());
    }

    public void delete(Long id){
        jdbcTemplate.update("DELETE FROM student WHERE id=?",id);//傳值要放後面
    }

    public void update(Student sutdent){
        jdbcTemplate.update("UPDATE student SET name=?,age=?,tel=?,sex=? WHERE id=?",
                sutdent.getName(),
                sutdent.getAge(),
                sutdent.getTel(),
                sutdent.getSex(),
                sutdent.getId());
    }
    public Student findById(Long id){
        return jdbcTemplate.queryForObject(("SELECT * FROM student WHERE id=?"),new Object[]{id},
                new BeanPropertyRowMapper<>(Student.class));
    }
    public List<Student> findAll(){
        List<Student> students = jdbcTemplate.query("SELECT * FROM student", new BeanPropertyRowMapper<>(Student.class));
        return students;
    }
}
