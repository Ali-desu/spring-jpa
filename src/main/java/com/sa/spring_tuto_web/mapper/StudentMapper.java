package com.sa.spring_tuto_web.mapper;

import com.sa.spring_tuto_web.dto.StudentDTO;
import com.sa.spring_tuto_web.model.Student;

public class StudentMapper {


    public static StudentDTO toDTO(Student student) {
        if (student == null) {
            return null;
        }
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setMajor(student.getMajor());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setMark(student.getMark());
        return studentDTO;
    }

}
