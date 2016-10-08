    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import conexao.Conector;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGroup;
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
    private HtmlOutputText opt2;
    private HtmlForm form;
    private HtmlPanelGroup pan;
    
    public String login(String Email, String Senha, String opc) throws SQLException, IOException{
        Conector con = new Conector();
        Connection c = con.getConexao();
        
        if(Email==null||Senha==null||opc==null){
            return "";
        } else {
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
                    if(!opc.equals("confirmacao")){
                        form.setStyle("visibility:visible; ");
                    } else {
                        pan.setStyle("visibility:visible; ");
                    }
                    return "";
                }
            } else {
                opt.setValue("Não há conexão ativa com a internet!");
                form.setStyle("visibility:visible; ");
                return "";
            }
        }
    }
    
    public String cadastrar(Hospede h) throws SQLException{
        Conector con = new Conector();
        Connection c = con.getConexao();
        if(c!=null){
            DaoHospede dh = new DaoHospede(c);
            boolean v = dh.pesquisaEm(h.getEmail());
            if(v==false){
                EmailValidator emailValidator = new EmailValidator();
                boolean valid = emailValidator.validate(h.getEmail());
                if(valid){
                    if(!h.getNome().equals("") && 
                    !h.getCPF().equals("") &&
                    !h.getEndRua().equals("") &&
                    h.getEndNumero()!=0 &&
                    !h.getEndComplemento().equals("") &&
                    !h.getEndBairro().equals("") &&
                    !h.getEndCidade().equals("") &&
                    h.getEndCEP()!=0 &&
                    h.getDataNascimento()!=null &&
                    h.getTelefoneResidencia()!=0 &&
                    h.getTelefoneCelular()!=0 &&
                    !h.getIdentidade().equals("") &&
                    !h.getEmail().equals("") &&
                    !h.getSenha().equals("")){
                        int r = dh.inserir(h);
                        if(r==1){
                            return "confirmacao";
                        } else {
                            System.out.println("oi");
                            opt2.setValue("Data incorreta!");
                            pan.setStyle("display: block");
                            return "";
                        }
                    } else {
                        opt.setValue("Preencha todos os campos corretamente!");
                        form.setStyle("visibility: visible");
                    }
                } else {
                        opt.setValue("Email incorreto!");
                        form.setStyle("visibility: visible");
                }
            } else {
                opt.setValue("Email já cadastrado!");
                form.setStyle("visibility: visible");
            }
        }
        return "";
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

    public Comunicacao(HtmlOutputText opt,HtmlOutputText opt2,HtmlForm form,HtmlPanelGroup pan) {
        this.nome = null;
        this.opt= opt;
        this.opt2= opt2;
        this.form=form;
        this.pan=pan;
    }
    
    public Comunicacao() {        
    }

    public HtmlOutputText getOpt() {
        return opt;
    }

    public void setOpt(HtmlOutputText opt) {
        this.opt = opt;
    }

    public HtmlOutputText getOpt2() {
        return opt2;
    }

    public void setOpt2(HtmlOutputText opt2) {
        this.opt2 = opt2;
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

    public HtmlPanelGroup getPan() {
        return pan;
    }

    public void setPan(HtmlPanelGroup pan) {
        this.pan = pan;
    }
}
