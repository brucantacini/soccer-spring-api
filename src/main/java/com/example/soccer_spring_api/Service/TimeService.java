package com.example.soccer_spring_api.Service;
import com.example.soccer_spring_api.Entity.Time;
import com.example.soccer_spring_api.Repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    // CREATE - Criar novo time
    public Time criar(Time time) {
        // Validações básicas
        if (time.getNome() == null || time.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do time é obrigatório!");
        }

        return timeRepository.save(time);
    }

    // READ - Listar todos os times
    public List<Time> listarTodos() {
        return timeRepository.findAll();
    }

    // READ - Buscar time por ID
    public Optional<Time> buscarPorId(Long id) {
        return timeRepository.findById(id);
    }

    // UPDATE - Atualizar time existente
    public Time atualizar(Long id, Time timeAtualizado) {
        Optional<Time> timeOptional = timeRepository.findById(id);

        if (timeOptional.isEmpty()) {
            throw new IllegalArgumentException("Time não encontrado com ID: " + id);
        }

        Time timeExistente = timeOptional.get();

        // Atualiza apenas os campos fornecidos
        if (timeAtualizado.getNome() != null && !timeAtualizado.getNome().trim().isEmpty()) {
            timeExistente.setNome(timeAtualizado.getNome());
        }

        if (timeAtualizado.getDivisao() != null) {
            timeExistente.setDivisao(timeAtualizado.getDivisao());
        }

        if (timeAtualizado.getAnoFundacao() != null) {
            timeExistente.setAnoFundacao(timeAtualizado.getAnoFundacao());
        }

        if (timeAtualizado.getCidade() != null) {
            timeExistente.setCidade(timeAtualizado.getCidade());
        }

        return timeRepository.save(timeExistente);
    }

    // DELETE - Deletar time
    public void deletar(Long id) {
        if (!timeRepository.existsById(id)) {
            throw new IllegalArgumentException("Time não encontrado com ID: " + id);
        }
        timeRepository.deleteById(id);
    }
}

