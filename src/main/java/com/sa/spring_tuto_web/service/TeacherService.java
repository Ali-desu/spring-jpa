package com.sa.spring_tuto_web.service;

import com.sa.spring_tuto_web.dao.TeacherDAOCRUD;
import com.sa.spring_tuto_web.dto.TeacherDTO;
import com.sa.spring_tuto_web.mapper.TeacherMapper;
import com.sa.spring_tuto_web.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeacherService {

    @Autowired
    private TeacherDAOCRUD teacherDAOCRUD;


    public void saveTeacher(Teacher teacher) {
        teacherDAOCRUD.save(teacher);
    }

    public Teacher getTeacherById(Long id) {
        return teacherDAOCRUD.findById(id).orElse(null);
    }

    public Teacher getTeacherByUsername(String username) {
        return teacherDAOCRUD.findByAccountUsername(username);
    }

    public void deleteTeacherById(Long id) {
        teacherDAOCRUD.deleteById(id);
    }

    public List<TeacherDTO> getAllTeachers() {
        List<Teacher> teachers = (List<Teacher>) teacherDAOCRUD.findAll();
        return TeacherMapper.toDTOList(teachers);
    }

    public void updateTeacher(Teacher teacher) {
        teacherDAOCRUD.save(teacher);
    }
}