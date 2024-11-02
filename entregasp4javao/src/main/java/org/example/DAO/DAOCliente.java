package org.example.DAO;

import org.example.model.Cliente;

import java.sql.SQLException;

public interface DAOCliente {
    boolean cadastrarCliente(Cliente cliente);
    void getDados(Cliente cliente) throws SQLException;
    boolean verificarCliente(Cliente cliente);
    void alterarCliente(Cliente cliente);
    boolean removerCliente(String email);
}


