package academy.mindswap.pantry_management.command.categoryDTO;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class CreateCategoryDTO {

    @NotBlank
    private String type;

}
