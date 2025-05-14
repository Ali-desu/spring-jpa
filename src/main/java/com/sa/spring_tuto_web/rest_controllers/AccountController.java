package com.sa.spring_tuto_web.rest_controllers;

import com.sa.spring_tuto_web.model.Account;
import com.sa.spring_tuto_web.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
@CrossOrigin(origins = "*")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping
    public Iterable<Account> getAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{username}")
    public Account getAccountByUsername(@PathVariable("username") String username) {
        return accountService.getAccountByUsername(username);
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        accountService.saveAccount(account);
        return account;
    }

    @DeleteMapping("/{username}")
    public Map<String, String> deleteAccount(@PathVariable("username") String username) {
        Map<String, String> response = new HashMap<>();
        accountService.deleteAccount(username);
        response.put("message", "Account deleted");
        return response;
    }
}