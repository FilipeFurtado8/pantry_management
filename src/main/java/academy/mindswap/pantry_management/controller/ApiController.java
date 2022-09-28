package academy.mindswap.pantry_management.controller;

import academy.mindswap.pantry_management.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe")
@Slf4j
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
        log.info("Getting recipes by name");
        return apiService.getRecipesByName(name);
    }

    @GetMapping("/stock")
    public Object getRecipesByStock(){
        log.info("Getting recipes by stock");
        return apiService.getRecipesByStock();
    }
}