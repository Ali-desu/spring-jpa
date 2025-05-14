package com.sa.spring_tuto_web.dao;

import com.sa.spring_tuto_web.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminDAOCRUD extends CrudRepository<Admin, Long> {
    Admin findByAccountUsername(String username);
}