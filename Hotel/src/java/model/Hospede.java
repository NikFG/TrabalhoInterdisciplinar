/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Leonardo
 */

@ManagedBean
public class Hospede {
    
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

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Hospede() {
    }

    public Hospede(String Email, String Senha) {
        this.Email = Email;
        this.Senha = Senha;
    }
    
    public Hospede(int idHospede, String nome, String CPF, String EndRua, int EndNumero, String EndComplemento, String EndBairro, String EndCidade, int EndCEP, Date DataNascimento, int TelefoneResidencia, int TelefoneCelular, String Identidade, String Email, String Senha) {
        this.idHospede = idHospede;
        this.nome = nome;
        this.CPF = CPF;
        this.EndRua = EndRua;
        this.EndNumero = EndNumero;
        this.EndComplemento = EndComplemento;
        this.EndBairro = EndBairro;
        this.EndCidade = EndCidade;
        this.EndCEP = EndCEP;
        this.DataNascimento = DataNascimento;
        this.TelefoneResidencia = TelefoneResidencia;
        this.TelefoneCelular = TelefoneCelular;
        this.Identidade = Identidade;
        this.Email = Email;
        this.Senha = Senha;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">

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

    @Override
    public String toString() {
        return "Hospede{" + "idHospede=" + idHospede + ", nome=" + nome + ", CPF=" + CPF + ", EndRua=" + EndRua + ", EndNumero=" + EndNumero + ", EndComplemento=" + EndComplemento + ", EndBairro=" + EndBairro + ", EndCidade=" + EndCidade + ", EndCEP=" + EndCEP + ", DataNascimento=" + DataNascimento + ", TelefoneResidencia=" + TelefoneResidencia + ", TelefoneCelular=" + TelefoneCelular + ", Identidade=" + Identidade + ", Email=" + Email + ", Senha=" + Senha + '}';
    }
    
}