package com.sa.spring_tuto_web.service;

import com.sa.spring_tuto_web.dao.ModuleDAOCRUD;
import com.sa.spring_tuto_web.model.Module;
import com.sa.spring_tuto_web.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModuleService {
    @Autowired
    private ModuleDAOCRUD moduleDAOCRUD;

    public void saveModule(Module module) {
        moduleDAOCRUD.save(module);
    }

    public Module getModuleById(Long id) {
        return moduleDAOCRUD.findById(id).orElse(null);
    }

    public void deleteModule(Long id) {
        moduleDAOCRUD.deleteById(id);
    }

    public List<Module> getAllModules() {
        List<Module> modules = new ArrayList<>();
        moduleDAOCRUD.findAll().forEach(modules::add);
        return modules;
    }

    public List<Student> getEnrolledStudents(Long moduleId) {
        Module module = getModuleById(moduleId);
        return module != null ? module.getStudents() : new ArrayList<>();
    }
}