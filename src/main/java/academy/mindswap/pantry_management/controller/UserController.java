package academy.mindswap.pantry_management.controller;

import academy.mindswap.pantry_management.model.Ingredient;
import academy.mindswap.pantry_management.model.User;
import academy.mindswap.pantry_management.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    private List<User> getUser() {
        return userService.getUser();
    }


    @PutMapping(path = "/update/{name}")
    private Ingredient alterIngredient(@RequestBody Ingredient ingredient, @PathVariable String name) {

        return userService.alterIngredient(ingredient, name);

    }
}
