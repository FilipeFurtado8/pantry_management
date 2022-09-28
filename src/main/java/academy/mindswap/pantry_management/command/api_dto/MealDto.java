package academy.mindswap.pantry_management.command.api_dto;

import java.io.Serializable;
import java.util.Objects;

public class MealDto implements Serializable {

    private String idMeal;
    private String strMeal;
    private String strDrinkAlternate;
    private String strCategory;
    private String strArea;
    private String strInstructions;
    private String strMealThumb;
    private String strTags;
    private String strYoutube;
    private String strIngredient1;
    private String strIngredient2;
    private String strIngredient3;
    private String strIngredient4;
    private String strIngredient5;
    private String strIngredient6;
    private String strIngredient7;
    private String strIngredient8;
    private String strIngredient9;
    private String strIngredient10;
    private String strIngredient11;
    private String strIngredient12;
    private String strIngredient13;
    private String strIngredient14;
    private String strIngredient15;
    private String strIngredient16;
    private String strIngredient17;
    private String strIngredient18;
    private String strIngredient19;
    private String strIngredient20;
    private String strMeasure1;
    private String strMeasure2;
    private String strMeasure3;
    private String strMeasure4;
    private String strMeasure5;
    private String strMeasure6;
    private String strMeasure7;
    private String strMeasure8;
    private String strMeasure9;
    private String strMeasure10;
    private String strMeasure11;
    private String strMeasure12;
    private String strMeasure13;
    private String strMeasure14;
    private String strMeasure15;
    private String strMeasure16;
    private String strMeasure17;
    private String strMeasure18;
    private String strMeasure19;
    private String strMeasure20;
    private String strSource;
    private String strImageSource;
    private String strCreativeCommonsConfirmed;
    private String dateModified;

    public String getIdMeal() {
        return idMeal;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public String getStrDrinkAlternate() {
        return strDrinkAlternate;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public String getStrArea() {
        return strArea;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public String getStrTags() {
        return strTags;
    }

    public String getStrYoutube() {
        return strYoutube;
    }

    public String getStrIngredient1() {
        return strIngredient1;
    }

    public String getStrIngredient2() {
        return strIngredient2;
    }

    public String getStrIngredient3() {
        return strIngredient3;
    }

    public String getStrIngredient4() {
        return strIngredient4;
    }

    public String getStrIngredient5() {
        return strIngredient5;
    }

    public String getStrIngredient6() {
        return strIngredient6;
    }

    public String getStrIngredient7() {
        return strIngredient7;
    }

    public String getStrIngredient8() {
        return strIngredient8;
    }

    public String getStrIngredient9() {
        return strIngredient9;
    }

    public String getStrIngredient10() {
        return strIngredient10;
    }

    public String getStrIngredient11() {
        return strIngredient11;
    }

    public String getStrIngredient12() {
        return strIngredient12;
    }

    public String getStrIngredient13() {
        return strIngredient13;
    }

    public String getStrIngredient14() {
        return strIngredient14;
    }

    public String getStrIngredient15() {
        return strIngredient15;
    }

    public String getStrIngredient16() {
        return strIngredient16;
    }

    public String getStrIngredient17() {
        return strIngredient17;
    }

    public String getStrIngredient18() {
        return strIngredient18;
    }

    public String getStrIngredient19() {
        return strIngredient19;
    }

    public String getStrIngredient20() {
        return strIngredient20;
    }

    public String getStrMeasure1() {
        return strMeasure1;
    }

    public String getStrMeasure2() {
        return strMeasure2;
    }

    public String getStrMeasure3() {
        return strMeasure3;
    }

    public String getStrMeasure4() {
        return strMeasure4;
    }

    public String getStrMeasure5() {
        return strMeasure5;
    }

    public String getStrMeasure6() {
        return strMeasure6;
    }

    public String getStrMeasure7() {
        return strMeasure7;
    }

    public String getStrMeasure8() {
        return strMeasure8;
    }

    public String getStrMeasure9() {
        return strMeasure9;
    }

    public String getStrMeasure10() {
        return strMeasure10;
    }

    public String getStrMeasure11() {
        return strMeasure11;
    }

    public String getStrMeasure12() {
        return strMeasure12;
    }

    public String getStrMeasure13() {
        return strMeasure13;
    }

    public String getStrMeasure14() {
        return strMeasure14;
    }

    public String getStrMeasure15() {
        return strMeasure15;
    }

    public String getStrMeasure16() {
        return strMeasure16;
    }

    public String getStrMeasure17() {
        return strMeasure17;
    }

    public String getStrMeasure18() {
        return strMeasure18;
    }

    public String getStrMeasure19() {
        return strMeasure19;
    }

    public String getStrMeasure20() {
        return strMeasure20;
    }

    public String getStrSource() {
        return strSource;
    }

    public String getStrImageSource() {
        return strImageSource;
    }

    public String getStrCreativeCommonsConfirmed() {
        return strCreativeCommonsConfirmed;
    }

    public String getDateModified() {
        return dateModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealDto mealDto = (MealDto) o;
        return Objects.equals(idMeal, mealDto.idMeal) && Objects.equals(strMeal, mealDto.strMeal) && Objects.equals(strDrinkAlternate, mealDto.strDrinkAlternate) && Objects.equals(strCategory, mealDto.strCategory) && Objects.equals(strArea, mealDto.strArea) && Objects.equals(strInstructions, mealDto.strInstructions) && Objects.equals(strMealThumb, mealDto.strMealThumb) && Objects.equals(strTags, mealDto.strTags) && Objects.equals(strYoutube, mealDto.strYoutube) && Objects.equals(strIngredient1, mealDto.strIngredient1) && Objects.equals(strIngredient2, mealDto.strIngredient2) && Objects.equals(strIngredient3, mealDto.strIngredient3) && Objects.equals(strIngredient4, mealDto.strIngredient4) && Objects.equals(strIngredient5, mealDto.strIngredient5) && Objects.equals(strIngredient6, mealDto.strIngredient6) && Objects.equals(strIngredient7, mealDto.strIngredient7) && Objects.equals(strIngredient8, mealDto.strIngredient8) && Objects.equals(strIngredient9, mealDto.strIngredient9) && Objects.equals(strIngredient10, mealDto.strIngredient10) && Objects.equals(strIngredient11, mealDto.strIngredient11) && Objects.equals(strIngredient12, mealDto.strIngredient12) && Objects.equals(strIngredient13, mealDto.strIngredient13) && Objects.equals(strIngredient14, mealDto.strIngredient14) && Objects.equals(strIngredient15, mealDto.strIngredient15) && Objects.equals(strIngredient16, mealDto.strIngredient16) && Objects.equals(strIngredient17, mealDto.strIngredient17) && Objects.equals(strIngredient18, mealDto.strIngredient18) && Objects.equals(strIngredient19, mealDto.strIngredient19) && Objects.equals(strIngredient20, mealDto.strIngredient20) && Objects.equals(strMeasure1, mealDto.strMeasure1) && Objects.equals(strMeasure2, mealDto.strMeasure2) && Objects.equals(strMeasure3, mealDto.strMeasure3) && Objects.equals(strMeasure4, mealDto.strMeasure4) && Objects.equals(strMeasure5, mealDto.strMeasure5) && Objects.equals(strMeasure6, mealDto.strMeasure6) && Objects.equals(strMeasure7, mealDto.strMeasure7) && Objects.equals(strMeasure8, mealDto.strMeasure8) && Objects.equals(strMeasure9, mealDto.strMeasure9) && Objects.equals(strMeasure10, mealDto.strMeasure10) && Objects.equals(strMeasure11, mealDto.strMeasure11) && Objects.equals(strMeasure12, mealDto.strMeasure12) && Objects.equals(strMeasure13, mealDto.strMeasure13) && Objects.equals(strMeasure14, mealDto.strMeasure14) && Objects.equals(strMeasure15, mealDto.strMeasure15) && Objects.equals(strMeasure16, mealDto.strMeasure16) && Objects.equals(strMeasure17, mealDto.strMeasure17) && Objects.equals(strMeasure18, mealDto.strMeasure18) && Objects.equals(strMeasure19, mealDto.strMeasure19) && Objects.equals(strMeasure20, mealDto.strMeasure20) && Objects.equals(strSource, mealDto.strSource) && Objects.equals(strImageSource, mealDto.strImageSource) && Objects.equals(strCreativeCommonsConfirmed, mealDto.strCreativeCommonsConfirmed) && Objects.equals(dateModified, mealDto.dateModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMeal, strMeal, strDrinkAlternate, strCategory, strArea, strInstructions, strMealThumb, strTags, strYoutube, strIngredient1, strIngredient2, strIngredient3, strIngredient4, strIngredient5, strIngredient6, strIngredient7, strIngredient8, strIngredient9, strIngredient10, strIngredient11, strIngredient12, strIngredient13, strIngredient14, strIngredient15, strIngredient16, strIngredient17, strIngredient18, strIngredient19, strIngredient20, strMeasure1, strMeasure2, strMeasure3, strMeasure4, strMeasure5, strMeasure6, strMeasure7, strMeasure8, strMeasure9, strMeasure10, strMeasure11, strMeasure12, strMeasure13, strMeasure14, strMeasure15, strMeasure16, strMeasure17, strMeasure18, strMeasure19, strMeasure20, strSource, strImageSource, strCreativeCommonsConfirmed, dateModified);
    }
}