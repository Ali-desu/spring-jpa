package com.sa.spring_tuto_web.dao;

import com.sa.spring_tuto_web.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentDAOCRUD extends CrudRepository<Student, Long> {
    List<Student> findByMarkGreaterThanEqual(double mark);

    List<Student> findByMarkBetween(double markAfter, double markBefore);
}
