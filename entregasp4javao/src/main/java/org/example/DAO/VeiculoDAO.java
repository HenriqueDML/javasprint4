package org.example.DAO;

import org.example.model.Veiculo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {
    ConexaoBD cone = new ConexaoBD();

    public boolean cadastrarVeiculo(Veiculo veiculo) {
        cone.conectar();
        Connection con = cone.getConexao();
        String sql = "INSERT INTO t_veiculo (placa, modelo, marca, id_cliente) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, veiculo.getPlaca());
            pst.setString(2, veiculo.getModelo());
            pst.setString(3, veiculo.getMarca());
            pst.setInt(4, veiculo.getIdCliente());
            pst.executeUpdate();
            return true;
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

    public List<Veiculo> getListaV(int id) throws SQLException {
        List<Veiculo> listaVeiculos = new ArrayList<>();
        String sql = "SELECT placa, modelo, marca, id_cliente, id_veiculo FROM t_veiculo WHERE id_cliente = ?";
        cone.conectar();
        Connection con = cone.getConexao();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    Veiculo veiculo = new Veiculo();
                    veiculo.setPlaca(result.getString("placa"));
                    veiculo.setModelo(result.getString("modelo"));
                    veiculo.setMarca(result.getString("marca"));
                    veiculo.setIdCliente(result.getInt("id_cliente"));
                    veiculo.setIdVeiculo(result.getInt("id_veiculo"));
                    listaVeiculos.add(veiculo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Re-throw the exception for further handling
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaVeiculos;
    }

    public void getDados(Veiculo veiculo) throws SQLException {
        String sql = "SELECT placa, modelo, marca FROM t_veiculo WHERE id_cliente = ?";
        cone.conectar();
        Connection con = cone.getConexao ();
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, veiculo.getIdCliente());

        ResultSet result = statement.executeQuery();

        if (result.next()) {
            veiculo.setPlaca(result.getString(1));
            veiculo.setModelo(result.getString(2));
            veiculo.setMarca(result.getString(3));
        } else {
            System.out.println("Nenhum dado encontrado");
        }

        result.close();
        statement.close();
        con.close();
    }

    public boolean verificarVeiculo(Veiculo veiculo) {
        cone.conectar();
        Connection con = cone.getConexao();
        String sql = "SELECT * FROM t_veiculo WHERE id_cliente = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, veiculo.getIdCliente());
            ResultSet rs = pst.executeQuery();
            return rs.next();
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

    public boolean alterarVeiculo(Veiculo veiculo) {
        cone.conectar();
        Connection con = cone.getConexao();
        String sql = "UPDATE t_veiculo SET modelo = ?, marca = ?, placa = ? WHERE id_veiculo = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, veiculo.getModelo());
            pst.setString(2, veiculo.getMarca());
            pst.setString(3, veiculo.getPlaca());
            pst.setInt(4, veiculo.getIdVeiculo());
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

    public Veiculo buscarVeiculoPorId(int idVeiculo) {
        cone.conectar();
        Connection con = cone.getConexao();
        String sql = "SELECT * FROM t_veiculo WHERE id_veiculo = ?";
        Veiculo veiculo = null;

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idVeiculo);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                veiculo = new Veiculo();
                veiculo.setIdVeiculo(rs.getInt("id_veiculo"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setIdCliente(rs.getInt("id_cliente"));
            }

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

        return veiculo;
    }

    public boolean removerVeiculo(String placa) {
        cone.conectar();
        Connection con = cone.getConexao();
        String sql = "DELETE FROM t_veiculo WHERE placa = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, placa);
            System.out.println("Executando: " + sql + " com placa: " + placa); // Log da operação
            int rowsAffected = pst.executeUpdate();
            System.out.println("Linhas afetadas: " + rowsAffected); // Log do resultado
            return rowsAffected > 0; // Retorna true se a deleção for bem-sucedida
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
