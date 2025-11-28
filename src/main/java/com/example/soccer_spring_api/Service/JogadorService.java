package com.example.soccer_spring_api.Service;

import com.example.soccer_spring_api.Entity.Jogador;
import com.example.soccer_spring_api.Repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    public Jogador criar (Jogador jogador) {
        if (jogador.getTime() == null || jogador.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Campo nome é obrigatório");
        }
        if (jogador.getNacionalidade() == null || jogador.getNacionalidade().trim().isEmpty()) {
            throw new IllegalArgumentException("Nacionalidade do jogador é obrigatório");
        }
        if (jogador.getNumeroCamisa() == null) {
            throw new IllegalArgumentException("Número da camisa obrigatório");
        }
        if (jogador.getIdade() == null) {
            throw new IllegalArgumentException("Idade do jogador obrigatório");
        }

        return jogadorRepository.save(jogador);
    }

    public List<Jogador> listarTodos () {
        return jogadorRepository.findAll();
    }

    public Optional<Jogador> buscarPorId (Long id) {
        if (!jogadorRepository.existsById(id)) {
            throw new IllegalArgumentException("Jogador não encontrado com o id " + id);
        }

        return jogadorRepository.findById(id);
    }

    public Jogador atualizar (Long id, Jogador jogadorAtualizado) {

        Optional<Jogador> jogadorOptional = jogadorRepository.findById(id);

        if (!jogadorRepository.existsById(id)) {
            throw new IllegalArgumentException("Jogador não encontrado com o id " + id);
        }

        Jogador jogadorExistente = jogadorOptional.get();

        if (jogadorAtualizado.getNome() != null && jogadorAtualizado.getNome().trim().isEmpty()) {
            jogadorExistente.setNome(jogadorAtualizado.getNome());
        }

        if (jogadorAtualizado.getTime() != null && jogadorAtualizado.getTime().trim().isEmpty()) {
            jogadorExistente.setTime(jogadorAtualizado.getTime());
        }

        if (jogadorAtualizado.getIdade() != null && jogadorAtualizado.getTime().trim().isEmpty()) {
            jogadorExistente.setTime(jogadorAtualizado.getTime());
        }

        if (jogadorAtualizado.getNumeroCamisa() != null) {
            jogadorExistente.setNumeroCamisa(jogadorAtualizado.getNumeroCamisa());
        }
        if (jogadorAtualizado.getCartoesAmarelos() != null) {
            jogadorExistente.setCartoesAmarelos(jogadorAtualizado.getCartoesAmarelos());
        }
        if (jogadorAtualizado.getCartoesVermelhos() != null) {
            jogadorExistente.setCartoesVermelhos(jogadorAtualizado.getCartoesVermelhos());
        }
        if (jogadorAtualizado.getPartidasJogadas() != null) {
            jogadorExistente.setPartidasJogadas(jogadorAtualizado.getPartidasJogadas());
        }
        if (jogadorAtualizado.getGols() != null) {
            jogadorExistente.setGols(jogadorAtualizado.getGols());
        }

        return jogadorRepository.save(jogadorExistente);
    }

    public void deletar (Long id) {
        if (!jogadorRepository.existsById(id)){
            throw new IllegalArgumentException("Jogador não encontrado com o id " + id);
        }
        jogadorRepository.deleteById(id);
    }

}
