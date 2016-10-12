/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import conexao.Conector;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import model.DaoHospede;
import model.Hospede;

/**
 *
 * @author Leonardo
 */

@ManagedBean
public class Edita {
    
    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private int idHospede;
    private String nome;
    private String CPF;
    private String EndRua;
    private int EndNumero;
    private String EndComplemento;
    private String EndBairro;
    private String EndCidade;
    private int EndCEP;
    private Date DataNascimento;
    private int TelefoneResidencia;
    private int TelefoneCelular;
    private String Identidade;
    private String Email;
    private String Senha;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Construtor">
    /**
     *
     */
    public Edita() {
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">

    /**
     *
     * @return
     */
    public int getIdHospede() {
        return idHospede;
    }

    /**
     *
     * @param idHospede
     */
    public void setIdHospede(int idHospede) {
        this.idHospede = idHospede;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public String getCPF() {
        return CPF;
    }

    /**
     *
     * @param CPF
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    /**
     *
     * @return
     */
    public String getEndRua() {
        return EndRua;
    }

    /**
     *
     * @param EndRua
     */
    public void setEndRua(String EndRua) {
        this.EndRua = EndRua;
    }

    /**
     *
     * @return
     */
    public int getEndNumero() {
        return EndNumero;
    }

    /**
     *
     * @param EndNumero
     */
    public void setEndNumero(int EndNumero) {
        this.EndNumero = EndNumero;
    }

    /**
     *
     * @return
     */
    public String getEndComplemento() {
        return EndComplemento;
    }

    /**
     *
     * @param EndComplemento
     */
    public void setEndComplemento(String EndComplemento) {
        this.EndComplemento = EndComplemento;
    }

    /**
     *
     * @return
     */
    public String getEndBairro() {
        return EndBairro;
    }

    /**
     *
     * @param EndBairro
     */
    public void setEndBairro(String EndBairro) {
        this.EndBairro = EndBairro;
    }

    /**
     *
     * @return
     */
    public String getEndCidade() {
        return EndCidade;
    }

    /**
     *
     * @param EndCidade
     */
    public void setEndCidade(String EndCidade) {
        this.EndCidade = EndCidade;
    }

    /**
     *
     * @return
     */
    public int getEndCEP() {
        return EndCEP;
    }

    /**
     *
     * @param EndCEP
     */
    public void setEndCEP(int EndCEP) {
        this.EndCEP = EndCEP;
    }

    /**
     *
     * @return
     */
    public Date getDataNascimento() {
        return DataNascimento;
    }

    /**
     *
     * @param DataNascimento
     */
    public void setDataNascimento(Date DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    /**
     *
     * @return
     */
    public int getTelefoneResidencia() {
        return TelefoneResidencia;
    }

    /**
     *
     * @param TelefoneResidencia
     */
    public void setTelefoneResidencia(int TelefoneResidencia) {
        this.TelefoneResidencia = TelefoneResidencia;
    }

    /**
     *
     * @return
     */
    public int getTelefoneCelular() {
        return TelefoneCelular;
    }

    /**
     *
     * @param TelefoneCelular
     */
    public void setTelefoneCelular(int TelefoneCelular) {
        this.TelefoneCelular = TelefoneCelular;
    }

    /**
     *
     * @return
     */
    public String getIdentidade() {
        return Identidade;
    }

    /**
     *
     * @param Identidade
     */
    public void setIdentidade(String Identidade) {
        this.Identidade = Identidade;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return Email;
    }

    /**
     *
     * @param Email
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     *
     * @return
     */
    public String getSenha() {
        return Senha;
    }

    /**
     *
     * @param Senha
     */
    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
    //</editor-fold>
      
    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     *
     * @param id
     * @throws SQLException
     */
    public void preencher(int id) throws SQLException{
        Conector con = new Conector();
        Connection c = con.getConexao();
        if(c!=null){
            DaoHospede dh = new DaoHospede(c);
            Hospede h = dh.pesquisaID(id);
            System.out.println(h.getEmail());
            //nome.setValue(h.getEmail());
            idHospede=h.getIdHospede();
            nome=h.getNome();
            CPF=h.getCPF();
            EndRua=h.getEndRua();
            EndNumero=h.getEndNumero();
            EndComplemento=h.getEndComplemento();
            EndBairro=h.getEndBairro();
            EndCidade=h.getEndCidade();
            EndCEP=h.getEndCEP();
            DataNascimento=h.getDataNascimento();
            TelefoneResidencia=h.getTelefoneResidencia();
            TelefoneCelular=h.getTelefoneCelular();
            Identidade=h.getIdentidade();
            Email=h.getEmail();
            Senha=h.getSenha();
        }
    }
    
    /**
     *
     * @return
     * @throws SQLException
     */
    public String editar() throws SQLException{
        Conector con = new Conector();
        Connection c = con.getConexao();
        if(c!=null){    
            Hospede h = new Hospede(idHospede, nome, CPF, EndRua, EndNumero, EndComplemento, EndBairro, EndCidade, EndCEP, DataNascimento, TelefoneResidencia, TelefoneCelular, Identidade, Email, Senha);
            DaoHospede dh = new DaoHospede(c);
            System.out.println(h.getIdHospede());
            dh.editar(h);
            return "index";
        } else {
            return "";
        }  
    }
    //</editor-fold>
    
}