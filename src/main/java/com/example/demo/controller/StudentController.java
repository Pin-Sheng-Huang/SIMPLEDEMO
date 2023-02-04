package com.example.demo.controller;

import com.example.demo.exception.AjaxResponse;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-12 15:55
 * @LastEditTime: 2022-07-12 15:55
 */
@Slf4j
@Controller
@RequestMapping("/rest1")
public class StudentController {
    @Resource
    StudentService studentService;

    @GetMapping(value = "/students/{id}",produces = "application/json;charset=utf-8")
    public @ResponseBody AjaxResponse getStudent(HttpServletResponse response, @PathVariable("id")Long id){

        Student student = studentService.getStudent(id);
        System.out.println(id);
        log.info("student:" + student);
//        if(student.getId()== null || id == null) {
//
//          return   AjaxResponse.noSuccess(student);
//        }
        return AjaxResponse.success(student);
    }
    @GetMapping("/students")
    public @ResponseBody AjaxResponse getAllStudent(){
        List<Student> students = studentService.getALL();
        log.info(String.valueOf(students));
        System.out.println(students);
        return AjaxResponse.success(students);
    }
    @PostMapping("/students")
    public @ResponseBody AjaxResponse saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        log.info("student:"+student);
        return AjaxResponse.success();
    }
    //TEST
//    @PutMapping("/students/{id}")
//    public @ResponseBody AjaxResponse updateStudent(Long id){
//        studentService.updateStudent1(id);
//        System.out.println(id);
//        return  AjaxResponse.success();
//    }
    @PutMapping("/students")
    public @ResponseBody AjaxResponse updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        log.info("student:"+student);
        return AjaxResponse.success();
    }
    @DeleteMapping("/students/{id}")
    public  @ResponseBody AjaxResponse deleteStudent(@PathVariable("id")Long id){
        studentService.deleteStudent(id);
        log.info("student:"+id);
        return AjaxResponse.success(id);


    }
}
