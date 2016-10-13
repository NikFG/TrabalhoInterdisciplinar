/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Home
 */

public class Reserva {

    public Reserva(String responsavel, int FimPeriodo, int InicioPeriodo) {
        this.responsavel = responsavel;
        this.FimPeriodo = FimPeriodo;
        this.InicioPeriodo = InicioPeriodo;
    }
    private int data = 0;
    private String responsavel;
    private int FimPeriodo;
    private int InicioPeriodo;

    public Reserva() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getData() {
        return data;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public int getFimPeriodo() {
        return FimPeriodo;
    }

    public int getInicioPeriodo() {
        return InicioPeriodo;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public void setFimPeriodo(int FimPeriodo) {
        this.FimPeriodo = FimPeriodo;
    }

    public void setInicioPeriodo(int InicioPeriodo) {
        this.InicioPeriodo = InicioPeriodo;
    }

}
