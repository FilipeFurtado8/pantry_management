package academy.mindswap.pantry_management.service;

import academy.mindswap.pantry_management.model.Category;
import academy.mindswap.pantry_management.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
         log.info("Getting all categories");
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryByType(String type) {
        return categoryRepository.findAll().stream()
                .filter(category -> category.getType().equals(type))
                .findFirst().orElseThrow();
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteAll() {
        categoryRepository.deleteAll();
    }

    @Override
    public void deleteCategorybyType(String name) {
        categoryRepository.delete(getCategoryByType(name));
    }
}
