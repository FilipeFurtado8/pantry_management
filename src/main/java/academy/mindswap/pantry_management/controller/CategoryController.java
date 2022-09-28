package academy.mindswap.pantry_management.controller;

import academy.mindswap.pantry_management.command.categoryDTO.CategoryDTO;
import academy.mindswap.pantry_management.command.categoryDTO.CreateCategoryDTO;
import academy.mindswap.pantry_management.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static academy.mindswap.pantry_management.utils.Messages.*;

@RestController
@RequestMapping(path = CATEGORY)
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        log.info(ALL_CATEGORIES);
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping(CATEGORY_BY_TYPE)
    public ResponseEntity<CategoryDTO> getCategoryByType(@PathVariable String type) {
        if (type == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        log.info(GET_CATEGORY_BY_TYPE);
        return ResponseEntity.ok(categoryService.getCategoryByType(type));
    }

    @PostMapping(BAR)
    public ResponseEntity<?> addCategory(@Valid @RequestBody CreateCategoryDTO createCategoryDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(categoryService.addCategory(createCategoryDTO));
    }

    @PutMapping(NAME)
    private ResponseEntity<CategoryDTO> alterIngredient(@Valid @RequestBody CreateCategoryDTO createCategoryDTO, @PathVariable String name) {
        if (name == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        log.info(UPDATING_CATEGORY);
        return ResponseEntity.ok(categoryService.alterCategory(createCategoryDTO, name));
    }

    @DeleteMapping(BAR)
    public ResponseEntity<String> deleteAll() {
        categoryService.deleteAll();
        return ResponseEntity.ok(CATEGORIES_DELETED);
    }

    @DeleteMapping(NAME)
    public ResponseEntity<String> deleteCategoryByType(@PathVariable String name) {
        categoryService.deleteCategoryByType(name);
        return ResponseEntity.ok(THE_CATEGORY + name + WAS_DELETED);
    }
}