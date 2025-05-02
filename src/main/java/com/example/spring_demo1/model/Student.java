package com.example.spring_demo1.model;

import java.util.Date;

public class Student {
    private int id;
    private String first_name;
    private String last_name;
    private Date birthdate;
    private String email;

    public Student() {}

    public Student(int id, String first_name, String last_name, Date birthdate, String email) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birthdate = birthdate;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
