package academy.mindswap.pantry_management.command.ingredientDTO;

import academy.mindswap.pantry_management.model.Category;
import academy.mindswap.pantry_management.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

import static academy.mindswap.pantry_management.utils.Messages.MIN_QUANTITY;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateIngredientDTO {
    @NotBlank
    private String name;
    @Min(value = 0, message = MIN_QUANTITY)
    private Integer quantity;
    private LocalDate expirationDate;
    private Category category;
    private User user;
}
