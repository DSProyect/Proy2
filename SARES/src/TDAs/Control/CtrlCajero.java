/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs.Control;

import GUIs.GuiCajero;
import TDAs.Actores.Cajero;
import java.awt.event.ActionEvent;

/**
 *
 * @author User
 */
public class CtrlCajero implements Ctrl {
    private GuiCajero ventana;
    private Cajero cajero;
    
    public CtrlCajero(Cajero cajero){
        ventana = new GuiCajero();
        this.cajero = cajero;
        this.cajero.setCtrl(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void view() {
        ventana.setVisible(true);
    }
    

   
    
}
