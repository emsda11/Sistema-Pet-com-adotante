package com.example.petadocao.service;

import com.example.petadocao.model.Adotante;
import com.example.petadocao.model.Pet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdotanteService {

    private final List<Adotante> adotantes = new ArrayList<>();
    private int proximoId = 1;

    private final PetService petService;

    public AdotanteService(PetService petService) {
        this.petService = petService;
    }

    public List<Adotante> listarAdotantes() {
        return adotantes;
    }

    public Adotante buscarAdotantePorId(int id) {
        for (Adotante adotante : adotantes) {
            if (adotante.getId() == id) {
                return adotante;
            }
        }

        return null;
    }

    public String cadastrarAdotante(Adotante adotante) {
        if (adotante.getNome() == null || adotante.getNome().isBlank()) {
            return "Informe o nome do adotante.";
        }

        if (adotante.getTelefone() == null || adotante.getTelefone().isBlank()) {
            return "Informe o telefone do adotante.";
        }

        Pet pet = petService.buscarPetPorId(adotante.getIdPetDesejado());

        if (pet == null) {
            return "Pet desejado não encontrado.";
        }

        adotante.setId(proximoId++);
        adotantes.add(adotante);

        return "Adotante cadastrado com sucesso!";
    }

    public String editarAdotante(int id, Adotante adotanteAtualizado) {
        Adotante adotante = buscarAdotantePorId(id);

        if (adotante == null) {
            return "Adotante não encontrado.";
        }

        Pet pet = petService.buscarPetPorId(adotanteAtualizado.getIdPetDesejado());

        if (pet == null) {
            return "Pet desejado não encontrado.";
        }

        adotante.setNome(adotanteAtualizado.getNome());
        adotante.setTelefone(adotanteAtualizado.getTelefone());
        adotante.setCidade(adotanteAtualizado.getCidade());
        adotante.setIdPetDesejado(adotanteAtualizado.getIdPetDesejado());

        return "Adotante atualizado com sucesso!";
    }

    public String removerAdotante(int id) {
        Adotante adotante = buscarAdotantePorId(id);

        if (adotante == null) {
            return "Adotante não encontrado.";
        }

        adotantes.remove(adotante);
        return "Adotante removido com sucesso!";
    }
}
