package academy.mindswap.pantry_management.command.ingredientDTO;


import academy.mindswap.pantry_management.command.categoryDTO.CategoryConverter;
import academy.mindswap.pantry_management.model.Ingredient;

public class IngredientConverter {

    public static IngredientDTO convertToDTO(Ingredient ingredient) {
        return IngredientDTO.builder()
                .name(ingredient.getName())
                .id(ingredient.getId())
                .expirationDate(ingredient.getExpirationDate())
                .categoryDTO(CategoryConverter.convertToDTOWithoutIngredient(ingredient.getCategory()))
                .quantity(ingredient.getQuantity())
                .build();
    }

    public static IngredientDTO convertToDTOWithoutCategory(Ingredient ingredient) {

        return IngredientDTO.builder()
                .name(ingredient.getName())
                .id(ingredient.getId())
                .expirationDate(ingredient.getExpirationDate())
                .build();
    }

    public static Ingredient convertCreateIngredientDTOToIngredient(CreateIngredientDTO createIngredientDTO) {

        return Ingredient.builder()
                .name(createIngredientDTO.getName())
                .expirationDate(createIngredientDTO.getExpirationDate())
                .quantity(createIngredientDTO.getQuantity())
                .user(createIngredientDTO.getUser())
                .category(createIngredientDTO.getCategory())
                .build();
    }


}
