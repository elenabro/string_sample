package com.example.spring_demo1.service;

import com.example.spring_demo1.dao.StudentDAO;
import com.example.spring_demo1.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentDAO studentDAO;


    @Autowired
    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void registerStudent(Student student){
        studentDAO.save(student);
    }
    public void deleteStudent(int id) {
        studentDAO.delete(id);
    }

    public void updateStudent(Student student) {
        studentDAO.update(student);
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAll();
    }
}
