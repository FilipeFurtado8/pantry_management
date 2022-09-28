package academy.mindswap.pantry_management.service;

import academy.mindswap.pantry_management.model.Category;
import academy.mindswap.pantry_management.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Cacheable(value = "category", key = "#id")
    @Override
    public List<Category> getAllCategories() {
         log.info("Getting all categories");
        return categoryRepository.findAll();
    }
}
