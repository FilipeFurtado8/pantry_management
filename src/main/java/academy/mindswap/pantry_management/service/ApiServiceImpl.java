package academy.mindswap.pantry_management.service;

import academy.mindswap.pantry_management.api.ApiHandler;
import academy.mindswap.pantry_management.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    private final ApiHandler apiHandler;

    private final IngredientService ingredientService;

    public ApiServiceImpl(ApiHandler apiHandler, IngredientService ingredientService) {
        this.apiHandler = apiHandler;
        this.ingredientService = ingredientService;
    }

    @Override
    public Object getRecipesByIngredient(String ingredientName){
        return apiHandler.getRecipesByIngredient(ingredientName);
    }

    @Override
    public Object getRecipesByName(String name){
        return apiHandler.getRecipesByName(name);
    }



    @Override
    public Object get(){
        String[] ingredientListName = ingredientService.getAllIngredients()
                .stream()
                .map(Ingredient::getName)
                .toArray(String[]::new);

        //return apiHandler.getRecipesByIngredient(ingredientListName.get(0));

        int rangeOfIngredients = 3;
        int stockSize = ingredientListName.length;

        String[] data=new String[rangeOfIngredients];

        System.out.println(combinationUtil(ingredientListName, data, 0, stockSize - 1, 0, rangeOfIngredients));

        //return apiHandler.getRecipesByIngredients(combinationUtil(ingredientListName, data, 0, stockSize-1, 0, rangeOfIngredients));

        return null;

    }

    private List<String> combinationUtil(String[] ingredientListName, String[] data, int start, int end, int index,
                                         int rangeOfIngredients) {
        List<String> ingredients = new ArrayList<>();

        if (index == rangeOfIngredients) {
            for (int j=0; j<rangeOfIngredients; j++){
                //System.out.println(data[j]+", ");
                ingredients.add(data[j]);
            }
            //System.out.println("");
            //System.out.println(ingredients);
            return ingredients;
        }

        for (int i=start; i<=end && end-i+1 >= rangeOfIngredients-index; i++) {
            data[index] = ingredientListName[i];
            combinationUtil(ingredientListName, data, i+1, end, index+1, rangeOfIngredients);
        }

        return null;
    }
}