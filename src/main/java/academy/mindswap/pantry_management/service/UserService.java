package academy.mindswap.pantry_management.service;

import academy.mindswap.pantry_management.model.Ingredient;
import academy.mindswap.pantry_management.model.User;

import java.util.List;

public interface UserService {

    List<User> getUser();

    Ingredient alterIngredient(Ingredient ingredient, String name);
}
