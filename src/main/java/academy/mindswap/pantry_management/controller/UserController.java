package academy.mindswap.pantry_management.controller;

import academy.mindswap.pantry_management.command.userDTO.UserDTO;
import academy.mindswap.pantry_management.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static academy.mindswap.pantry_management.utils.Messages.GET_ALL_USERS;
import static academy.mindswap.pantry_management.utils.Messages.USER;

@RestController
@RequestMapping(USER)
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    private List<UserDTO> getUser() {
        log.info(GET_ALL_USERS);
        return userService.getUser();
    }
}