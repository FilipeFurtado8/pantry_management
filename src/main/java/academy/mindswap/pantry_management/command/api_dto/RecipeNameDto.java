package academy.mindswap.pantry_management.command.api_dto;

import java.io.Serializable;
import java.util.Arrays;

public class RecipeNameDto implements Serializable {

    private MealNameDto[] meals;

    public MealNameDto[] getMeals() {
        return meals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeNameDto that = (RecipeNameDto) o;
        return Arrays.equals(meals, that.meals);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(meals);
    }
}