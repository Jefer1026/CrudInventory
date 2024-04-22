package org.jog.crudinventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.jog.crudinventory.dto.CategoryDTO;
import org.jog.crudinventory.exception.ObjectNofFoundException;
import org.jog.crudinventory.persistence.entity.Category;
import org.jog.crudinventory.persistence.repository.CategoryRepository;
import org.jog.crudinventory.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Optional<Category> findById(Integer categoryId) {
        return categoryRepository.findById(categoryId);
    }

    @Override
    public Category createOne(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setStatus(Category.CategoryStatus.ENABLED);

        return categoryRepository.save(category);
    }

    @Override
    public Category updateOne(Integer categoryId, CategoryDTO categoryDTO) {
        Category categoryFromDb = getCategoryNotFound(categoryId);
        categoryFromDb.setName(categoryDTO.getName());
        return categoryRepository.save(categoryFromDb);
    }

    @Override
    public Category disableOne(Integer categoryId) {
        Category categoryFromDb = getCategoryNotFound(categoryId);
        categoryFromDb.setStatus(Category.CategoryStatus.DISABLED);
        return categoryRepository.save(categoryFromDb);
    }

    private Category getCategoryNotFound(Integer categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ObjectNofFoundException("Category not found"));
    }
}
