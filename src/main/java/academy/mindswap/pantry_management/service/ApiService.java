package academy.mindswap.pantry_management.service;

public interface ApiService {
    Object getRecipesByIngredient(String ingredientName);

    Object getRecipesByName(String name);

    Object getRecipesByStock();
}
