package academy.mindswap.pantry_management.service;

import academy.mindswap.pantry_management.command.ingredientDTO.CreateIngredientDTO;
import academy.mindswap.pantry_management.command.ingredientDTO.IngredientConverter;
import academy.mindswap.pantry_management.command.ingredientDTO.IngredientDTO;
import academy.mindswap.pantry_management.exceptions.ResourceNotFoundException;
import academy.mindswap.pantry_management.model.Ingredient;
import academy.mindswap.pantry_management.repository.IngredientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class IngredientServiceImp implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImp(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<IngredientDTO> getAllIngredients() {
        log.info("Getting all ingredients");
        return ingredientRepository.findAll().stream()
                .map(IngredientConverter::convertToDTO)
                .toList();
    }

    @Override
    public IngredientDTO findByName(String name) {
        log.info("Finding ingredient by name" + name);
        return ingredientRepository.findAll().stream()
                .filter(ingredient -> ingredient.getName().equals(name))
                .map(IngredientConverter::convertToDTO)
                .findFirst().orElseThrow();
    }

    @Override
    public List<IngredientDTO> findByExpirationDate(Integer year, Integer month, Integer day) {
        LocalDate localDate = LocalDate.of(year, month, day);

        return ingredientRepository.findAll().stream()
                .filter(ingredient -> ingredient.getExpirationDate().equals(localDate))
                .map(IngredientConverter::convertToDTO)
                .toList();
    }

    @Override
    public List<IngredientDTO> getIngredientsByQuantity(Integer quantity) {
        return ingredientRepository.findAll().stream()
                .filter(ingredient -> ingredient.getQuantity().equals(quantity))
                .map(IngredientConverter::convertToDTO)
                .toList();
    }

    @Override
    public IngredientDTO getIngredientById(Integer id) {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The ingredient with this id doesn't exist. Id: " + id));
        return IngredientConverter.convertToDTO(ingredient);
    }

    @Override
    public IngredientDTO alterIngredient(CreateIngredientDTO ingredient, String name) {
        log.info("Updating ingredient");
        IngredientConverter.convertCreateIngredientDTOToIngredient(ingredient);

        Ingredient ingredient1 = ingredientRepository.findAll().stream()
                .filter(ingredient2 -> ingredient2.getName().equals(name))
                .findFirst().orElseThrow();

        ingredient1.setQuantity(ingredient.getQuantity());

        ingredientRepository.save(ingredient1);

        return IngredientConverter.convertToDTO(ingredient1);
    }

    @Override
    public IngredientDTO addIngredient(CreateIngredientDTO ingredient) {
        Ingredient ingredient1 = IngredientConverter.convertCreateIngredientDTOToIngredient(ingredient);
        ingredientRepository.save(ingredient1);
        return IngredientConverter.convertToDTO(ingredient1);
    }

    @Override
    public void deleteAllIngredients() {
        ingredientRepository.deleteAll();
    }

    @Override
    public void deleteIngredientByName(String name) {
        ingredientRepository.delete(ingredientRepository.findAll().stream()
                .filter(ingredient -> ingredient.getName().equals(name))
                .findFirst().orElseThrow());
    }
}
