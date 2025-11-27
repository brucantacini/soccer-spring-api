package com.example.soccer_spring_api.Service;

import com.example.soccer_spring_api.Entity.Arbitro;
import com.example.soccer_spring_api.Repository.ArbitroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArbitroService {

    @Autowired
    private ArbitroRepository arbitroRepository;

    //  crud

    //create
    public Arbitro criar(Arbitro arbitro) {
        if (arbitro.getNome() == null || arbitro.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do árbitro é obrigatório");
        }
        if (arbitro.getFuncao() == null || arbitro.getFuncao().trim().isEmpty()) {
            throw new IllegalArgumentException("Função do árbitro é obrigatório");
        }

        return arbitroRepository.save(arbitro);
    }

    //read
    public List<Arbitro> listarTodos () {
        return arbitroRepository.findAll();
    }

    //read by id
    public Optional<Arbitro> buscarPorId (Long id) {
        return arbitroRepository.findById(id);
    }

    //updtate
    public Arbitro atualizar(Long id, Arbitro arbitroAtualizado) {
        Optional<Arbitro> arbitroOptional = arbitroRepository.findById(id);

        if (arbitroOptional.isEmpty()) {
            throw new IllegalArgumentException("Árbitro não encontrado com o id" + id);
        }

        Arbitro arbitroExistente = arbitroOptional.get();

        if (arbitroAtualizado.getNome() != null && !arbitroAtualizado.getNome().trim().isEmpty()) {
            arbitroExistente.setNome(arbitroAtualizado.getNome());
        }
        if (arbitroAtualizado.getFuncao() != null && !arbitroAtualizado.getFuncao().trim().isEmpty()){
            arbitroExistente.setFuncao(arbitroAtualizado.getFuncao());
        }
        if (arbitroAtualizado.getCartoesDados() != null){
            arbitroExistente.setCartoesDados(arbitroAtualizado.getCartoesDados());
        }
        if (arbitroAtualizado.getNivelExperiencia() != null){
            arbitroExistente.setNivelExperiencia(arbitroAtualizado.getNivelExperiencia());
        }
        if (arbitroAtualizado.getPartidasApitadas() != null){
            arbitroExistente.setPartidasApitadas(arbitroAtualizado.getPartidasApitadas());
        }

        return arbitroRepository.save(arbitroExistente);
    }

    //delete
    public void deletar (Long id){
        if (!arbitroRepository.existsById(id)) {
            throw new IllegalArgumentException("Árbitro não encontrado com o id " + id);
        }

        arbitroRepository.deleteById(id);
    }

}
