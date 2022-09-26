package academy.mindswap.pantry_management.api;

import java.util.List;

public interface ApiHandler {
    Object getRecipesByIngredient(String ingredientName);

    Object getRecipesByName(String name);

    Object getRecipesByIngredients (List<List<String>> ingredients);
}
