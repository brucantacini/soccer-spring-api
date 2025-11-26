package com.example.soccer_spring_api.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Time")
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String nome;
    @Column
    private String estadio;
    @Column
    private String divisao;
    @Column
    private String tecnico;
    @Column
    private Long anoFundacao;
    @Column
    private String cidade;

}
