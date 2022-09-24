package academy.mindswap.pantry_management.service;

import academy.mindswap.pantry_management.api.ApiHandler;
import academy.mindswap.pantry_management.model.Ingredient;
import academy.mindswap.pantry_management.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    private final ApiHandler apiHandler;

    private final IngredientRepository ingredientRepository;

    public ApiServiceImpl(ApiHandler apiHandler, IngredientRepository ingredientRepository) {
        this.apiHandler = apiHandler;
        this.ingredientRepository = ingredientRepository;
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
        List<String> ingredientListName = ingredientRepository
                .findAll()
                .stream()
                .map(Ingredient::getName)
                .toList();

        Object a = apiHandler.getRecipesByIngredient(ingredientListName.get(0));

        /*IngredientDto ingredientDto;

        ingredientDto.getId();



         */
        return null;
    }

}
