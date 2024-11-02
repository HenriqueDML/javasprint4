package org.example.model;

public class Veiculo {
    private int idVeiculo;
    private String placa;
    private String modelo;
    private String marca;
    private int idCliente;

    public Veiculo() {}

    public Veiculo(int idVeiculo, String placa, String modelo, String marca, int idCliente) {
        this.idVeiculo = idVeiculo;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.idCliente = idCliente;
    }

    // Getters e Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public int getIdCliente() {return idCliente;}

    public void setIdCliente(int idCliente) {this.idCliente = idCliente;}

}
