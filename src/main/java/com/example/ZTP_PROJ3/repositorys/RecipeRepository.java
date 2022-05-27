package com.example.ZTP_PROJ3.repositorys;


import com.example.ZTP_PROJ3.beans.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe,String> {
}
