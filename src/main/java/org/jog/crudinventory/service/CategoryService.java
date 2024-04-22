package org.jog.crudinventory.service;

import org.jog.crudinventory.dto.CategoryDTO;
import org.jog.crudinventory.persistence.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoryService {

    Page<Category> findAll(Pageable pageable);

    Optional<Category> findById(Integer categoryId);

    Category createOne(CategoryDTO categoryDTO);

    Category updateOne(Integer categoryId, CategoryDTO categoryDTO);

    Category disableOne(Integer categoryId);
}
