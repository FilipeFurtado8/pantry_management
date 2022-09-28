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

import static academy.mindswap.pantry_management.utils.Messages.*;

@Component
@EnableScheduling
public class ApiHandlerImpl implements ApiHandler {


    @Override
    @Cacheable(value = BY_INGREDIENT)
    public RecipeNameDto getRecipesByIngredient(String ingredientName) {
        final String API_RESOURCE_URL = URL_BY_ONE_INGREDIENT + ingredientName;
        return new RestTemplate().getForObject(API_RESOURCE_URL, RecipeNameDto.class);
    }

    @Override
    @Cacheable(value = BY_NAME)
    public RecipeDto getRecipesByName(String name) {
        final String API_RESOURCE_URL = URL_BY_ONE_NAME + name;
        return new RestTemplate().getForObject(API_RESOURCE_URL, RecipeDto.class);
    }

    @Override
    @Cacheable(value = BY_INGREDIENTS)
    public Set<RecipeNameDto> getRecipesByIngredients(List<List<String>> ingredients) {

        final Set<RecipeNameDto> recipes = new HashSet<>();

        MealNameDto meal = new MealNameDto();

        List<List<String>> temp = new ArrayList<>();

        for (int i = 0; i < ingredients.size(); i++) {

            temp.add(ingredients.get(i));

            final String API_RESOURCE_URL = URL_MULTI_INGREDIENTS
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

    @CacheEvict(value = {BY_INGREDIENT, BY_NAME, BY_INGREDIENTS}, allEntries = true)
    //(cron = "seconds minutes hour dayOfMonth month dayOfWeek"
    @Scheduled(cron = CRON)
    public void cacheEvict() {
        System.out.println(CACHE_EVICT + LocalDateTime.now());
    }
}