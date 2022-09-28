package academy.mindswap.pantry_management.service;

import academy.mindswap.pantry_management.command.api_dto.RecipeDto;
import academy.mindswap.pantry_management.command.api_dto.RecipeNameDto;

import java.util.Set;

public interface ApiService {
    RecipeNameDto getRecipesByIngredient(String ingredientName);

    RecipeDto getRecipesByName(String name);

    Set<RecipeNameDto> getRecipesByStock();
}
