/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.*;

/**
 *
 * @author Leonardo
 */

@ManagedBean
public class Comunicacao {
    
    private String nome;
    private HtmlOutputText opt;
    private HtmlForm form;
    
    public String login(String Email, String Senha, String opc) throws SQLException, IOException{
        Conector con = new Conector();
        Connection c = con.getConexao();
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(c!=null){
            DaoHospede dh = new DaoHospede(c);
            Hospede h = dh.pesquisaES(Email, Senha);
            if(h!=null){
                nome=h.getNome();
                return opc;
            } else {
                opt.setValue("Login inválido! Tente novamente.");
                form.setStyle("display:block; ");
                return "";
            }
        } else {
            return "login";
        }        
    }
    
    public String cadastrar(Hospede h) throws SQLException{
        Conector con = new Conector();
        Connection c = con.getConexao();
        if(c!=null){
            DaoHospede dh = new DaoHospede(c);
            boolean v = dh.pesquisaEm(h.getEmail());
            if(v==false){
                if(h.getNome()!=null &&
                h.getCPF()!=null &&
                h.getEndRua()!=null &&
                h.getEndNumero()!=0 &&
                h.getEndBairro()!=null &&
                h.getEndCidade()!=null &&
                h.getEndCEP()!=0 &&
                h.getTelefoneCelular()!=0 &&
                h.getIdentidade()!=null &&
                h.getEmail()!=null &&
                h.getSenha()!=null){
                    int r = dh.inserir(h);
                    if(r==1){
                        return "login";
                    } else {
                        return "cadastro";
                    }
                }
            }
        }
        return "cadastro";
    }
    
    public String verificar(String email, String senha) throws SQLException, IOException{
        String r = login(email,senha,"index");
        return nome;
    }

    public Comunicacao(HtmlOutputText opt,HtmlForm form) {
        this.nome = null;
        this.opt= opt;
        this.form=form;
    }
    
    public Comunicacao() {        
    }

    public HtmlOutputText getOpt() {
        return opt;
    }

    public void setOpt(HtmlOutputText opt) {
        this.opt = opt;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public HtmlForm getForm() {
        return form;
    }

    public void setForm(HtmlForm form) {
        this.form = form;
    }
}
