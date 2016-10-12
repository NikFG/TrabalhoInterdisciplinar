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

    //<editor-fold defaultstate="collapsed" desc="Construtores">

    /**
     *
     */
    public Hospede() {
    }

    /**
     *
     * @param Email
     * @param Senha
     */
    public Hospede(String Email, String Senha) {
        this.Email = Email;
        this.Senha = Senha;
    }
    
    /**
     *
     * @param idHospede
     * @param nome
     * @param CPF
     * @param EndRua
     * @param EndNumero
     * @param EndComplemento
     * @param EndBairro
     * @param EndCidade
     * @param EndCEP
     * @param DataNascimento
     * @param TelefoneResidencia
     * @param TelefoneCelular
     * @param Identidade
     * @param Email
     * @param Senha
     */
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

    /**
     *
     * @return idHospede
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
     * @return nome
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
     * @return CPF
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
     * @return EndRua
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
     * @return EndNumero
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
     * @return EndComplemento
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
     * @return EndBairro
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
     * @return EndCidade
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
     * @return EndCEP
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
     * @return DataNascimento
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
     * @return TelefoneResidencia
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
     * @return TelefoneCelular
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
     * @return Identidade
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
     * @return Email
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
     * @return Senha
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

    //<editor-fold defaultstate="collapsed" desc="ToString">
    @Override
    public String toString() {
        return "Hospede{" + "idHospede=" + idHospede + ", nome=" + nome + ", CPF=" + CPF + ", EndRua=" + EndRua + ", EndNumero=" + EndNumero + ", EndComplemento=" + EndComplemento + ", EndBairro=" + EndBairro + ", EndCidade=" + EndCidade + ", EndCEP=" + EndCEP + ", DataNascimento=" + DataNascimento + ", TelefoneResidencia=" + TelefoneResidencia + ", TelefoneCelular=" + TelefoneCelular + ", Identidade=" + Identidade + ", Email=" + Email + ", Senha=" + Senha + '}';
    }
    //</editor-fold>
    
}