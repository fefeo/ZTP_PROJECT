package com.example.ZTP_PROJ6;

import com.example.ZTP_PROJ6.beans.Recipe;
import com.example.ZTP_PROJ6.beans.Role;
import com.example.ZTP_PROJ6.beans.User;
import com.example.ZTP_PROJ6.repositorys.RecipeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApplicationStarter {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path",
				"/SimpleLibrarySpring");
		SpringApplication.run(ApplicationStarter.class, args);
		System.out.println("ApplicationStarter has started");
	}
	@Bean
	CommandLineRunner commandLineRunner(RecipeRepository recipeRepository) {
		return args -> {
			Recipe pizza = new Recipe(User.idCreator(), "JA1", "ma33333", Role.USER);
			userRepository.save(maria);
		};
	}
}
