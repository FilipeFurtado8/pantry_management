package academy.mindswap.pantry_management.service;

import academy.mindswap.pantry_management.model.Ingredient;
import academy.mindswap.pantry_management.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImp implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImp(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }
}
