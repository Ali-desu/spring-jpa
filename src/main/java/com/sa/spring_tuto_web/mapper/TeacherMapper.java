package com.sa.spring_tuto_web.mapper;

import com.sa.spring_tuto_web.dto.ModuleDTO;
import com.sa.spring_tuto_web.dto.TeacherDTO;
import com.sa.spring_tuto_web.model.Module;
import com.sa.spring_tuto_web.model.Teacher;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeacherMapper {

    public TeacherDTO toDTO(Teacher teacher) {
        if (teacher == null) {
            return null;
        }
        List<ModuleDTO> moduleDTOs = teacher.getModule().stream()
                .map(this::toModuleDTO)
                .collect(Collectors.toList());
        return new TeacherDTO(teacher.getId(), teacher.getName(), moduleDTOs);
    }

    public List<TeacherDTO> toDTOList(List<Teacher> teachers) {
        return teachers.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Teacher toEntity(TeacherDTO teacherDTO) {
        if (teacherDTO == null) {
            return null;
        }
        Teacher teacher = new Teacher();
        teacher.setId(teacherDTO.getId());
        teacher.setName(teacherDTO.getName());
        List<Module> modules = teacherDTO.getModules().stream()
                .map(this::toModuleEntity)
                .collect(Collectors.toList());
        teacher.setModule(modules);
        return teacher;
    }

    private ModuleDTO toModuleDTO(Module module) {
        if (module == null) {
            return null;
        }
        return new ModuleDTO(module.getId(), module.getName());
    }

    private Module toModuleEntity(ModuleDTO moduleDTO) {
        if (moduleDTO == null) {
            return null;
        }
        return new Module(moduleDTO.getId(), moduleDTO.getName());
    }
}