package academy.mindswap.pantry_management.command.api_dto;

import java.io.Serializable;
import java.util.Arrays;

public class RecipeDto implements Serializable {


    private MealDto[] meals;

    public MealDto[] getMeals() {
        return meals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeDto recipeDto = (RecipeDto) o;
        return Arrays.equals(meals, recipeDto.meals);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(meals);
    }
}