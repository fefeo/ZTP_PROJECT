package com.example.ZTP_PROJ6.repositorys;


import com.example.ZTP_PROJ6.beans.Recipe;
import com.example.ZTP_PROJ6.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe,String> {
    List<Recipe> findAllByUser_Id(String user_Id);
}
