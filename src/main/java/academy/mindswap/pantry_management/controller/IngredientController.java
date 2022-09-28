package academy.mindswap.pantry_management.controller;

import academy.mindswap.pantry_management.command.ingredientDTO.CreateIngredientDTO;
import academy.mindswap.pantry_management.command.ingredientDTO.IngredientDTO;
import academy.mindswap.pantry_management.service.IngredientService;
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
@RequestMapping(path = "/ingredient")
@Slf4j
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public ResponseEntity<List<IngredientDTO>> getAllIngredients() {
        log.info("Getting all ingredients");
        return ResponseEntity.ok(ingredientService.getAllIngredients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredientDTO> getIngredientById(@PathVariable Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(ingredientService.getIngredientById(id));
    }

    @GetMapping("/{name}")
    public ResponseEntity<IngredientDTO> getIngredientByName(@PathVariable String name) {
        if (name == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(ingredientService.findByName(name));
    }

    @GetMapping("/date/{year},{month},{day}")
    public ResponseEntity<List<IngredientDTO>> getIngredientsByExpirationDate(@PathVariable Integer year,
                                                                              @PathVariable Integer month,
                                                                              @PathVariable Integer day) {
        if (year == null || month == null || day == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(ingredientService.findByExpirationDate(year, month, day));
    }

    @GetMapping("/quantity/{quantity}")
    public ResponseEntity<List<IngredientDTO>> getIngredientsByQuantity(@PathVariable Integer quantity) {
        if (quantity == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(ingredientService.getIngredientsByQuantity(quantity));
    }

    @PostMapping("/")
    public ResponseEntity<?> addIngredient(@Valid @RequestBody CreateIngredientDTO ingredient, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(ingredientService.addIngredient(ingredient));
    }

    @PutMapping("/{name}")
    private ResponseEntity<IngredientDTO> alterIngredient(@RequestBody CreateIngredientDTO ingredient, @PathVariable String name) {

        if (name == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        log.info("Updating ingredient");

        return ResponseEntity.ok(ingredientService.alterIngredient(ingredient, name));
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteAllIngredients() {
        ingredientService.deleteAllIngredients();
        return ResponseEntity.ok("All ingredients were deleted");
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteIngredientByName(@PathVariable String name) {
        ingredientService.deleteIngredientByName(name);
        return ResponseEntity.ok("The ingredient, " + name + ", was deleted!");
    }
}