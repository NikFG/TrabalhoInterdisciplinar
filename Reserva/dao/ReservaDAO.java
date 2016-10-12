package dao;

import dao.ConFactory;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;
import reserva.Reserva;

public class ReservaDAO {

    private final String URL = "jdbc:mysql://localhost/javafx_crud",
            NOME = "root", SENHA = "123456";

    private Connection con;
    private Statement comando;

    public ReservaDAO() throws SQLException {
        this.comando = (Statement) con.createStatement();
    }

    public void apagar(String rg) throws SQLException, ClassNotFoundException {
        conectar();
        con = getDBConnection();
        comando = (Statement) con.createStatement();
        //  this.comando.executeUpdate("DELETE FROM reserva");
        fechar();
    }

    public void insere(Reserva reserva) throws SQLException, ClassNotFoundException {
        conectar();
        /*comando.executeQuery("INSERT INTO Reserva VALUES('"
              + reserva.getData() + "', '" + reserva.getInicioPeriodo() + "',"
              + reserva.getFimPeriodo() + ",'" + reserva.getResponsavel() + "')");*/
        System.out.println("Inserida!");
        fechar();
    }

    private void conectar() throws SQLException, ClassNotFoundException {
        con = ConFactory.conexao(URL, NOME, SENHA, ConFactory.MYSQL);
        comando = (Statement) con.createStatement();
        System.out.println("Conectado!");
    }

    private void fechar() throws SQLException {
        con.close();
        System.out.println("Conexão Fechada");
    }

    private Connection getDBConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void insert(Reserva reserva) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
