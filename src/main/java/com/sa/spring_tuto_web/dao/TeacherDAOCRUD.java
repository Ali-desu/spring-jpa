package com.sa.spring_tuto_web.dao;

import com.sa.spring_tuto_web.model.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherDAOCRUD extends CrudRepository<Teacher, Long> {
}
