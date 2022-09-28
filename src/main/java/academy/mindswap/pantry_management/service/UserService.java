package academy.mindswap.pantry_management.service;

import academy.mindswap.pantry_management.command.ingredientDTO.CreateIngredientDTO;
import academy.mindswap.pantry_management.command.ingredientDTO.IngredientDTO;
import academy.mindswap.pantry_management.model.Ingredient;
import academy.mindswap.pantry_management.model.User;

import java.util.List;

public interface UserService {

    List<User> getUser();

    IngredientDTO alterIngredient(CreateIngredientDTO ingredient, String name);
}
