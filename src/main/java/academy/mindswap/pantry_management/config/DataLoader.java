package academy.mindswap.pantry_management.config;

import academy.mindswap.pantry_management.model.Category;
import academy.mindswap.pantry_management.model.Ingredient;
import academy.mindswap.pantry_management.repository.CategoryRepository;
import academy.mindswap.pantry_management.repository.IngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner commandLineRunner(IngredientRepository ingredientRepository,
                                        CategoryRepository categoryRepository) {
        return args -> {

            Category category = Category.builder()
                    .type("meat")
                    .build();
            categoryRepository.save(category);

            Ingredient ingredient = Ingredient.builder()
                    .name("chicken breast")
                    .expirationDate(LocalDate.of(2022, 10, 13))
                    .category(category)
                    .build();
            ingredientRepository.save(ingredient);
        };

    }
}
