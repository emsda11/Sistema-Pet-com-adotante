package com.example.petadocao.model;

public class Adotante {

    private int id;
    private String nome;
    private String telefone;
    private String cidade;
    private int idPetDesejado;

    public Adotante() {
    }

    public Adotante(int id, String nome, String telefone, String cidade, int idPetDesejado) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cidade = cidade;
        this.idPetDesejado = idPetDesejado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getIdPetDesejado() {
        return idPetDesejado;
    }

    public void setIdPetDesejado(int idPetDesejado) {
        this.idPetDesejado = idPetDesejado;
    }
}
