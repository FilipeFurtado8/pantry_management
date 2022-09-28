package academy.mindswap.pantry_management.api;

import academy.mindswap.pantry_management.command.api_dto.MealNameDto;
import academy.mindswap.pantry_management.command.api_dto.RecipeDto;
import academy.mindswap.pantry_management.command.api_dto.RecipeNameDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ApiHandlerImpl implements ApiHandler {

    private final Set<RecipeNameDto> recipes = new HashSet<>();

    @Override
    public RecipeNameDto getRecipesByIngredient(String ingredientName) {
        final String API_RESOURCE_URL = "https://www.themealdb.com/api/json/v1/1/filter.php?i=" + ingredientName;
        return new RestTemplate().getForObject(API_RESOURCE_URL, RecipeNameDto.class);
    }

    @Override
    public RecipeDto getRecipesByName(String name) {
        final String API_RESOURCE_URL = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + name;
        return new RestTemplate().getForObject(API_RESOURCE_URL, RecipeDto.class);
    }

    @Override
    public Set<RecipeNameDto> getRecipesByIngredients(List<List<String>> ingredients) {

        MealNameDto meal = new MealNameDto();

        List<List<String>> temp = new ArrayList<>();

        for (int i = 0; i < ingredients.size(); i++) {

            temp.add(ingredients.get(i));

            final String API_RESOURCE_URL = "https://www.themealdb.com/api/json/v2/9973533/filter.php?i="
                    + temp.get(i).get(0) + ","
                    + temp.get(i).get(1) + ","
                    + temp.get(i).get(2);

            RecipeNameDto jsonFromMealApi = new RestTemplate().getForObject(API_RESOURCE_URL, RecipeNameDto.class);

            if(jsonFromMealApi.getMeals() != null){
                recipes.add(jsonFromMealApi);
            }
        }
        return recipes;
    }
}