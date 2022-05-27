package com.example.ZTP_PROJ6.repositorys;

import com.example.ZTP_PROJ6.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
