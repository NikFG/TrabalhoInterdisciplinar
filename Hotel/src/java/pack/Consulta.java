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
    
    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private Date dentrada;
    private Date dsaida;
    private String tipo;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Construtor">
    /**
     *
     */
    public Consulta() {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    /**
     *
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @return
     */
    public Date getDentrada() {
        return dentrada;
    }

    /**
     *
     * @param dentrada
     */
    public void setDentrada(Date dentrada) {
        this.dentrada = dentrada;
    }

    /**
     *
     * @return
     */
    public Date getDsaida() {
        return dsaida;
    }

    /**
     *
     * @param dsaida
     */
    public void setDsaida(Date dsaida) {
        this.dsaida = dsaida;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     *
     * @return
     */
    public boolean isEmpty(){
        return(dentrada==null||dsaida==null||tipo.equals(""));
    }
    
    /**
     *
     * @return
     */
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
    //</editor-fold>
    
}
