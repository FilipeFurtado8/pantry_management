package academy.mindswap.pantry_management.service;

import academy.mindswap.pantry_management.command.userDTO.UserConverter;
import academy.mindswap.pantry_management.command.userDTO.UserDTO;
import academy.mindswap.pantry_management.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    private final IngredientService ingredientService;

    public UserServiceImp(UserRepository userRepository, IngredientService ingredientService) {
        this.userRepository = userRepository;
        this.ingredientService = ingredientService;
    }


    @Override
    public List<UserDTO> getUser() {
        log.info("Getting all users");
        return userRepository.findAll().stream()
                .map(UserConverter::convertToDTO)
                .toList();
    }

}
