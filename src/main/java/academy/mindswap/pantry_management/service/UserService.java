package academy.mindswap.pantry_management.service;

import academy.mindswap.pantry_management.command.userDTO.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getUser();
    
}
