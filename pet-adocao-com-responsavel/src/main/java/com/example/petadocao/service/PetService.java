package com.example.petadocao.service;

import com.example.petadocao.model.Pet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {

    private final List<Pet> pets = new ArrayList<>();
    private int proximoId = 1;

    public PetService() {
        pets.add(new Pet(proximoId++, "Mel", "Cachorro", 2, "Disponível"));
        pets.add(new Pet(proximoId++, "Luna", "Gato", 1, "Disponível"));
        pets.add(new Pet(proximoId++, "Thor", "Cachorro", 4, "Disponível"));
    }

    public List<Pet> listarPets() {
        return pets;
    }

    public Pet buscarPetPorId(int id) {
        for (Pet pet : pets) {
            if (pet.getId() == id) {
                return pet;
            }
        }

        return null;
    }

    public String cadastrarPet(Pet pet) {
        if (pet.getNome() == null || pet.getNome().isBlank()) {
            return "Informe o nome do pet.";
        }

        if (pet.getTipo() == null || pet.getTipo().isBlank()) {
            return "Informe o tipo do pet.";
        }

        pet.setId(proximoId++);
        pet.setStatus("Disponível");
        pets.add(pet);

        return "Pet cadastrado com sucesso!";
    }

    public String adotarPet(int id) {
        Pet pet = buscarPetPorId(id);

        if (pet == null) {
            return "Pet não encontrado.";
        }

        if ("Adotado".equalsIgnoreCase(pet.getStatus())) {
            return "Esse pet já foi adotado.";
        }

        pet.setStatus("Adotado");
        return "Pet adotado com sucesso!";
    }

    public String editarPet(int id, Pet petAtualizado) {
        Pet pet = buscarPetPorId(id);

        if (pet == null) {
            return "Pet não encontrado.";
        }

        if (petAtualizado.getNome() == null || petAtualizado.getNome().isBlank()) {
            return "Informe o nome do pet.";
        }

        if (petAtualizado.getTipo() == null || petAtualizado.getTipo().isBlank()) {
            return "Informe o tipo do pet.";
        }

        pet.setNome(petAtualizado.getNome());
        pet.setTipo(petAtualizado.getTipo());
        pet.setIdade(petAtualizado.getIdade());

        return "Pet atualizado com sucesso!";
    }

    public String removerPet(int id) {
        Pet pet = buscarPetPorId(id);

        if (pet == null) {
            return "Pet não encontrado.";
        }

        pets.remove(pet);
        return "Pet removido com sucesso!";
    }
}
