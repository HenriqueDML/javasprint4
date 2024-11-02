package org.example.DAO;

import org.example.model.Cliente;
import java.sql.*;

public class ClienteDAO implements DAOCliente {
    ConexaoBD cone = new ConexaoBD();
    public boolean cadastrarCliente(Cliente cliente) {
        cone.conectar();
        Connection con = cone.getConexao ();
        String sql = "INSERT INTO t_cliente (nome_cliente, senha_cliente, cpf_cnpj_cliente, email_cliente) VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getSenha());
            pst.setString(3, cliente.getCpf());
            pst.setString(4, cliente.getEmail());
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    public void getDados(Cliente cliente) throws SQLException {
        String sql = "SELECT id_cliente, nome_cliente, email_cliente, senha_cliente, cpf_cnpj_cliente FROM t_cliente WHERE email_cliente = ? AND senha_cliente=?";
        cone.conectar();
        Connection con = cone.getConexao ();
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, cliente.getEmail());
        statement.setString(2, cliente.getSenha());
        ResultSet result = statement.executeQuery();

        if (result.next()) {
            cliente.setIdCliente(result.getInt(1));
            cliente.setNome(result.getString(2));
            cliente.setEmail(result.getString(3));
            cliente.setSenha(result.getString(4));
            cliente.setCpf(result.getString(5));
        } else {
            System.out.println("Nenhum dado encontrado");
        }

        result.close();
        statement.close();
        con.close();
    }

    public void autenticarCliente(Cliente cliente) throws SQLException {
        String sql = "SELECT id_cliente, nome_cliente, email_cliente, cpf_cnpj_cliente FROM t_cliente WHERE email_cliente = ? AND senha_cliente = ?";
        cone.conectar();
        Connection con = cone.getConexao();
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, cliente.getEmail());
        statement.setString(2, cliente.getSenha());
        ResultSet result = statement.executeQuery();

        if (result.next()) {
            cliente.setIdCliente(result.getInt(1));
            cliente.setNome(result.getString(2));
            cliente.setEmail(result.getString(3));
            cliente.setCpf(result.getString(4));
        } else {
            System.out.println("Email ou senha incorretos.");
        }
        result.close();
        statement.close();
        con.close();
    }

    public boolean verificarCliente(Cliente cliente) {
        cone.conectar ();
        Connection con = cone.getConexao ();
        String sql = "SELECT * FROM t_cliente WHERE email_cliente = ? and senha_cliente = ?";
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cliente.getEmail());
            pst.setString(2, cliente.getSenha());
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void alterarCliente(Cliente cliente) {
        cone.conectar();
        Connection con = cone.getConexao();
        String sql = "UPDATE t_cliente SET nome_cliente = ?, senha_cliente = ?, cpf_cnpj_cliente = ?, email_cliente = ? WHERE id_cliente = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getSenha());
            pst.setString(3, cliente.getCpf());
            pst.setString(4, cliente.getEmail());
            pst.setInt(5, cliente.getIdCliente());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public boolean removerCliente(String email) {
    cone.conectar ();
        Connection con = cone.getConexao ();
        String sql = "DELETE FROM t_cliente WHERE email_cliente = ?";
        try {
             PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, email);
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        }
    }

