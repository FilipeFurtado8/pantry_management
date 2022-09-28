package academy.mindswap.pantry_management.service;

import academy.mindswap.pantry_management.command.ingredientDTO.CreateIngredientDTO;
import academy.mindswap.pantry_management.command.ingredientDTO.IngredientDTO;
import academy.mindswap.pantry_management.model.Ingredient;

import java.util.List;

public interface IngredientService {
    List<IngredientDTO> getAllIngredients();
    
    IngredientDTO alterIngredient(CreateIngredientDTO ingredient, String name);
    
    IngredientDTO addIngredient(CreateIngredientDTO ingredient);

    void deleteAllIngredients();

    void deleteIngredientByName(String name);

    IngredientDTO findByName(String name);

    List<IngredientDTO> findByExpirationDate(Integer year, Integer month, Integer day);

    List<IngredientDTO> getIngredientsByQuantity(Integer quantity);
}
