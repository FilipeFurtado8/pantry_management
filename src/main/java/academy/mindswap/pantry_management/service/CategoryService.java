package academy.mindswap.pantry_management.service;


import academy.mindswap.pantry_management.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryByType(String type);

    Category addCategory(Category category);

    void deleteAll();

    void deleteCategorybyType(String name);
}
