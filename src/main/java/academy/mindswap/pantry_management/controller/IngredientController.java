package academy.mindswap.pantry_management.controller;

import academy.mindswap.pantry_management.model.Ingredient;
import academy.mindswap.pantry_management.service.IngredientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/ingredient")
@Slf4j
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<Ingredient> getAllIngredients() {
        log.info("Getting all ingredients");
        return ingredientService.getAllIngredients();
    }
}