package com.sa.spring_tuto_web.dao;

import com.sa.spring_tuto_web.model.Student;

import java.util.List;

public interface StudentDAO {
    int addStudent(Student student);
    List<Student> getStudents();
    Student getStudentById(Long id);
    boolean updateStudent(Long id, Student updatedStudent);
    boolean deleteStudent(Long id);
}
