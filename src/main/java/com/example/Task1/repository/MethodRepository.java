package com.example.Task1.repository;

import com.example.Task1.entity.Method;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MethodRepository extends JpaRepository<Method, Integer> {
    @Query("SELECT m FROM Method m LEFT JOIN FETCH m.trackTimeList WHERE m.name = :methodName")
    Optional<Method> findMethodByName(String methodName);
}
