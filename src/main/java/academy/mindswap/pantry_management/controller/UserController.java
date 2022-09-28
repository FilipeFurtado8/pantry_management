package academy.mindswap.pantry_management.controller;

import academy.mindswap.pantry_management.command.ingredientDTO.CreateIngredientDTO;
import academy.mindswap.pantry_management.command.ingredientDTO.IngredientDTO;
import academy.mindswap.pantry_management.model.Ingredient;
import academy.mindswap.pantry_management.model.User;
import academy.mindswap.pantry_management.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    private List<User> getUser() {
        log.info("Getting all users");
        return userService.getUser();
    }


    @PutMapping(path = "/update/{name}")
    private IngredientDTO alterIngredient(@RequestBody CreateIngredientDTO ingredient, @PathVariable String name) {
        log.info("Updating ingredient");
        return userService.alterIngredient(ingredient, name);

    }


}
