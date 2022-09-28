package academy.mindswap.pantry_management.command.api_dto;

import java.io.Serializable;
import java.util.Objects;

public class MealNameDto implements Serializable {

    private String strMeal;
    private String strMealThumb;
    private String idMeal;

    public String getStrMeal() {
        return strMeal;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public String getIdMeal() {
        return idMeal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealNameDto that = (MealNameDto) o;
        return Objects.equals(strMeal, that.strMeal) && Objects.equals(strMealThumb, that.strMealThumb) && Objects.equals(idMeal, that.idMeal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(strMeal, strMealThumb, idMeal);
    }
}