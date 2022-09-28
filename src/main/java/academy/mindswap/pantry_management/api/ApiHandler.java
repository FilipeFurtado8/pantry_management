package academy.mindswap.pantry_management.api;

import academy.mindswap.pantry_management.command.api_dto.RecipeDto;
import academy.mindswap.pantry_management.command.api_dto.RecipeNameDto;

import java.util.List;
import java.util.Set;

public interface ApiHandler {
    RecipeNameDto getRecipesByIngredient(String ingredientName);

    RecipeDto getRecipesByName(String name);

    Set<RecipeNameDto> getRecipesByIngredients (List<List<String>> ingredients);
}
