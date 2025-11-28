package com.example.soccer_spring_api.Service;

import com.example.soccer_spring_api.Entity.Estadio;
import com.example.soccer_spring_api.Repository.EstadioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadioService {

    @Autowired
    private EstadioRepository estadioRepository;

    public Estadio Criar (Estadio estadio) {
        if (estadio.getNome() == null || estadio.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do estádio é obrigatório.");
        }

        if (estadio.getLocalizacao() == null || estadio.getLocalizacao().trim().isEmpty()) {
            throw  new IllegalArgumentException("Localizacao do estadio é obrigatorio");
        }

        return estadioRepository.save(estadio);
    }

    public List<Estadio> listarTodos () {
        return estadioRepository.findAll();
    }

    public Optional<Estadio> buscarPorId (Long id) {
        return estadioRepository.findById(id);
    }

    public Estadio atualizar (Long id, Estadio estadioAtualizado) {
        Optional<Estadio> estadioOptional = estadioRepository.findById(id);

        if (estadioOptional.isEmpty()) {
            throw new IllegalArgumentException("Estadio não encontrado com o id " + id);
        }

        Estadio estadioExistente = estadioOptional.get();

        if (estadioAtualizado.getNome() != null && estadioAtualizado.getNome().trim().isEmpty()) {
            estadioExistente.setNome(estadioAtualizado.getNome());
        }

        if (estadioAtualizado.getLocalizacao() != null && estadioAtualizado.getLocalizacao().trim().isEmpty()) {
            estadioExistente.setLocalizacao(estadioAtualizado.getLocalizacao());
        };

        if (estadioAtualizado.getTime() != null && estadioAtualizado.getTime().trim().isEmpty()){
            estadioExistente.setTime(estadioAtualizado.getTime());
        };

        return estadioRepository.save(estadioExistente);
    }

    public void deletar (Long id) {
        if (!estadioRepository.existsById(id)) {
            throw new IllegalArgumentException("Estadio não encontrado com o id: " + id);
        }
        estadioRepository.deleteById(id);
    }

}
