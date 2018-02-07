/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs.Control;

import java.awt.event.ActionEvent;
import GUIs.GuiMesero;
import GUIs.RealizarPedido;
import TDAs.Actores.Mesero;
import TDAs.DB.Consult;
import TDAs.DB.IngresosDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author User
 */
public class CtrlMesero implements Ctrl {
    private GuiMesero ventana;
    private Mesero mesero;

    public CtrlMesero(Mesero mesero) {
        this.mesero = mesero;
        this.mesero.setCtrl(this);
        ventana = new GuiMesero(mesero.getIdentificacion());
    }

    public CtrlMesero() {
    }
    
    
    public int calcularTiempoPedido(int idOrden){
        ResultSet rs = Consult.getInstancia().obtenerTiempoPreparacion(idOrden);
        try {
            return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(CtrlMesero.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public static void ingresarOrdenNueva(String idMesero, String idCuenta){
        IngresosDB.getInstancia().aggOrden(idMesero,idCuenta);
        String i = "";
        try {
            ResultSet rs = Consult.getInstancia().obtenerMaxIdOrden();
            if(rs.next())
                i = Integer.toString(rs.getInt(1));
        } catch (SQLException ex) {
            Logger.getLogger(GuiMesero.class.getName()).log(Level.SEVERE, null, ex);
        }
        new RealizarPedido(i).setVisible(true);
    }
    
    public static void ingresarCuentaNueva(boolean prioridad, String idMesa){
        IngresosDB.getInstancia().aggCuentasVacias(prioridad, idMesa);
    }
    @Override
    public void view() {
        ventana.setVisible(true); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
