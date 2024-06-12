package com.example.Task1.repository;

import com.example.Task1.entity.Method;
import com.example.Task1.entity.TrackTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrackTimeRepository extends JpaRepository<TrackTime, Integer> {

}
