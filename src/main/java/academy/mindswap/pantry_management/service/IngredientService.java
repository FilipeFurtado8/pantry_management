package academy.mindswap.pantry_management.service;

import academy.mindswap.pantry_management.model.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> getAllIngredients();


    Ingredient alterIngredient(Ingredient ingredient, String name);

    Ingredient findByName(String name);
}
