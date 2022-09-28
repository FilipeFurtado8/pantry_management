package academy.mindswap.pantry_management.command.ingredientDTO;

import academy.mindswap.pantry_management.model.Category;
import academy.mindswap.pantry_management.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateIngredientDTO {
    @NotBlank
    private String name;

    private Integer quantity;
    private LocalDate expirationDate;
    private Category category;
    private User user;
}
