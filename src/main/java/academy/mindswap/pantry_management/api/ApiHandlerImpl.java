package academy.mindswap.pantry_management.api;

import academy.mindswap.pantry_management.command.api_dto.MealNameDto;
import academy.mindswap.pantry_management.command.api_dto.RecipeDto;
import academy.mindswap.pantry_management.command.api_dto.RecipeNameDto;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@EnableScheduling
public class ApiHandlerImpl implements ApiHandler {


    @Override
    @Cacheable(value = "ingredient")
    public RecipeNameDto getRecipesByIngredient(String ingredientName) {
        System.out.println("without cache1");
        final String API_RESOURCE_URL = "https://www.themealdb.com/api/json/v1/1/filter.php?i=" + ingredientName;
        return new RestTemplate().getForObject(API_RESOURCE_URL, RecipeNameDto.class);
    }

    @Override
    @Cacheable(value = "name")
    public RecipeDto getRecipesByName(String name) {
        System.out.println("without cache2");
        final String API_RESOURCE_URL = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + name;
        return new RestTemplate().getForObject(API_RESOURCE_URL, RecipeDto.class);
    }

    @Override
    @Cacheable(value = "ingredients")
    public Set<RecipeNameDto> getRecipesByIngredients(List<List<String>> ingredients) {
        System.out.println("without cache3");

        final Set<RecipeNameDto> recipes = new HashSet<>();

        MealNameDto meal = new MealNameDto();

        List<List<String>> temp = new ArrayList<>();

        for (int i = 0; i < ingredients.size(); i++) {

            temp.add(ingredients.get(i));

            final String API_RESOURCE_URL = "https://www.themealdb.com/api/json/v2/9973533/filter.php?i="
                    + temp.get(i).get(0) + ","
                    + temp.get(i).get(1) + ","
                    + temp.get(i).get(2);

            RecipeNameDto jsonFromMealApi = new RestTemplate().getForObject(API_RESOURCE_URL, RecipeNameDto.class);

            if (jsonFromMealApi.getMeals() != null) {
                recipes.add(jsonFromMealApi);
            }
        }
        return recipes;
    }

    @CacheEvict(value = {"ingredient", "name", "ingredients"}, allEntries = true)
    //(cron = "seconds minutes hour dayOfMonth month dayOfWeek"
    @Scheduled(cron = "*/40 * * * * *")
    public void cacheEvict() {
        System.out.println("cache evict!" + LocalDateTime.now());
    }
}