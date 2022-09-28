package academy.mindswap.pantry_management.service;

import academy.mindswap.pantry_management.api.ApiHandler;
import academy.mindswap.pantry_management.command.ingredientDTO.IngredientDTO;
import academy.mindswap.pantry_management.model.Ingredient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    public Object getRecipesByIngredient(String ingredientName) {
        log.info("Getting recipes by ingredient");
        return apiHandler.getRecipesByIngredient(ingredientName);
    }

    @Override
    public Object getRecipesByName(String name) {
        log.info("Getting recipes by name");
        return apiHandler.getRecipesByName(name);
    }

    @Override
    public Object getRecipesByStock() {
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