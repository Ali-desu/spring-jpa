package com.sa.spring_tuto_web.service;

import com.sa.spring_tuto_web.dao.StudentDAO;
import com.sa.spring_tuto_web.dao.StudentDAOCRUD;
import com.sa.spring_tuto_web.dto.StudentDTO;
import com.sa.spring_tuto_web.mapper.StudentMapper;
import com.sa.spring_tuto_web.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentService {

    @Autowired
    private StudentDAOCRUD studentDAO;


    // Create
    public void addStudent(Student student) {
        studentDAO.save(student);
    }

    // Read all
    public List<StudentDTO> getAllStudents() {
        List<StudentDTO> studentsDTO = new ArrayList<>();
        List<Student> students = (List<Student>) studentDAO.findAll();
        for(Student student : students) {
            studentsDTO.add(StudentMapper.toDTO(student));
        }
        return studentsDTO;
    }

    // Read one
    public Student getStudentById(Long id) {
        Student student = studentDAO.findById(id).orElse(null);
        if (student != null) {
            System.out.println("Student found: " + student);
        } else {
            System.out.println("Student not found");
        }
        return student;
    }

    // Update
    public boolean updateStudent(Long id, Student updatedStudent) {
        Student student = studentDAO.findById(id).orElse(null);
        if (student != null) {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setMajor(updatedStudent.getMajor());
            student.setMark(updatedStudent.getMark());
            studentDAO.save(student);
            return true;
        } else {
            System.out.println("Student not found");
            return false;
        }
    }

    // Delete
    public boolean deleteStudent(Long id) {
        Student student = studentDAO.findById(id).orElse(null);
        if (student != null) {
            studentDAO.delete(student);
            return true;
        } else {
            System.out.println("Student not found");
            return false;
        }
    }

    public List<Student> findByMarkGreaterThan(double mark) {
        return studentDAO.findByMarkGreaterThanEqual(mark);
    }
    // find students by mark between
    public List<Student> findByMarkBetween(double minMark, double maxMark) {
        return studentDAO.findByMarkBetween(minMark, maxMark);
    }
}