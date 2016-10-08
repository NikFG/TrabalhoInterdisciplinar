/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Leonardo
 */
@ManagedBean
public class Consulta {
    
    private Date dentrada;
    private Date dsaida;
    private String tipo;

    public Consulta() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDentrada() {
        return dentrada;
    }

    public void setDentrada(Date dentrada) {
        this.dentrada = dentrada;
    }

    public Date getDsaida() {
        return dsaida;
    }

    public void setDsaida(Date dsaida) {
        this.dsaida = dsaida;
    }
    
    public String getNomeParam(FacesContext fc){
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        return params.get("nome");
    }
    
    public boolean isEmpty(){
        return(dentrada==null||dsaida==null||tipo.equals(""));
    }
    
    public String verificar(){
        
        if(dentrada!=null&&dsaida!=null){
            java.util.Date dj = dentrada;
            Calendar c = Calendar.getInstance();
            c.setTime(dj);
            c.add(Calendar.DATE, 1);
            dentrada = c.getTime();
            dj = dsaida;
            c = Calendar.getInstance();
            c.setTime(dj);
            c.add(Calendar.DATE, 1);
            dsaida = c.getTime();
            if(dentrada.getYear()>0){
                dj = dentrada;
                c = Calendar.getInstance();
                c.setTime(dj);
                c.add(Calendar.YEAR, -2000);
                dentrada = c.getTime();
            }
            if(dsaida.getYear()>0){
                dj = dsaida;
                c = Calendar.getInstance();
                c.setTime(dj);
                c.add(Calendar.YEAR, -2000);
                dsaida = c.getTime();
            }
            if(!tipo.equals("")){
                return "lista";
            } else {
                return "";
            }
        } else {
            return "";
        }
    }    
}
