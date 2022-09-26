package academy.mindswap.pantry_management.service;

import academy.mindswap.pantry_management.model.Ingredient;
import academy.mindswap.pantry_management.model.User;
import academy.mindswap.pantry_management.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    private final IngredientService ingredientService;

    public UserServiceImp(UserRepository userRepository, IngredientService ingredientService) {
        this.userRepository = userRepository;
        this.ingredientService = ingredientService;
    }


    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public Ingredient alterIngredient(Ingredient ingredient, String name) {
        return ingredientService.alterIngredient(ingredient, name);
    }
}
