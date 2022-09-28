package academy.mindswap.pantry_management.service;

import academy.mindswap.pantry_management.model.Ingredient;
import academy.mindswap.pantry_management.repository.IngredientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class IngredientServiceImp implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImp(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }
    @Cacheable(value = "ingredients", key = "#id")
    @Override
    public List<Ingredient> getAllIngredients() {
        log.info("Getting all ingredients");
        return ingredientRepository.findAll();
    }
    @Cacheable(value = "ingredient", key = "#ingredint.id")
    public Ingredient findByName(String name) {
        log.info("Finding ingredient by name"+name);
        return ingredientRepository.findAll().stream()
                .filter(ingredient -> ingredient.getName().equals(name))
                .findFirst().orElseThrow();
    }
    @CachePut(value = "ingredient", key = "#ingredient.id")
    @Override
    public Ingredient alterIngredient(Ingredient ingredient, String name) {
        log.info("Updating ingredient");
        Ingredient ingredient1 = findByName(name);

        ingredient1.setQuantity(ingredient.getQuantity());

        return ingredientRepository.save(ingredient1);
        
    }
}
