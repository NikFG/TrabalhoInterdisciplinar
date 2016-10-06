/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.text.DateFormat;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Leonardo
 */
@ManagedBean
public class BackingBean {
    
    private String entrada;
    private String saida;
    private String tipo;

    public BackingBean() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }
    
}
