package com.sa.spring_tuto_web.service;

import com.sa.spring_tuto_web.dao.AccountDAOCRUD;
import com.sa.spring_tuto_web.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountDAOCRUD accountDAOCRUD;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveAccount(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        accountDAOCRUD.save(account);
    }

    public Account getAccountByUsername(String username) {
        return accountDAOCRUD.findByUsername(username);
    }

    public void deleteAccount(String username) {
        accountDAOCRUD.deleteById(username);
    }

    public Iterable<Account> getAllAccounts() {
        return accountDAOCRUD.findAll();
    }
}