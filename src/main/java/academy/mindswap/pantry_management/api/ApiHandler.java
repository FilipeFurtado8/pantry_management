package academy.mindswap.pantry_management.api;

public interface ApiHandler {
    Object getRecipesByIngredient(String ingredientName);

    Object getRecipesByName(String name);
}
