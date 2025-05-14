package com.sa.spring_tuto_web.service;

import com.sa.spring_tuto_web.dao.AdminDAOCRUD;
import com.sa.spring_tuto_web.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminDAOCRUD adminDAOCRUD;

    public void saveAdmin(Admin admin) {
        adminDAOCRUD.save(admin);
    }

    public Admin getAdminById(Long id) {
        return adminDAOCRUD.findById(id).orElse(null);
    }

    public Admin getAdminByUsername(String username) {
        return adminDAOCRUD.findByAccountUsername(username);
    }

    public void deleteAdmin(Long id) {
        adminDAOCRUD.deleteById(id);
    }

    public List<Admin> getAllAdmins() {
        List<Admin> admins = new ArrayList<>();
        adminDAOCRUD.findAll().forEach(admins::add);
        return admins;
    }
}