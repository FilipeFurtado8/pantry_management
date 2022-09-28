package academy.mindswap.pantry_management.controller;

import academy.mindswap.pantry_management.command.userDTO.UserDTO;
import academy.mindswap.pantry_management.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    private List<UserDTO> getUser() {
        log.info("Getting all users");
        return userService.getUser();
    }


}
