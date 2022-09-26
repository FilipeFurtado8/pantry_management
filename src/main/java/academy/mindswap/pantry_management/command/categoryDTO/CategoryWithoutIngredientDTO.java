package academy.mindswap.pantry_management.command.categoryDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryWithoutIngredientDTO {
    private Integer id;
    private String type;
}
