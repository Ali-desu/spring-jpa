package com.sa.spring_tuto_web.dao.Impl;

import com.sa.spring_tuto_web.dao.StudentDAO;
import com.sa.spring_tuto_web.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addStudent(Student student) {
        String sql = "insert into student(name,email,major) values(?,?,?)";

        try {

            return jdbcTemplate.update(sql,
                    new Object[] { student.getName(), student.getEmail(), student.getMajor() });

        } catch (Exception e) {
            System.out.println("Error inserting student: " + e.getMessage());
            return 0;
        }
    }

    @Override
    public List<Student> getStudents() {
        String sql = "SELECT * FROM student";
        List<Student> students = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Student student = new Student();
            student.setId(rs.getLong("id"));
            student.setName(rs.getString("name"));
            student.setEmail(rs.getString("email"));
            student.setMajor(rs.getString("major"));
            return student;
        });
        return students;
    }

    @Override
    public Student getStudentById(Long id) {
        String sql = "SELECT * FROM student WHERE id = ?";
        Student student = jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Student s = new Student();
            s.setId(rs.getLong("id"));
            s.setName(rs.getString("name"));
            s.setEmail(rs.getString("email"));
            s.setMajor(rs.getString("major"));
            return s;
        });
        return student;
    }

    @Override
    public boolean updateStudent(Long id, Student updatedStudent) {
        String sql = "UPDATE student SET name = ?, email = ?, major = ? WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, updatedStudent.getName(), updatedStudent.getEmail(), updatedStudent.getMajor(), id);
        return rowsAffected > 0;
    }

    @Override
    public boolean deleteStudent(Long id) {
        String sql = "DELETE FROM student WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, id);
        return rowsAffected > 0;
    }
}
