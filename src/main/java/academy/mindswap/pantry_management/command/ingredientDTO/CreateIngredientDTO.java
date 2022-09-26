package academy.mindswap.pantry_management.command.ingredientDTO;

import academy.mindswap.pantry_management.model.Category;
import academy.mindswap.pantry_management.model.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CreateIngredientDTO {
    private Integer id;
    private String name;
    private Integer quantity;
    private LocalDate expirationDate;
    private Category category;
    private User user;
}
