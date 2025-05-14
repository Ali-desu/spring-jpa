package com.sa.spring_tuto_web.dao;

import com.sa.spring_tuto_web.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountDAOCRUD extends CrudRepository<Account, String> {
    Account findByUsername(String username);
}