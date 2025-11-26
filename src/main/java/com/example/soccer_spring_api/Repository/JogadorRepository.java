package com.example.soccer_spring_api.Repository;

import com.example.soccer_spring_api.Entity.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends JpaRepository <Jogador, Long> {
}
