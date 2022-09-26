package academy.mindswap.pantry_management.command.userDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserDTO {
    private Integer id;
    private String username;
}
