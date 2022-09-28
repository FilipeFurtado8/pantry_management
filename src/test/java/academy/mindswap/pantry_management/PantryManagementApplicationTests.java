package academy.mindswap.pantry_management;

import academy.mindswap.pantry_management.model.Category;
import academy.mindswap.pantry_management.model.Ingredient;
import academy.mindswap.pantry_management.model.User;
import academy.mindswap.pantry_management.repository.CategoryRepository;
import academy.mindswap.pantry_management.repository.IngredientRepository;
import academy.mindswap.pantry_management.repository.UserRepository;
import academy.mindswap.pantry_management.service.IngredientService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PantryManagementApplicationTests {

    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    IngredientService ingredientService;
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setup() {
    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class TestIngredient {
        @BeforeEach
        void setup() {

            final Ingredient i = Ingredient.builder()
                    .name("oregano")
                    .quantity(2)
                    .category(categoryRepository.findById(7).get())
                    .expirationDate(LocalDate.of(2022, 10, 2))
                    .user(userRepository.findById(1).get())
                    .build();

            ingredientRepository.save(i);
        }

        @Test
        @Order(value = 1)
        public void testCreateIngredient() {

            //Arrange
            final Category category = Category.builder()
                    .type("cereal")
                    .build();

            categoryRepository.save(category);

            final User user = User.builder()
                    .username("Johnny")
                    .build();

            userRepository.save(user);

            final Ingredient i = Ingredient.builder()
                    .name("chocapic")
                    .quantity(2)
                    .category(category)
                    .expirationDate(LocalDate.of(2022, 10, 2))
                    .user(user)
                    .build();

            ingredientRepository.save(i);


            //Act
            final Ingredient result = ingredientRepository.findById(8).get();


            //Assert
            assertEquals("chocapic", result.getName());
            assertNotNull(result);
        }

        @Test
        @Order(value = 2)
        void testGetAll() {

            //Arrange
            final List<Ingredient> result;

            //act
            result = ingredientRepository.findAll();

            //Assert
            assertNotNull(result);
            assertThat(result).size().isGreaterThan(0);
        }

        @Test
        @Order(value = 3)
        void testGetOne() {

            //Arrange
            final Ingredient result;

            //Act
            result = ingredientRepository.findById(7).get();

            //Assert
            assertNotNull(result);
            assertEquals("oregano", result.getName());

        }

        @Test
        @Order(value = 4)
        void testUpdate() {

            //Arrange
            final Ingredient result;

            //Act
            result = ingredientRepository.findById(7).get();
            result.setQuantity(3);
            ingredientRepository.save(result);

            //Assert
            assertNotNull(result);
            assertEquals(3, result.getQuantity());
            assertNotEquals(2, result.getQuantity());

        }

        @Test
        @Order(value = 5)
        void testDelete() {

            //Arrange
            final Ingredient result;

            //Act
            result = ingredientRepository.findById(7).get();
            ingredientRepository.delete(result);

            //Assert
            assertThat(ingredientRepository.existsById(7)).isFalse();
        }
    }
}
