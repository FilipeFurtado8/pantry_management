package academy.mindswap.pantry_management.service;

import academy.mindswap.pantry_management.command.categoryDTO.CategoryConverter;
import academy.mindswap.pantry_management.command.categoryDTO.CategoryDTO;
import academy.mindswap.pantry_management.command.categoryDTO.CategoryWithoutIngredientDTO;
import academy.mindswap.pantry_management.command.categoryDTO.CreateCategoryDTO;
import academy.mindswap.pantry_management.model.Category;
import academy.mindswap.pantry_management.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static academy.mindswap.pantry_management.utils.Messages.ALL_CATEGORIES;
import static academy.mindswap.pantry_management.utils.Messages.UPDATING_CATEGORY;

@Service
@Slf4j
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        log.info(ALL_CATEGORIES);
        return categoryRepository.findAll().stream()
                .map(CategoryConverter::convertToDTO)
                .toList();
    }

    @Override
    public CategoryDTO getCategoryByType(String type) {
        return categoryRepository.findAll().stream()
                .filter(category -> category.getType().equals(type))
                .map(CategoryConverter::convertToDTO)
                .findFirst().orElseThrow();
    }

    @Override
    public CategoryWithoutIngredientDTO addCategory(CreateCategoryDTO createCategoryDTO) {
        Category category = CategoryConverter.convertCreateCategoryDTOToCategory(createCategoryDTO);
        Category category1 = categoryRepository.save(category);
        return CategoryConverter.convertToDTOWithoutIngredient(category1);
    }

    @Override
    public void deleteAll() {
        categoryRepository.deleteAll();
    }

    @Override
    public void deleteCategoryByType(String type) {
        categoryRepository.delete(categoryRepository.findAll().stream()
                .filter(category -> category.getType().equals(type))
                .findFirst().orElseThrow());
    }

    @Override
    public CategoryDTO alterCategory(CreateCategoryDTO createCategoryDTO, String name) {

        log.info(UPDATING_CATEGORY);
        CategoryConverter.convertCreateCategoryDTOToCategory(createCategoryDTO);

        Category category = categoryRepository.findAll().stream()
                .filter(category1 -> category1.getType().equals(name))
                .findFirst().orElseThrow();

        category.setType(createCategoryDTO.getType());

        categoryRepository.save(category);

        return CategoryConverter.convertToDTO(category);

    }
}
