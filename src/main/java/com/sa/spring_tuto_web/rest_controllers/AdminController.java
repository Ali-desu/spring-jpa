package com.sa.spring_tuto_web.rest_controllers;

import com.sa.spring_tuto_web.model.Admin;
import com.sa.spring_tuto_web.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin(origins = "*")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Admin> getAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Admin getAdminById(@PathVariable("id") Long id) {
        return adminService.getAdminById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Admin createAdmin(@RequestBody Admin admin) {
        adminService.saveAdmin(admin);
        return admin;
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Admin updateAdmin(@PathVariable("id") Long id, @RequestBody Admin admin) {
        admin.setId(id);
        adminService.saveAdmin(admin);
        return admin;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, String> deleteAdmin(@PathVariable("id") Long id) {
        Map<String, String> response = new HashMap<>();
        adminService.deleteAdmin(id);
        response.put("message", "Admin deleted");
        return response;
    }
}