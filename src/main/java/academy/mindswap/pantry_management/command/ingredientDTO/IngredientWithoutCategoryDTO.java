package academy.mindswap.pantry_management.command.ingredientDTO;

import academy.mindswap.pantry_management.command.userDTO.UserDTO;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class IngredientWithoutCategoryDTO {

    private Integer id;
    private String name;
    private Integer quantity;
    private LocalDate expirationDate;
    private UserDTO userDTO;


}
