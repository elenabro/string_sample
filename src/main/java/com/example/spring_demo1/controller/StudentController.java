package com.example.spring_demo1.controller;

import com.example.spring_demo1.model.Student;
import com.example.spring_demo1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static jdk.internal.org.jline.utils.Colors.s;

@Component
public class StudentController {

    private final StudentService studentService;


    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public void createStudent() {
        Student s = new Student(0, "Tim", "Test", new Date(), "test123@email.com") ;
        studentService.registerStudent(s);
    }
public void showAllStudents() {
        List<Student> students = studentService.getAllStudents();
        students.forEach(s-> System.out.println(
                s.getFirst_name() + " " + s.getLast_name() + " " + s.getBirthdate() + " " + s.getEmail()));

        };


}


