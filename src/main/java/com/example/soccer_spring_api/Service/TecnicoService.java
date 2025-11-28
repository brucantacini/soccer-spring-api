package com.example.soccer_spring_api.Service;

import com.example.soccer_spring_api.Entity.Tecnico;
import com.example.soccer_spring_api.Repository.TecnicoRepostitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepostitory tecnicoRepostitory;

    public Tecnico Criar (Tecnico tecnico) {
        if (tecnico.getNome() == null || tecnico.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Campo nome é obrigatório");
        }
        if (tecnico.getTime() == null || tecnico.getTime().trim().isEmpty()) {
            throw new IllegalArgumentException("Campo time é obrigatório");
        }
        return tecnicoRepostitory.save(tecnico);
    }

    public List<Tecnico> listarTodos () {
        return tecnicoRepostitory.findAll();
    }

    public Optional<Tecnico> buscarPorId (Long id) {
        return tecnicoRepostitory.findById(id);
    }

    public Tecnico atualizar (Long id, Tecnico tecnicoAtualizado) {
        Optional<Tecnico> tecnicoOptional = tecnicoRepostitory.findById(id);

        if (tecnicoOptional.isEmpty()) {
            throw new IllegalArgumentException("Tecnico não encontrado com o id" + id);
        }

        Tecnico tecnicoExistente = tecnicoOptional.get();

        if (tecnicoAtualizado.getNome() != null && !tecnicoAtualizado.getNome().trim().isEmpty()) {
            tecnicoExistente.setNome(tecnicoAtualizado.getNome());
        }

        if (tecnicoAtualizado.getTime() != null && !tecnicoAtualizado.getTime().trim().isEmpty()) {
            tecnicoExistente.setTime(tecnicoAtualizado.getTime());
        }

        if (tecnicoAtualizado.getIdade() != null) {
            tecnicoExistente.setIdade(tecnicoAtualizado.getIdade());
        }

        if (tecnicoAtualizado.getCartoesAmarelos() != null) {
            tecnicoExistente.setCartoesAmarelos(tecnicoAtualizado.getCartoesAmarelos());
        }

        if (tecnicoAtualizado.getCartoesVermelhos() != null) {
            tecnicoExistente.setCartoesVermelhos(tecnicoAtualizado.getCartoesVermelhos());
        }

        return tecnicoRepostitory.save(tecnicoExistente);
    }

    public void Deletar (Long id) {
        if (!tecnicoRepostitory.existsById(id)) {
            throw new IllegalArgumentException("Tecnico nao encontrado com o id: " + id);
        }

        tecnicoRepostitory.deleteById(id);
    }



}
