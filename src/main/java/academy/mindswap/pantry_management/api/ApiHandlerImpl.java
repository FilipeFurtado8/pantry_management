package academy.mindswap.pantry_management.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiHandlerImpl implements ApiHandler {

    private final int API_KEY = 9973533;
    private final List<Object> recipes = new ArrayList<>();

    @Override
    public Object getRecipesByIngredient(String ingredientName) {
        final String API_RESOURCE_URL = "https://www.themealdb.com/api/json/v1/1/filter.php?i=" + ingredientName;
        return new RestTemplate().getForObject(API_RESOURCE_URL, Object.class);
    }

    @Override
    public Object getRecipesByName(String name) {
        final String API_RESOURCE_URL = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + name;
        return new RestTemplate().getForObject(API_RESOURCE_URL, Object.class);
    }

    @Override
    public Object getRecipesByIngredients(List<List<String>> ingredients) {

        List<List<String>> temp = new ArrayList<>();

        for (int i = 0; i < ingredients.size(); i++) {

            temp.add(ingredients.get(i));

            final String API_RESOURCE_URL = "https://www.themealdb.com/api/json/v2/9973533/filter.php?i="
                    + temp.get(i).get(0) + ","
                    + temp.get(i).get(1) + ","
                    + temp.get(i).get(2);

            Object jsonFromMealApi = new RestTemplate().getForObject(API_RESOURCE_URL, Object.class);

            String stringJsonFromMealApi = jsonFromMealApi.toString();

            if (!stringJsonFromMealApi.contains("null")) {
                recipes.add(jsonFromMealApi);
            }
        }
        return recipes;
    }
}