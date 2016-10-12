/*
 
* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

/**
 *
 * @author Leonardo
 */

public class DaoHospede {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private final Connection conn;
    private final Statement stmt;
    private ResultSet result;
    private final PreparedStatement pstm, view;
    ResultSet rs;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Construtor">
    
    /**
     *
     * @param conn
     * @throws SQLException
     */
    public DaoHospede(Connection conn) throws SQLException {
        this.conn = conn;
        //Criando o Statement para conversaÃ§Ã£o com o banco
        stmt = (Statement) conn.createStatement();
        pstm = conn.prepareStatement("SELECT * FROM hospede");
        view = conn.prepareStatement("SELECT * FROM hospede ORDER BY nome");
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     *
     * @param hospede
     * @return int
     * @throws SQLException
     */
    public int inserir(Hospede hospede) throws SQLException {
        //Ordem dos valores: idhospede, nome, uf
        String SQL = "INSERT INTO hospede VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        int r;
        try (PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setInt(1, hospede.getIdHospede());
            ps.setString(2, hospede.getNome());
            ps.setString(3, hospede.getCPF());
            ps.setString(4, hospede.getEndRua());
            ps.setInt(5, hospede.getEndNumero());
            ps.setString(6, hospede.getEndComplemento());
            ps.setString(7, hospede.getEndBairro());
            ps.setString(8, hospede.getEndCidade());
            ps.setInt(9, hospede.getEndCEP());
            
            java.util.Date dj = hospede.getDataNascimento();
            Calendar c = Calendar.getInstance();
            c.setTime(dj);
            c.add(Calendar.DATE, 1);
            dj = c.getTime();
            
            java.sql.Date d = new java.sql.Date(dj.getTime());
            ps.setDate(10, d);
            ps.setInt(11, hospede.getTelefoneResidencia());
            ps.setInt(12, hospede.getTelefoneCelular());
            ps.setString(13, hospede.getIdentidade());
            ps.setString(14, hospede.getEmail());
            ps.setString(15, hospede.getSenha());

            r = ps.executeUpdate();
        }
        return r;
    }

    /**
     *
     * @param value
     * @return
     * @throws SQLException
     */
    public int excluir(int value) throws SQLException {
        String SQL = "DELETE FROM hospede where idHospede = " + value;
        return stmt.executeUpdate(SQL);
    }

    /**
     *
     * @param hospede
     * @throws SQLException
     */
    public void editar(Hospede hospede) throws SQLException {
        String SQL = "UPDATE hospede SET " +
                            "Nome = ? , " +
                            "CPF = ? , " +
                            "EndRua = ? , " +
                            "EndNumero = ? , " +
                            "EndComplemento = ? , " +
                            "EndBairro = ? , " +
                            "EndCidade = ? , " +
                            "EndCEP = ? , " +
                            "DataNascimento = ? , " +
                            "TelefoneResidencia = ? , " +
                            "TelefoneCelular = ? , " +
                            "Identidade = ? , " +
                            "Email = ? , " +
                            "Senha = ? " +
                            "WHERE `Email` = ?";
        /* Aqui vocÃª prepara a SQL para inserir os dadosCargo */
        PreparedStatement ps = conn.prepareStatement(SQL);
        /* que serÃ£o capturados aqui */
        ps.setString(1, hospede.getNome());
        ps.setString(2, hospede.getCPF());
        ps.setString(3, hospede.getEndRua());
        ps.setInt(4, hospede.getEndNumero());
        ps.setString(5, hospede.getEndComplemento());
        ps.setString(6, hospede.getEndBairro());
        ps.setString(7, hospede.getEndCidade());
        ps.setInt(8, hospede.getEndCEP());
            
        java.util.Date dj = hospede.getDataNascimento();
        Calendar c = Calendar.getInstance();
        c.setTime(dj);
        c.add(Calendar.DATE, 1);
        dj = c.getTime();

        java.sql.Date d = new java.sql.Date(dj.getTime());
        ps.setDate(9, d);
        ps.setInt(10, hospede.getTelefoneResidencia());
        ps.setInt(11, hospede.getTelefoneCelular());
        ps.setString(12, hospede.getIdentidade());
        ps.setString(13, hospede.getEmail());
        ps.setString(14, hospede.getSenha());
        ps.setString(15, hospede.getEmail());
        System.out.println(ps.toString());
        /* executando a atualizaÃ§Ã£o */
        ps.executeUpdate();
        ps.close();
    }
    
    /**
     *
     * @return
     * @throws SQLException
     */
    public ResultSet view() throws SQLException {
        result = pstm.executeQuery();
        return this.result;
    }
    
    /**
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    public Hospede bdToObject(ResultSet rs) throws SQLException {
        return new Hospede(rs.getInt("idHospede"),rs.getString("nome"),rs.getString("CPF"),rs.getString("EndRua"),rs.getInt("EndNumero"),rs.getString("EndComplemento"),rs.getString("EndBairro"),rs.getString("EndCidade"),rs.getInt("EndCEP"),rs.getDate("DataNascimento"),rs.getInt("TelefoneResidencia"),rs.getInt("TelefoneCelular"),rs.getString("Identidade"),rs.getString("Email"),rs.getString("Senha"));
    }
    
    /**
     *
     * @param id
     * @return tipo
     * @throws SQLException
     */
    public String buscarTipo(int id) throws SQLException {
        PreparedStatement pStm = conn.prepareStatement("CALL `reserva`.`BuscarTipo`(?);");
        pStm.setInt(1, id);
        rs = pStm.executeQuery();
        rs.next();
        String tipo = rs.getString("Tipo");
        return tipo;
    }
    
    /**
     *
     * @param id
     * @return hospede
     * @throws SQLException
     */
    public Hospede pesquisaID(int id) throws SQLException {
        Hospede hospede;
        PreparedStatement pStm = conn.prepareStatement("SELECT * FROM hospede WHERE idHospede = ? ");
        pStm.setInt(1, id);
        ResultSet rs;
        rs = pStm.executeQuery();
        rs.next();
        hospede = bdToObject(rs);
        return hospede;
    }
    
    /**
     *
     * @param Email
     * @return boolean
     * @throws SQLException
     */
    public boolean pesquisaEm(String Email) throws SQLException {
        Hospede hospede;
        PreparedStatement pStm = conn.prepareStatement("SELECT * FROM hospede WHERE Email = ?");
        pStm.setString(1, Email);
        ResultSet rs;
        rs = pStm.executeQuery();
        if (!rs.isBeforeFirst() ) {    
            return false; 
        } else {
            return true;
        }
    }
    
    /**
     *
     * @param Email
     * @param Senha
     * @return hospede
     * @throws SQLException
     */
    public Hospede pesquisaES(String Email, String Senha) throws SQLException {
        Hospede hospede;
        PreparedStatement pStm = conn.prepareStatement("SELECT * FROM hospede WHERE Email = ? and Senha = ?");
        pStm.setString(1, Email);
        pStm.setString(2, Senha);
        ResultSet rs;
        rs = pStm.executeQuery();
        if (!rs.isBeforeFirst() ) {    
            return null; 
        } else {
            rs.next();
            hospede = bdToObject(rs);
            return hospede;
        }
    }
    //</editor-fold>
}