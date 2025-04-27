package com.sa.spring_tuto_web.service;

import com.sa.spring_tuto_web.dao.Impl.StudentDAOImpl;
import com.sa.spring_tuto_web.dao.StudentDAO;
import com.sa.spring_tuto_web.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;


    // Create
    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    // Read all
    public List<Student> getAllStudents() {
        return studentDAO.getStudents();
    }

    // Read one
    public Student getStudentById(Long id) {
        return studentDAO.getStudentById(id);
    }

    // Update
    public boolean updateStudent(Long id, Student updatedStudent) {
        boolean res = studentDAO.updateStudent(id, updatedStudent);
        if (res) {
            System.out.println("Student updated successfully");
        } else {
            System.out.println("Student not found");
        }
        return res;
    }

    // Delete
    public boolean deleteStudent(Long id) {
        return studentDAO.deleteStudent(id);
    }
}