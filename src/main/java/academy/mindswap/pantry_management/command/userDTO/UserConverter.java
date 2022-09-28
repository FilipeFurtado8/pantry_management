package academy.mindswap.pantry_management.command.userDTO;

import academy.mindswap.pantry_management.model.User;

public class UserConverter {

    public static UserDTO convertToDTO(User user) {
        if (user == null) {
            return UserDTO.builder()
                    .id(null)
                    .username("unassigned")
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
