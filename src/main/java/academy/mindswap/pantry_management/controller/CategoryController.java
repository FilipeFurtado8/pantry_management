package academy.mindswap.pantry_management.controller;

import academy.mindswap.pantry_management.model.Category;
import academy.mindswap.pantry_management.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/category")
@Slf4j
public class CategoryController {


    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public List<Category> getAllCategories() {
        log.info("Getting all categories");
        return categoryService.getAllCategories();

    }
}
