package org.example.DAO;

import org.example.model.Veiculo;
import java.sql.SQLException;

public interface DAOVeiculo {
    boolean cadastrarVeiculo(Veiculo veiculo);
    void getDados(Veiculo veiculo) throws SQLException;
    boolean verificarVeiculo(Veiculo veiculo);
    boolean alterarVeiculo(Veiculo veiculo);
    boolean removerVeiculo(String placa);
}
