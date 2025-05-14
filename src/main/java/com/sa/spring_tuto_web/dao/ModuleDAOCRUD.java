package com.sa.spring_tuto_web.dao;

import com.sa.spring_tuto_web.model.Module;
import org.springframework.data.repository.CrudRepository;

public interface ModuleDAOCRUD extends CrudRepository<Module, Long> {
}