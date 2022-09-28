package academy.mindswap.pantry_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PantryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PantryManagementApplication.class, args);
	}

}
