package org.example.DAO;

import java.sql.*;

public class ConexaoBD {
    private String driverJDBC = "oracle.jdbc.driver.OracleDriver";
    private String server = "oracle.fiap.com.br";
    private String port = "1521";
    private String user = "rm558062";
    private String passwd = "120297";
    private String sid = "ORCL";
    private String url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + sid;//sempre vai ser a mesma
    private Connection con = null;

    public Connection getConexao() {
        return con;
    }

    public void conectar(){
        try {
            Class.forName (driverJDBC);//carregando Driver
            //Realizando conexão
            con = DriverManager.getConnection (url , user , passwd);
        } catch (Exception e) {
            System.out.println ("Erro");
            e.printStackTrace ();

        }
    }
}
