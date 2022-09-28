package academy.mindswap.pantry_management.command.userDTO;

import academy.mindswap.pantry_management.model.User;

import static academy.mindswap.pantry_management.utils.Messages.UNASSIGNED;

public class UserConverter {

    public static UserDTO convertToDTO(User user) {
        if (user == null) {
            return UserDTO.builder()
                    .id(null)
                    .username(UNASSIGNED)
                    .build();
        }

        
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }

    public static User convertCreateCategoryDTOToCategory(CreateUserDTO createUserDTO) {

        return User.builder()
                .username(createUserDTO.getUsername())
                .build();
    }
}
