package com.example.demo.dao.impl;

import com.example.demo.StudentsRowMapper;
import com.example.demo.dao.Student2Dao;
import com.example.demo.model.Student;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-13 18:59
 * @LastEditTime: 2022-07-13 18:59
 */
//@Repository //讓spring知道DAO
@Component
public class Student2DaoImpl implements Student2Dao {
    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Student> getALLStudents() {
        String sql = "select id,name,age,tel,sex from student";
        Map<String, Object>map = new HashMap<>();
        RowMapper rowMapper = new StudentsRowMapper();
         List<Student> results=namedParameterJdbcTemplate.query(sql,map,rowMapper);

        return results;
    }

    @Override
    public Student getStudentById(Long id) {
        String sql = "select * from student where id=:id";
        Map<String, Object>map = new HashMap<>();
        map.put("id",id);
        RowMapper rowMapper = new StudentsRowMapper();
        List<Student> students = namedParameterJdbcTemplate.query(sql,map,rowMapper);
        return students.get(0);
    }

    @Override
    public String saveStudents(List<Student> student) {
        String sql="insert into student(name,age,tel,sex)values (:name,:age,:tel,:sex)";
        Map<String, Object> map = new HashMap<>();
        Map[]map2 = new HashMap[student.size()];
        for(int i=0;i<map2.length;i++){
            Student student1 = student.get(i);
            map2[i] = new HashMap();
            map2[i].put("name",student1.getName());
            map2[i].put("age",student1.getAge());
            map2[i].put("tel",student1.getTel());
            map2[i].put("sex",student1.getSex());
        }
         namedParameterJdbcTemplate.batchUpdate(sql,map2);
        return "新增成功";
    }

    @Override
    public String saveStudent(Student student) {
        System.out.println("DAOimpl"+student);
        String sql = "insert into student(name,age,tel,sex)values (:name,:age,:tel,:sex)";
        Map<String, Object> map = new HashMap<>();
        map.put("name",student.getName());
        map.put("age",student.getAge());
        map.put("tel",student.getTel());
        map.put("sex",student.getSex());
        namedParameterJdbcTemplate.update(sql,map);
        return "新增一筆資料";
    }

    @Override
    public String updateStudents(Student student, Long id) {
        String sql = "update student set name=:name,age=:age,tel=:tel,sex=:sex where id=:id";
        Map<String, Object> map = new HashMap<>();
        map.put("id",id);
         map.put("name",student.getName());
        map.put("age",student.getAge());
        map.put("tel",student.getTel());
        map.put("sex", student.getSex());
        namedParameterJdbcTemplate.update(sql,map);
        return "更新完成";
    }

    @Override
    public String deleteStudentsById(Long id) {
        String sql = "DELETE  FROM student where id=:id";
        Map<String, Object>map = new HashMap<>();
        map.put("id",id);
        namedParameterJdbcTemplate.update(sql,map);
        return "刪除一筆資料成功";
    }
}
