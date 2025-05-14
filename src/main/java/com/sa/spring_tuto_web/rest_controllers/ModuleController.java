package com.sa.spring_tuto_web.rest_controllers;

import com.sa.spring_tuto_web.model.Module;
import com.sa.spring_tuto_web.model.Student;
import com.sa.spring_tuto_web.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/modules")
@CrossOrigin(origins = "*")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public List<Module> getModules() {
        return moduleService.getAllModules();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public Module getModuleById(@PathVariable("id") Long id) {
        return moduleService.getModuleById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Module createModule(@RequestBody Module module) {
        moduleService.saveModule(module);
        return module;
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Module updateModule(@PathVariable("id") Long id, @RequestBody Module module) {
        module.setId(id);
        moduleService.saveModule(module);
        return module;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, String> deleteModule(@PathVariable("id") Long id) {
        Map<String, String> response = new HashMap<>();
        moduleService.deleteModule(id);
        response.put("message", "Module deleted");
        return response;
    }

    @GetMapping("/{id}/students")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public List<Student> getEnrolledStudents(@PathVariable("id") Long id) {
        return moduleService.getEnrolledStudents(id);
    }
}