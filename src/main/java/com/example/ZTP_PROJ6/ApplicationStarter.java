package com.example.ZTP_PROJ6;

import com.example.ZTP_PROJ6.beans.Recipe;
import com.example.ZTP_PROJ6.beans.Role;
import com.example.ZTP_PROJ6.beans.User;
import com.example.ZTP_PROJ6.repositorys.RecipeRepository;
import com.example.ZTP_PROJ6.repositorys.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
public class ApplicationStarter {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path",
				"/SimpleLibrarySpring");
		SpringApplication.run(ApplicationStarter.class, args);
		System.out.println("ApplicationStarter has started");
	}
	@Bean
	CommandLineRunner commandLineRunner(RecipeRepository recipeRepository, UserRepository userRepository) {
		return args -> {
			String auth = "admin";
			User user = userRepository.findAllByLogin(auth);
			Recipe pizza = new Recipe(Recipe.idCreator(), "SPA", "Salami", "salami, cheese", 4, user );
			recipeRepository.save(pizza);

		};
	}
}
