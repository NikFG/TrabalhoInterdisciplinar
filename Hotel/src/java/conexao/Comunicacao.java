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
import model.*;

/**
 *
 * @author Leonardo
 */

@ManagedBean
public class Comunicacao {
    
    private String nome=null;
    private int id=0;
    private HtmlOutputText opt;
    private HtmlForm form;
    
    public String login(String Email, String Senha, String opc) throws SQLException, IOException{
        Conector con = new Conector();
        Connection c = con.getConexao();
        
        if(c!=null){
            DaoHospede dh = new DaoHospede(c);
            Hospede h = dh.pesquisaES(Email, Senha);
            if(h!=null){
                System.out.println(h.getEmail());
                nome=h.getNome();
                id=h.getIdHospede();
                return opc;
            } else {
                opt.setValue("Login inválido! Tente novamente.");
                form.setStyle("visibility:visible; ");
                return "";
            }
        } else {
            opt.setValue("Não há conexão ativa com a internet!");
            form.setStyle("visibility:visible; ");
            return "";
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
        //?faces-redirect=true
    }
    
    public void preencher() throws SQLException{
        Conector con = new Conector();
        Connection c = con.getConexao();
        if(c!=null){
            DaoHospede dh = new DaoHospede(c);
            Hospede h = dh.pesquisaID(id);
            
        }
    }
    
    public String verificar(String email, String senha) throws SQLException, IOException{
        String r = login(email,senha,"index");
        return nome;
    }
    
    public String isLogged(){
        if(nome==null || id==0){
            return "login";
        } else{
            return "confirmacao";
        }
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
