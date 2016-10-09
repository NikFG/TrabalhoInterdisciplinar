package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nikollas
 */
public class DaoQuarto {

    private final Connection conn;
    private final Statement stmt;
    private ResultSet result;
    private final PreparedStatement pstm;

    public DaoQuarto(Connection conn) throws SQLException {
        this.conn = conn;
        stmt = (Statement) conn.createStatement();
        pstm = conn.prepareStatement("SELECT * FROM quarto");
    }

    public int inserir(Quarto quarto) throws SQLException {
        String SQL = "insert into quarto(Localizacao, Andar, Tipo, ArCondicionado, ValorDiaria, Capacidade) "
                + "values(?,?,?,?,?,?)";
        int result;
        try (PreparedStatement ps = conn.prepareStatement(SQL)) {
            //ps.setInt(1, quarto.getIdQuarto());
            ps.setString(1, quarto.getLocalizacao());
            ps.setInt(2, quarto.getAndar());
            ps.setString(3, quarto.getTipo());
            ps.setInt(4, quarto.getArCondicionado());
            ps.setDouble(5, quarto.getValorDiaria());
            ps.setInt(6, quarto.getCapacidade());
            result = ps.executeUpdate();
        }
        return result;
    }

    public int excluir(int idQuarto) throws SQLException {
        String SQL = "DELETE FROM quarto where idQuarto=" + idQuarto;
        return stmt.executeUpdate(SQL);
    }

    public void editar(Quarto quarto) throws SQLException {
        String SQL = "udpdate quarto set"
                + "Localizacao=?, "
                + "Andar=?, Tipo=?, "
                + "ArCondicionado=?, ValorDiaria=?, Capacidade=?"
                + "where idQuarto=?";
        try (PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setInt(1, quarto.getIdQuarto());
            ps.setString(2, quarto.getLocalizacao());
            ps.setInt(3, quarto.getAndar());
            ps.setString(4, quarto.getTipo());
            ps.setInt(5, quarto.getArCondicionado());
            ps.setDouble(6, quarto.getValorDiaria());
            ps.setInt(7, quarto.getCapacidade());
            ps.executeUpdate();
        }
    }

    public ResultSet view() throws SQLException {
        result = pstm.executeQuery();
        return this.result;
    }

    public Quarto bdToObject(ResultSet rs) throws SQLException {
        return new Quarto(rs.getInt("idQuarto"), rs.getInt("Capacidade"), rs.getInt("Andar"), rs.getString("Localizacao"),
                rs.getInt("ArCondicionado"), rs.getString("Tipo"), rs.getDouble("ValorDiaria"));

    }

    public Quarto pesquisaID(int id) throws SQLException {
        Quarto quarto;
        PreparedStatement pStm = conn.prepareStatement("select * from estados where idQuarto = ?");
        pStm.setInt(1, id);
        ResultSet rs;
        rs = pStm.executeQuery();
        rs.next();
        quarto = bdToObject(rs);
        return quarto;
    }

    public Quarto pesquisaCapacidade(int capacidade) throws SQLException {
        Quarto quarto;
        PreparedStatement pStm = conn.prepareStatement("select * from estados where Capacidade = ?");
        pStm.setInt(1, capacidade);
        ResultSet rs;
        rs = pStm.executeQuery();
        rs.next();
        quarto = bdToObject(rs);
        return quarto;
    }

    public Quarto pesquisaLocalizacao(String localizacao) throws SQLException {
        Quarto quarto;
        PreparedStatement pStm = conn.prepareStatement("select * from estados where Localizacao = ?");
        pStm.setString(1, localizacao);
        ResultSet rs;
        rs = pStm.executeQuery();
        rs.next();
        quarto = bdToObject(rs);
        return quarto;
    }

    public Quarto pesquisaArCondicionado(int arCondicionado) throws SQLException {
        Quarto quarto;
        PreparedStatement pStm = conn.prepareStatement("select * from estados where ArCondicionado = ?");
        pStm.setInt(1, arCondicionado);
        ResultSet rs;
        rs = pStm.executeQuery();
        rs.next();
        quarto = bdToObject(rs);
        return quarto;
    }
    public Quarto pesquisaTipo(String tipo) throws SQLException {
        Quarto quarto;
        PreparedStatement pStm = conn.prepareStatement("select * from estados where Tipo = ?");
        pStm.setString(1, tipo);
        ResultSet rs;
        rs = pStm.executeQuery();
        rs.next();
        quarto = bdToObject(rs);
        return quarto;
    }
    public Quarto pesquisaValorDiaria(double valorDiaria) throws SQLException {
        Quarto quarto;
        PreparedStatement pStm = conn.prepareStatement("select * from estados where ValorDiaria = ?");
        pStm.setDouble(1, valorDiaria);
        ResultSet rs;
        rs = pStm.executeQuery();
        rs.next();
        quarto = bdToObject(rs);
        return quarto;
    }
}