package com.sa.spring_tuto_web.dto;

import java.util.ArrayList;
import java.util.List;

public class TeacherDTO {
    private Long id;
    private String name;
    private List<ModuleDTO> modules = new ArrayList<>();

    public TeacherDTO() {
    }

    public TeacherDTO(Long id, String name, List<ModuleDTO> modules) {
        this.id = id;
        this.name = name;
        this.modules = modules;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ModuleDTO> getModules() {
        return modules;
    }

    public void setModules(List<ModuleDTO> modules) {
        this.modules = modules;
    }
}