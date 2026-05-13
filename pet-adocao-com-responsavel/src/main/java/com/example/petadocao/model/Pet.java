package com.example.petadocao.model;

public class Pet {

    private int id;
    private String nome;
    private String tipo;
    private int idade;
    private String status;

    public Pet() {
    }

    public Pet(int id, String nome, String tipo, int idade, String status) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.idade = idade;
        this.status = status;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
