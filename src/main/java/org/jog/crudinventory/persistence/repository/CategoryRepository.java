package org.jog.crudinventory.persistence.repository;

import org.jog.crudinventory.persistence.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
