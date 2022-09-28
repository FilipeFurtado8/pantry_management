package academy.mindswap.pantry_management.controller;

import academy.mindswap.pantry_management.command.api_dto.RecipeDto;
import academy.mindswap.pantry_management.command.api_dto.RecipeNameDto;
import academy.mindswap.pantry_management.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import static academy.mindswap.pantry_management.utils.Messages.*;

@RestController
@RequestMapping(RECIPE)
@Slf4j
public class ApiController {

    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping(RECIPE_BY_INGREDIENT)
    public ResponseEntity<RecipeNameDto> getRecipesByIngredient(@PathVariable String ingredientName) {
        if (ingredientName == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(apiService.getRecipesByIngredient(ingredientName));
    }

    @GetMapping(NAME)
    public ResponseEntity<RecipeDto> getRecipesByName(@PathVariable String name) {
        if (name == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        log.info(GET_RECIPE_BY_NAME);
        return ResponseEntity.ok(apiService.getRecipesByName(name));
    }

    @GetMapping(RECIPE_BY_STOCK)
    public ResponseEntity<Set<RecipeNameDto>> getRecipesByStock() {
        log.info(GET_RECIPE_BY_STOCK);
        return ResponseEntity.ok(apiService.getRecipesByStock());
    }
}