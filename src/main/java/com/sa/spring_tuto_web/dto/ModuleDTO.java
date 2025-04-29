package com.sa.spring_tuto_web.dto;

public class ModuleDTO {
    private Long id;
    private String name;

    public ModuleDTO() {
    }

    public ModuleDTO(Long id, String name) {
        this.id = id;
        this.name = name;
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
}