package org.example.Service;

import org.example.DAO.VeiculoDAO;
import org.example.model.Veiculo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceVeiculo {
    VeiculoDAO faz = new VeiculoDAO();
    //CRIANDO DO CRUD
    public Veiculo cadastroVeiculo(Veiculo veiculo){
        faz.cadastrarVeiculo(veiculo);
        return veiculo;
    }
    //ALTERA E VERIFICA DO CRUD
    public Veiculo alteradoVeiculo (Veiculo veiculo) throws SQLException {
        if(faz.alterarVeiculo(veiculo)){
            faz.getDados(veiculo);
            return veiculo;
        } else {
            return null;
        }
    }

    //busca VEICULO
    public Veiculo buscarVeiculoPorId(int idVeiculo) {
        return faz.buscarVeiculoPorId(idVeiculo);
    }

    //READ DO CRUD
    public List<Veiculo> lendoVeiculo (int id_cliente) throws SQLException{
        Veiculo veiculo = new Veiculo();
        veiculo.setIdCliente(id_cliente);
        List<Veiculo> listaVeiculos = new ArrayList<>();
        if(faz.verificarVeiculo(veiculo)){
            listaVeiculos = faz.getListaV(veiculo.getIdCliente());
            return listaVeiculos;
        } else{
            return null;
        }
    }
    //DELETE DO CRUD
    public boolean removoVeiculo (String placa){
        if (faz.removerVeiculo(placa)){
            return true;//carro removido
        }else{
            return true;// carro n existe
        }
    }

}
