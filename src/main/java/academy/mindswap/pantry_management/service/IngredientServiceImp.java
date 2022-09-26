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

    public Ingredient findByName(String name) {
        return ingredientRepository.findAll().stream()
                .filter(ingredient -> ingredient.getName().equals(name))
                .findFirst().orElseThrow();
    }

    @Override
    public Ingredient alterIngredient(Ingredient ingredient, String name) {

        Ingredient ingredient1 = findByName(name);

        ingredient1.setQuantity(ingredient.getQuantity());

        return ingredientRepository.save(ingredient1);
        
    }
}
