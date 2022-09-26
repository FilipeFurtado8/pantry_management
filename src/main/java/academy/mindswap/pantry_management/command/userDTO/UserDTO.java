package academy.mindswap.pantry_management.command.userDTO;

import academy.mindswap.pantry_management.command.ingredientDTO.IngredientDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserDTO {

    private Integer id;
    private String username;
    private List<IngredientDTO> ingredientListDTO;
}
