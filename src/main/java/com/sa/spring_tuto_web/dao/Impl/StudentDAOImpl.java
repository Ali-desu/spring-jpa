package com.sa.spring_tuto_web.dao.Impl;

import com.sa.spring_tuto_web.dao.StudentDAO;
import com.sa.spring_tuto_web.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getStudents() {
        return entityManager.createQuery("FROM Student", Student.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Student getStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public boolean updateStudent(Long id, Student updatedStudent) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setMajor(updatedStudent.getMajor());
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteStudent(Long id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
            return true;
        }
        return false;
    }
}
