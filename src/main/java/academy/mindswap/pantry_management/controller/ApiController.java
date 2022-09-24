package academy.mindswap.pantry_management.controller;

import academy.mindswap.pantry_management.service.ApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe")
public class ApiController {

    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/byIngredient/{ingredientName}")
    public Object getRecipesByIngredient(@PathVariable String ingredientName){
        return apiService.getRecipesByIngredient(ingredientName);
    }

    @GetMapping("/{name}")
    public Object getRecipesByName(@PathVariable String name){
        return apiService.getRecipesByName(name);
    }
}