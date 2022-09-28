package academy.mindswap.pantry_management.command.userDTO;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class CreateUserDTO {
    private Integer id;
    @NotBlank
    private String username;
}
