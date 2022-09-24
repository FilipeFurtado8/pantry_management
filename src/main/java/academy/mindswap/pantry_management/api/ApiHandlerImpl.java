package academy.mindswap.pantry_management.api;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiHandlerImpl implements ApiHandler {

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
}
