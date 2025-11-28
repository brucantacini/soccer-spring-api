package com.example.soccer_spring_api.Service;

import com.example.soccer_spring_api.Entity.Campeonato;
import com.example.soccer_spring_api.Repository.CampeonatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampeonatoService {
    @Autowired
    private CampeonatoRepository campeonatoRepository;

    public Campeonato criar(Campeonato campeonato) {
        if (campeonato.getNome() == null || campeonato.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Campo nome é obrigatório");
        }
        if (campeonato.getFormato() == null || campeonato.getFormato().trim().isEmpty()) {
            throw new IllegalArgumentException("Formato do campeonato é obrigatório");
        }
        if (campeonato.getTotalTimes() == null) {
            throw new IllegalArgumentException("Número de times é obrigatório");
        }

        return campeonatoRepository.save(campeonato);
    }

    public List<Campeonato> listarTodos () {
        return campeonatoRepository.findAll();
    }

    public Optional<Campeonato> buscarPorID ( Long id ) {
        return campeonatoRepository.findById(id);
    }

    public Campeonato atualizar(Long id, Campeonato campeonatoAtualizado) {
        Optional<Campeonato> campeonatoOptional = campeonatoRepository.findById(id);

        if (campeonatoOptional.isEmpty()) {
            throw new IllegalArgumentException("Campeonato não encontrado com o ID " + id);
        };

        Campeonato campeonatoExistente = campeonatoOptional.get();

        // Atualiza apenas os campos fornecidos
        if (campeonatoAtualizado.getNome() != null && !campeonatoAtualizado.getNome().trim().isEmpty()) {
            campeonatoExistente.setNome(campeonatoAtualizado.getNome());
        }

        if (campeonatoAtualizado.getTotalTimes() != null) {
            campeonatoExistente.setTotalTimes(campeonatoAtualizado.getTotalTimes());
        }

        // Salva as alterações
        return campeonatoRepository.save(campeonatoExistente);
    }

    public void deletar (Long id) {
        if (!campeonatoRepository.existsById(id)) {
            throw new IllegalArgumentException("Campeonato não encontrado com o id: " + id);
        }
        campeonatoRepository.deleteById(id);
    }


}
