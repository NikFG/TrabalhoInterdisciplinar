/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;

/**
 *
 * @author Leonardo
 */
@ManagedBean
public class BackingBean {
    
    private HtmlInputText email;
    private HtmlInputText senha;
    private HtmlCommandButton botao;

    public BackingBean() {
    }

    public BackingBean(HtmlInputText email, HtmlInputText senha, HtmlCommandButton botao) {
        this.email = email;
        this.senha = senha;
        this.botao = botao;
    }

    public HtmlInputText getEmail() {
        return email;
    }

    public void setEmail(HtmlInputText email) {
        this.email = email;
    }

    public HtmlInputText getSenha() {
        return senha;
    }

    public void setSenha(HtmlInputText senha) {
        this.senha = senha;
    }

    public HtmlCommandButton getBotao() {
        return botao;
    }

    public void setBotao(HtmlCommandButton botao) {
        this.botao = botao;
    }
    
    public void testar(){
        if(this.email.isDisabled()) {
            email.setDisabled(false);
            botao.setStyle("");
        } else {
            email.setDisabled(true);
            botao.setStyle("color: white; background-color: red;");
        }
    }
    
}
