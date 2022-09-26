package academy.mindswap.pantry_management.command.categoryDTO;


import academy.mindswap.pantry_management.command.ingredientDTO.IngredientDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryDTO {
    private Integer id;
    private String type;
    private List<IngredientDTO> ingredientListDTO;
}
