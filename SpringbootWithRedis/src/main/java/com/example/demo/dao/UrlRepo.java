package com.example.demo.dao;

import com.example.demo.entity.UrlDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UrlRepo extends JpaRepository<UrlDO, Long> {
    UrlDO findByLongUrl(String longUrl);

}
