package com.example.spring_demo1;

import com.example.spring_demo1.config.AppConfig;
import com.example.spring_demo1.controller.StudentController;
import com.example.spring_demo1.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentController studentController = context.getBean(StudentController.class);

        studentController.createStudent();

        // Update the student
        Student updatedStudent = new Student(5, "UpdatedFirstName", "UpdatedLastName", new java.util.Date(), "updated8@email.com");
        studentController.updateStudent(updatedStudent);

        // Delete the student
        studentController.deleteStudent(9);

        studentController.showAllStudents();

    }
}
