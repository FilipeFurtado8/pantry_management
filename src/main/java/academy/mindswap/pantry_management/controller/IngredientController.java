package academy.mindswap.pantry_management.controller;

import academy.mindswap.pantry_management.command.ingredientDTO.CreateIngredientDTO;
import academy.mindswap.pantry_management.command.ingredientDTO.IngredientDTO;
import academy.mindswap.pantry_management.service.IngredientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    public List<IngredientDTO> getAllIngredients() {
        log.info("Getting all ingredients");
        return ingredientService.getAllIngredients();
    }

    @PostMapping("/")
    public IngredientDTO addIngredient(@RequestBody CreateIngredientDTO ingredient){
        return ingredientService.addIngredient(ingredient);
    }

    @DeleteMapping("/")
    public void deleteAllIngredients(){
        ingredientService.deleteAllIngredients();
    }

    @DeleteMapping("/{name}")
    public void deleteIngredientByName(@PathVariable String name){
        ingredientService.deleteIngredientByName(name);
    }

    @GetMapping("/{name}")
    public IngredientDTO getIngredientByName(@PathVariable String name){
        return ingredientService.findByName(name);
    }

    @GetMapping("/date/{year},{month},{day}")
    public List<IngredientDTO> getIngredientsByExpirationDate(@PathVariable Integer year, @PathVariable Integer month, @PathVariable Integer day){
        return ingredientService.findByExpirationDate(year, month, day);
    }
//TODO: Query paramether

    @GetMapping("/quantity/{quantity}")
    public List<IngredientDTO> getIngredientsByQuantity(@PathVariable Integer quantity){
        return ingredientService.getIngredientsByQuantity(quantity);
    }
}