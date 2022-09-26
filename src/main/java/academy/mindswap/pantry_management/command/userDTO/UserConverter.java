package academy.mindswap.pantry_management.command.userDTO;

import academy.mindswap.pantry_management.command.ingredientDTO.IngredientConverter;
import academy.mindswap.pantry_management.model.User;

import java.util.stream.Collectors;

public class UserConverter {
    public static UserDTO convertToDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .ingredientListDTO(user.getIngredientList().stream()
                        .map(IngredientConverter::convertToDTO)
                        .collect(Collectors.toList()))
                .build();
    }

    public static User convertCreateCategoryDTOToCategory(CreateUserDTO createUserDTO) {

        return User.builder()
                .username(createUserDTO.getUsername())
                .build();
    }
}
