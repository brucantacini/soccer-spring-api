package com.example.soccer_spring_api.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Jogador")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String nome;
    @Column
    private Long numeroCamisa;
    @Column
    private Long idade;
    @Column
    private String posicao;
    @Column
    private String nacionalidade;
    @Column
    private String time;
    @Column
    private Long gols;
    @Column
    private Long cartoesAmarelos;
    @Column
    private Long cartoesVermelhos;
    @Column
    private Long partidasJogadas;
}
