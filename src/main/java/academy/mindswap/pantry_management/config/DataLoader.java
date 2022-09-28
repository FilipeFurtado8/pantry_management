package academy.mindswap.pantry_management.config;

import academy.mindswap.pantry_management.model.Category;
import academy.mindswap.pantry_management.model.Ingredient;
import academy.mindswap.pantry_management.model.User;
import academy.mindswap.pantry_management.repository.CategoryRepository;
import academy.mindswap.pantry_management.repository.IngredientRepository;
import academy.mindswap.pantry_management.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner commandLineRunner(IngredientRepository ingredientRepository,
                                        CategoryRepository categoryRepository, UserRepository userRepository) {
        return args -> {

            User user1 = User.builder()
                    .username("Filipe")
                    .build();

            userRepository.save(user1);

            Category category1 = Category.builder()
                    .type("meat")
                    .build();

            Category category2 = Category.builder()
                    .type("vegetable")
                    .build();

            Category category3 = Category.builder()
                    .type("fruit")
                    .build();

            Category category4 = Category.builder()
                    .type("seafood")
                    .build();

            Category category5 = Category.builder()
                    .type("dairy")
                    .build();

            Category category6 = Category.builder()
                    .type("beverage")
                    .build();

            Category category7 = Category.builder()
                    .type("condiments & spices")
                    .build();

            Category category8 = Category.builder()
                    .type("bakery")
                    .build();

            Category category9 = Category.builder()
                    .type("carbohydrates")
                    .build();

            categoryRepository.saveAll(List.of(category1, category2, category3, category4,
                    category5, category6, category7, category8, category9));


            Ingredient ingredient1 = Ingredient.builder()
                    .name("chicken breast")
                    .expirationDate(LocalDate.of(2022, 10, 13))
                    .category(category1)
                    .user(user1)
                    .quantity(10)
                    .build();

            Ingredient ingredient2 = Ingredient.builder()
                    .name("beef")
                    .expirationDate(LocalDate.of(2022, 10, 13))
                    .category(category1)
                    .user(user1)
                    .quantity(0)
                    .build();

            Ingredient ingredient3 = Ingredient.builder()
                    .name("tomato")
                    .expirationDate(LocalDate.of(2022, 10, 13))
                    .category(category3)
                    .user(user1)
                    .build();


            Ingredient ingredient4 = Ingredient.builder()
                    .name("water")
                    .expirationDate(LocalDate.of(2022, 10, 13))
                    .category(category6)
                    .user(user1)
                    .build();

            Ingredient ingredient5 = Ingredient.builder()
                    .name("garlic")
                    .expirationDate(LocalDate.of(2022, 10, 13))
                    .category(category2)
                    .user(user1)
                    .build();

            Ingredient ingredient6 = Ingredient.builder()
                    .name("sugar")
                    .expirationDate(LocalDate.of(2022, 10, 13))
                    .category(category7)
                    .user(user1)
                    .build();

            ingredientRepository.saveAll(List.of(ingredient1, ingredient2, ingredient3, ingredient4, ingredient5, ingredient6));

            /*Ingredient ingredient7 = Ingredient.builder()
                    .name("rice")
                    .expirationDate(LocalDate.of(2022, 10, 13))
                    .category(category9)
                    .user(user1)
                    .build();

            Ingredient ingredient8 = Ingredient.builder()
                    .name("salmon")
                    .expirationDate(LocalDate.of(2022, 10, 13))
                    .category(category4)
                    .user(user1)
                    .build();

            Ingredient ingredient9 = Ingredient.builder()
                    .name("shrimp")
                    .expirationDate(LocalDate.of(2022, 10, 13))
                    .category(category4)
                    .user(user1)
                    .build();

            Ingredient ingredient10 = Ingredient.builder()
                    .name("spaghetti")
                    .expirationDate(LocalDate.of(2022, 10, 13))
                    .category(category9)
                    .user(user1)
                    .build();

            Ingredient ingredient11 = Ingredient.builder()
                    .name("bread")
                    .expirationDate(LocalDate.of(2022, 10, 13))
                    .category(category9)
                    .user(user1)
                    .build();

            Ingredient ingredient12 = Ingredient.builder()
                    .name("potato")
                    .expirationDate(LocalDate.of(2022, 10, 13))
                    .category(category9)
                    .user(user1)
                    .build();

            Ingredient ingredient13 = Ingredient.builder()
                    .name("banana")
                    .expirationDate(LocalDate.of(2022, 10, 13))
                    .category(category3)
                    .user(user1)
                    .build();

            Ingredient ingredient14 = Ingredient.builder()
                    .name("onion")
                    .expirationDate(LocalDate.of(2022, 10, 13))
                    .category(category2)
                    .user(user1)
                    .build();

            Ingredient ingredient15 = Ingredient.builder()
                    .name("broccoli")
                    .expirationDate(LocalDate.of(2022, 10, 13))
                    .category(category2)
                    .user(user1)
                    .build();

            Ingredient ingredient16 = Ingredient.builder()
                    .name("pork")
                    .expirationDate(LocalDate.of(2022, 10, 13))
                    .category(category1)
                    .user(user1)
                    .build();

            Ingredient ingredient17 = Ingredient.builder()
                    .name("milk")
                    .expirationDate(LocalDate.of(2022, 10, 13))
                    .category(category5)
                    .user(user1)
                    .build();

            Ingredient ingredient18 = Ingredient.builder()
                    .name("cheese")
                    .expirationDate(LocalDate.of(2022, 10, 13))
                    .category(category5)
                    .user(user1)
                    .build();

            ingredientRepository.saveAll(List.of(ingredient1, ingredient2, ingredient3, ingredient4,
                    ingredient5, ingredient6, ingredient7, ingredient8,
                    ingredient9, ingredient10, ingredient11, ingredient12,
                    ingredient13, ingredient14, ingredient15, ingredient16, ingredient17, ingredient18));

             */
        };

    }
}
