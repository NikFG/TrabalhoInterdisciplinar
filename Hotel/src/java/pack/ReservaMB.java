/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import model.Reserva;
import model.ReservaDAO;

/**
 *
 * @author Home
 */

@ManagedBean
public class ReservaMB {

    private Reserva reserva;
    private ReservaDAO reservadao;

    public ReservaMB() {
        this.reserva = new Reserva();
    }

    /**
     *
     * @param reserva
     */
    public ReservaMB(Reserva reserva) {
        this.reserva = reserva;
    }

    public Reserva getHospede() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public String insertao() throws SQLException {
        ReservaDAO dao = new ReservaDAO();
        dao.insert(reserva);
        return "OutraPag.xtml";
    }

}