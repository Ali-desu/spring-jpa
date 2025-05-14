package com.sa.spring_tuto_web.mapper;

import com.sa.spring_tuto_web.dto.TeacherDTO;
import com.sa.spring_tuto_web.model.Module;
import com.sa.spring_tuto_web.model.Teacher;

import java.util.List;
import java.util.stream.Collectors;

public class TeacherMapper {
    public static TeacherDTO toDTO(Teacher teacher) {
        return new TeacherDTO(
                teacher.getId(),
                teacher.getName(),
                teacher.getEmail(),
                teacher.getAccount() != null ? teacher.getAccount().getUsername() : null,
                teacher.getModules() != null ? teacher.getModules().stream().map(Module::getId).collect(Collectors.toList()) : null
        );
    }

    public static List<TeacherDTO> toDTOList(List<Teacher> teachers) {
        return teachers.stream().map(TeacherMapper::toDTO).collect(Collectors.toList());
    }
}