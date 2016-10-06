/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonardo
 */
public class Conector {

    private Connection conexao = null;
    private static final String DRIVER_PADRAO_MYSQL = "com.mysql.jdbc.Driver";
    private static final String URL_PADRAO_MYSQL = "jdbc:mysql://localhost:3306/";
    private static final String NOME_BANCO = "reserva";
    private static final String USUARIO = "root";
    private static final String SENHA = ""; //para ser concatenada com o nome do banco

    /**
     * Construtor para conexÃ£o com uma base de dados qualquer, nÃ£o
     * necessariamente o MySQL
     *
     * @param driver - passa o driver do banco para conexÃ£o
     * @param url - passa a url(caminho) da base de dados especificada
     * @param nomeBanco - nome da base de dados, serÃ¡ concatenada com url
     * @param usuario - nome do usuario do banco
     * @param senha - senha do usuario do banco
     */
    public Conector(String driver, String url, String nomeBanco, String usuario, String senha) {
        try {
            String urlFinal = url + nomeBanco;
            Class.forName(driver);
            this.conexao = DriverManager.getConnection(urlFinal, usuario, senha);
            System.out.println("ConexÃ£o com o banco estabelecida com sucesso!");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Construtor padrÃ£o para conexÃ£o com bancos MySQL - Os parametros padrÃµes
     * como o driver e a url sÃ£o invocados automaticamente.
     *
     * @param nomeBanco Nome da base de dados
     * @param usuario Nome do usuÃ¡rio da base
     * @param senha Senha do usuario
     */
    public Conector(String nomeBanco, String usuario, String senha) {
        this(DRIVER_PADRAO_MYSQL, URL_PADRAO_MYSQL, nomeBanco, usuario, senha);
    }
    
    public Conector() {
        this(DRIVER_PADRAO_MYSQL, URL_PADRAO_MYSQL, NOME_BANCO, USUARIO, SENHA);
    }

    public void fecharResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void fecharStatement(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void fecharConexao() {
        if (this.conexao != null) {
            try {
                this.conexao.close();
                System.out.println("Conexão com o banco encerrada");
            } catch (SQLException ex) {
                Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Connection getConexao() {
        return conexao;
    }

}
