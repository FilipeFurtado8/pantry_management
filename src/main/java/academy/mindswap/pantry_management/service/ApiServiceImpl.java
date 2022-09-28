package academy.mindswap.pantry_management.service;

import academy.mindswap.pantry_management.api.ApiHandler;
import academy.mindswap.pantry_management.command.api_dto.RecipeDto;
import academy.mindswap.pantry_management.command.api_dto.RecipeNameDto;
import academy.mindswap.pantry_management.command.ingredientDTO.IngredientDTO;
import academy.mindswap.pantry_management.model.Ingredient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static academy.mindswap.pantry_management.utils.Messages.GET_RECIPE_BY_NAME;
import static academy.mindswap.pantry_management.utils.Messages.RECIPES_BY_INGREDIENT;

@Service
@Slf4j
public class ApiServiceImpl implements ApiService {

    private final ApiHandler apiHandler;

    private final IngredientService ingredientService;

    private final List<String[]> arrList = new ArrayList<>();

    public ApiServiceImpl(ApiHandler apiHandler, IngredientService ingredientService) {
        this.apiHandler = apiHandler;
        this.ingredientService = ingredientService;
    }

    @Override
    public RecipeNameDto getRecipesByIngredient(String ingredientName) {
        log.info(RECIPES_BY_INGREDIENT);
        return apiHandler.getRecipesByIngredient(ingredientName);
    }

    @Override
    public RecipeDto getRecipesByName(String name) {
        log.info(GET_RECIPE_BY_NAME);
        return apiHandler.getRecipesByName(name);
    }

    @Override
    public Set<RecipeNameDto> getRecipesByStock() {
        String[] ingredientListName = ingredientService.getAllIngredients()
                .stream()
                .map((IngredientDTO t) -> t.getName())
                .toArray(String[]::new);

        int rangeOfIngredients = 3;
        int stockSize = ingredientListName.length;
        String[] data = new String[rangeOfIngredients];

        return apiHandler.getRecipesByIngredients(
                combinationUtil(ingredientListName, data, 0, stockSize - 1, 0, rangeOfIngredients));
    }


    private List<List<String>> combinationUtil(String[] ingredientListName, String[] data, int start, int end, int index,
                                               int rangeOfIngredients) {

        if (index == rangeOfIngredients) {
            return arrList.stream().map(Arrays::asList).collect(Collectors.toList());
        }

        for (int i = start; i <= end && end - i + 1 >= rangeOfIngredients - index; i++) {
            data[index] = ingredientListName[i];
            combinationUtil(ingredientListName, data, i + 1, end, index + 1, rangeOfIngredients);
            String[] newArr = new String[data.length];

            for (int j = 0; j < data.length; j++) {
                newArr[j] = data[j];
            }
            arrList.add(newArr);
        }
        return arrList.stream().map(Arrays::asList).collect(Collectors.toList());
    }
}