package com.example.ZTP_PROJ6.repositorys;

import com.example.ZTP_PROJ6.beans.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo,String> {
    Photo findAllByUrl(String url);
}
