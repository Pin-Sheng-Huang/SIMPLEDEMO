package com.example.demo;

import com.example.demo.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-12 19:43
 * @LastEditTime: 2022-07-12 19:43
 */

public class StudentsRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getInt("id"));
        student.setAge(resultSet.getInt("age"));
        student.setSex(resultSet.getString("sex"));
        student.setName(resultSet.getString("name"));
        student.setTel(resultSet.getLong("tel"));
        return student;
    }
}
