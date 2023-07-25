package ru.vsevolod.test.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vsevolod.test.entity.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    Optional<Category> findCategoryByName(String categoryName);
}
