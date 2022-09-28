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

@RestController
@RequestMapping(path = "/category")
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {

        log.info("Getting all categories");

        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{type}")
    public ResponseEntity<CategoryDTO> getCategoryByType(@PathVariable String type) {

        if (type == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        log.info("Getting category by name");

        return ResponseEntity.ok(categoryService.getCategoryByType(type));
    }

    @PostMapping("/")
    public ResponseEntity<?> addCategory(@Valid @RequestBody CreateCategoryDTO CreateCategoryDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });

            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(categoryService.addCategory(CreateCategoryDTO));
    }

    @PutMapping("/{name}")
    private ResponseEntity<CategoryDTO> alterIngredient(@RequestBody CreateCategoryDTO createCategoryDTO, @PathVariable String name) {

        if (name == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        log.info("Updating category");

        return ResponseEntity.ok(categoryService.alterCategory(createCategoryDTO, name));
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteAll() {

        categoryService.deleteAll();

        return ResponseEntity.ok("All categories were deleted!");
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteCategoryByType(@PathVariable String name) {

        categoryService.deleteCategoryByType(name);

        return ResponseEntity.ok("The category, " + name + ", was deleted!");
    }
}
