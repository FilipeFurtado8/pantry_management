package academy.mindswap.pantry_management.command.userDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    private Integer id;
    private String username;
    
}
