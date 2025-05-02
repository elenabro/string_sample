package com.example.spring_demo1;

import com.example.spring_demo1.config.AppConfig;
import com.example.spring_demo1.controller.StudentController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentController studentController = context.getBean(StudentController.class);

        studentController.createStudent();

        studentController.showAllStudents();

    }
}
