package org.jog.crudinventory.persistence.repository;

import org.jog.crudinventory.persistence.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.EnumSet;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("SELECT c FROM Category c WHERE c.status =?1")

    Page<Category> findAllByStatus(Pageable pageable,Category.CategoryStatus categoryStatus);


}
