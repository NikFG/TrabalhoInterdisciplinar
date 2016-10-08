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
    //<editor-fold defaultstate="collapsed" desc="Construtores, Getters e Setters">
    public Edita() {
    }

    public int getIdHospede() {
        return idHospede;
    }

    public void setIdHospede(int idHospede) {
        this.idHospede = idHospede;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEndRua() {
        return EndRua;
    }

    public void setEndRua(String EndRua) {
        this.EndRua = EndRua;
    }

    public int getEndNumero() {
        return EndNumero;
    }

    public void setEndNumero(int EndNumero) {
        this.EndNumero = EndNumero;
    }

    public String getEndComplemento() {
        return EndComplemento;
    }

    public void setEndComplemento(String EndComplemento) {
        this.EndComplemento = EndComplemento;
    }

    public String getEndBairro() {
        return EndBairro;
    }

    public void setEndBairro(String EndBairro) {
        this.EndBairro = EndBairro;
    }

    public String getEndCidade() {
        return EndCidade;
    }

    public void setEndCidade(String EndCidade) {
        this.EndCidade = EndCidade;
    }

    public int getEndCEP() {
        return EndCEP;
    }

    public void setEndCEP(int EndCEP) {
        this.EndCEP = EndCEP;
    }

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(Date DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public int getTelefoneResidencia() {
        return TelefoneResidencia;
    }

    public void setTelefoneResidencia(int TelefoneResidencia) {
        this.TelefoneResidencia = TelefoneResidencia;
    }

    public int getTelefoneCelular() {
        return TelefoneCelular;
    }

    public void setTelefoneCelular(int TelefoneCelular) {
        this.TelefoneCelular = TelefoneCelular;
    }

    public String getIdentidade() {
        return Identidade;
    }

    public void setIdentidade(String Identidade) {
        this.Identidade = Identidade;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
    //</editor-fold>
        
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
    
}