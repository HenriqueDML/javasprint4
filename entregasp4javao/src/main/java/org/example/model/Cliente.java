package org.example.model;

public class Cliente {
    private int idCliente;
    private String nome;
    private String senha;
    private String cpf;
    private String email;

    public Cliente() {}

    public Cliente(int idCliente, String nome, String senha, String cpf, String email) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.email = email;
    }

    // Getters e Setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }


}