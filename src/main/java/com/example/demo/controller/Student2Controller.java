package com.example.demo.controller;

import com.example.demo.StudentsRowMapper;
import com.example.demo.dao.impl.Student2DaoImpl;
import com.example.demo.dto.Student2Dto;
import com.example.demo.model.Student;
import com.example.demo.service.Student2Service;
import com.example.demo.service.impl.Student2ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-12 19:05
 * @LastEditTime: 2022-07-12 19:05
 */
@RestController
@RequestMapping("/rest2")

public class Student2Controller {
    @Resource
    Student2Service Student2Service;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @GetMapping("/get/{id}")
    public  Student  getStudentById(@PathVariable Long id){
        Student student = Student2Service.getStudentById(id);
        System.out.println(student);
       return student;

//    String  sql = "select id,name,age,tel,sex from student WHERE id=:id ";
//    Map<String, Object>map = new HashMap<>();
//    map.put("id",id);
//    RowMapper Studentmapper = new StudentsRowMapper();
//
//    List<Student> students = namedParameterJdbcTemplate.query(sql, map, Studentmapper);
//        return students.get(0);

    }

    @GetMapping("/getdto/{id}")
    public  Student2Dto  getStudentDtoById(@PathVariable Long id){
        Student student = Student2Service.getStudentById(id);
        Student2Dto student2Dto = new Student2Dto();
//        BeanUtils.copyProperties(student,student2Dto);//Spring
        student2Dto.setName(student.getName());
        student2Dto.setTel(student.getTel());
        System.out.println(student);
        return student2Dto;

//    String  sql = "select id,name,age,tel,sex from student WHERE id=:id ";
//    Map<String, Object>map = new HashMap<>();
//    map.put("id",id);
//    RowMapper Studentmapper = new StudentsRowMapper();
//
//    List<Student> students = namedParameterJdbcTemplate.query(sql, map, Studentmapper);
//        return students.get(0);

    }
    @GetMapping("/getall")
    public  List<Student> getALLStudents(){
        List<Student> students = Student2Service.getALLStudents();

 //        String sql ="select id,name,age,tel,sex from student";
//       Map<String, Object>map = new HashMap<>();
//        RowMapper rowMapper = new StudentsRowMapper();
//        List<Student> students = namedParameterJdbcTemplate.query(sql,rowMapper);
       return students;

    }

    @GetMapping("/getalldto")
    public  List<Student2Dto> getALLStudentsDto(){
        List<Student> students = Student2Service.getALLStudents();
        List<Student2Dto> student2Dtos = new ArrayList<>();
        for (Student student : students) {
            Student2Dto student2Dto = new Student2Dto();
            BeanUtils.copyProperties(student,student2Dto);
            student2Dtos.add(student2Dto);
        }
        //        String sql ="select id,name,age,tel,sex from student";
//       Map<String, Object>map = new HashMap<>();
//        RowMapper rowMapper = new StudentsRowMapper();
//        List<Student> students = namedParameterJdbcTemplate.query(sql,rowMapper);
        return student2Dtos;

    }
    @PostMapping("/insert")
    public String saveStudent(@RequestBody Student student){
//        String ok = Student2Service.saveStudent(student);
//        String sql = "insert into student (name, age, tel, sex) values (:name,:age,:tel,:sex)";
//        Map<String, Object>map = new HashMap<>();
//        map.put("name",student.getName());
//        map.put("age",student.getAge());
//        map.put("tel",student.getTel());
//        map.put("sex",student.getSex());
//        namedParameterJdbcTemplate.update(sql,map);

        return Student2Service.saveStudent(student);
    }
    @PostMapping("/insertlots")
    public String saveStudents(@RequestBody List<Student> students){
            String studentok = Student2Service.saveStudents(students);
//        String sql = "insert into student(name,age,tel,sex)VALUES(:name,:age,:tel,:sex)";
//        Map<String, Object>map = new HashMap<>();
//        MapSqlParameterSource[] mapSqlParameterSource = new MapSqlParameterSource[students.size()];
//        for(int i=0;i<mapSqlParameterSource.length;i++){
//            Student student = students.get(i);
//            mapSqlParameterSource[i] = new MapSqlParameterSource();
//            mapSqlParameterSource[i].addValue("name",student.getName());
//            mapSqlParameterSource[i].addValue("age",student.getAge());
//            mapSqlParameterSource[i].addValue("tel",student.getTel());
//            mapSqlParameterSource[i].addValue("sex",student.getSex());
//        }
//        namedParameterJdbcTemplate.batchUpdate(sql,mapSqlParameterSource);
        return studentok;

    }
    @PutMapping("/update/{id}")
    public  String updateStudents(@RequestBody  Student student ,@PathVariable Long id){
        String ok = Student2Service.updateStudent(student,id);
//        String sql = "UPDATE student SET name =:name,age=:age,tel=:tel,sex=:sex WHERE id=:id";
//        Map<String, Object>map = new HashMap<>();
//        map.put("id",id);
//        map.put("name",student.getName());
//        map.put("age",student.getAge());
//        map.put("tel",student.getTel());
//        map.put("sex", student.getSex());
//        namedParameterJdbcTemplate.update(sql,map);
        return ok;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentsById(@PathVariable Long id){

//        String sql = "DELETE FROM  student WHERE id=:id";
//        Map<String, Object> map = new HashMap<>();
//        map.put("id",id);
// //       RowMapper rowMapper = new StudentsRowMapper();
//        namedParameterJdbcTemplate.update(sql,map);
        return Student2Service.deleteStudentsById(id);
    }
}
