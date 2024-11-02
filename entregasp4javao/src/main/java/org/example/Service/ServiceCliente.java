package org.example.Service;

import org.example.DAO.ClienteDAO;
import org.example.model.Cliente;

import java.sql.SQLException;

public class ServiceCliente {
    ClienteDAO funciona = new ClienteDAO();
    //Criando do CRUD
    public Cliente cadastroCliente (Cliente cliente){
        funciona.cadastrarCliente(cliente);
        return cliente;
    }
    // login e verifica do CRUD
    public Cliente loginCliente (Cliente cliente) throws SQLException {
        if (funciona.verificarCliente(cliente)){
            funciona.getDados(cliente);
            return cliente;
        }else{
        return null;}
    }
    // altera e verifica do CRUD
    public Cliente alteradoCliente (Cliente cliente) throws SQLException {
        funciona.alterarCliente(cliente);
        funciona.getDados(cliente);
        return cliente;

    }
    // autentica emaile senha para login
    public Cliente autenticadoCliente (Cliente cliente) throws SQLException{
        funciona.autenticarCliente(cliente);
        return cliente;
    }

    // read do CRUD
    public Cliente lendoCliente (String email) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setEmail(email);
        if (funciona.verificarCliente(cliente)){
            funciona.getDados(cliente);
            return cliente;
        } else {
            return null;
        }
    }

    // Delete do CRUD
    public int removoCliente(String email){
        if (funciona.removerCliente(email)){
            return 1; // cliente removido
        }
        else{
            return 0;} // se retornar zero não existe
    }
}

