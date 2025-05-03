package com.example.spring_demo1.dao;

import com.example.spring_demo1.model.Student;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository

public class StudentDAO {
    private final String JDBC_URL = "jdbc:postgresql://localhost:5432/student_dev";
    private final String JDBC_USER = "postgres";
    private final String JDBC_PASS = "test123";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }

    public void save(Student student){
        String sql = "INSERT INTO students (first_name, last_name, birthdate, email) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement stmt= conn.prepareStatement(sql)) {
            stmt.setString(1, student.getFirst_name());
            stmt.setString(2, student.getLast_name());
            stmt.setDate(3, new Date(student.getBirthdate().getTime()));
            stmt.setString(4, student.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Student student) {
        String sql = "UPDATE students SET first_name = ?, last_name = ?, birthdate = ?, email = ? WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getFirst_name());
            stmt.setString(2, student.getLast_name());
            stmt.setDate(3, new java.sql.Date(student.getBirthdate().getTime()));
            stmt.setString(4, student.getEmail());
            stmt.setInt(5, student.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAll(){
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try( Connection conn = getConnection();
             Statement stmt= conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Student s = new Student(rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getDate("birthdate"),
                        rs.getString("email"));
                students.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

}
