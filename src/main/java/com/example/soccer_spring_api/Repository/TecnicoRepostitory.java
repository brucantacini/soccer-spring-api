package com.example.soccer_spring_api.Repository;

import com.example.soccer_spring_api.Entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepostitory extends JpaRepository <Tecnico, Long> {
}
