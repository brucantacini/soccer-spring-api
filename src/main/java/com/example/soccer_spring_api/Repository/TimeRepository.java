package com.example.soccer_spring_api.Repository;

import com.example.soccer_spring_api.Entity.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {
}

