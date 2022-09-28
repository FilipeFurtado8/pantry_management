package academy.mindswap.pantry_management.controller;

import academy.mindswap.pantry_management.command.categoryDTO.CategoryDTO;
import academy.mindswap.pantry_management.model.Category;
import academy.mindswap.pantry_management.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{type}")
    public Category getCategoryByType(@PathVariable String type){
        log.info("Getting category by name");
        return categoryService.getCategoryByType(type);
    }

    @PostMapping("/")
    public Category addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }

    @DeleteMapping("/")
    public void deleteAll(){
        categoryService.deleteAll();
    }

    @DeleteMapping("/{name}")
    public void deleteCategorybyType(@PathVariable String name){
        categoryService.deleteCategorybyType(name);
    }
}
