/*
 
* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.Date;
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

    private final Connection conn;
    private final Statement stmt;
    private ResultSet result;
    private final PreparedStatement pstm, view;

    public DaoHospede(Connection conn) throws SQLException {
        this.conn = conn;
        //Criando o Statement para conversaÃ§Ã£o com o banco
        stmt = (Statement) conn.createStatement();
        pstm = conn.prepareStatement("SELECT * FROM hospede");
        view = conn.prepareStatement("SELECT * FROM hospede ORDER BY nome");
    }

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

    public int excluir(int value) throws SQLException {
        String SQL = "DELETE FROM hospede where idHospede = " + value;
        return stmt.executeUpdate(SQL);
    }

    public void editar(Hospede hospede) throws SQLException {
        String SQL = "UPDATE hospede SET" +
                            "idHospede = ? , " +
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
                            "Senha = ? , " +
                            "WHERE `idHospede` = ?";
        /* Aqui vocÃª prepara a SQL para inserir os dadosCargo */
        PreparedStatement ps = conn.prepareStatement(SQL);
        /* que serÃ£o capturados aqui */
        ps.setInt(1, hospede.getIdHospede());
        ps.setString(2, hospede.getNome());
        ps.setString(3, hospede.getCPF());
        ps.setString(4, hospede.getEndRua());
        ps.setInt(5, hospede.getEndNumero());
        ps.setString(6, hospede.getEndComplemento());
        ps.setString(7, hospede.getEndBairro());
        ps.setString(8, hospede.getEndCidade());
        ps.setInt(9, hospede.getEndCEP());
        ps.setDate(10, (Date) hospede.getDataNascimento());
        ps.setInt(11, hospede.getTelefoneResidencia());
        ps.setInt(12, hospede.getTelefoneCelular());
        ps.setString(13, hospede.getIdentidade());
        ps.setString(14, hospede.getEmail());
        ps.setString(15, hospede.getSenha());
        /* executando a atualizaÃ§Ã£o */
        ps.executeUpdate();
        ps.close();
    }
    
    public ResultSet view() throws SQLException {
        result = pstm.executeQuery();
        return this.result;
    }
    
    public Hospede bdToObject(ResultSet rs) throws SQLException {
        return new Hospede(rs.getInt("idHospede"),rs.getString("nome"),rs.getString("CPF"),rs.getString("EndRua"),rs.getInt("EndNumero"),rs.getString("EndComplemento"),rs.getString("EndBairro"),rs.getString("EndCidade"),rs.getInt("EndCEP"),rs.getDate("DataNascimento"),rs.getInt("TelefoneResidencia"),rs.getInt("TelefoneCelular"),rs.getString("Identidade"),rs.getString("Email"),rs.getString("Senha"));
    }
    
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
            ResultSet rs;
}