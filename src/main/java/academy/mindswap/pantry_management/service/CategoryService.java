package academy.mindswap.pantry_management.service;


import academy.mindswap.pantry_management.command.categoryDTO.CategoryDTO;
import academy.mindswap.pantry_management.command.categoryDTO.CreateCategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByType(String type);

    CategoryDTO addCategory(CreateCategoryDTO createCategoryDTO);

    void deleteAll();

    void deleteCategoryByType(String name);

    CategoryDTO alterCategory(CreateCategoryDTO createCategoryDTO, String name);
}
