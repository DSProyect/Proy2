/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs.Control;

import java.awt.event.ActionEvent;
import GUIs.GuiMesero;
import TDAs.Actores.Mesero;
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
    
    

    @Override
    public void view() {
        ventana.setVisible(true); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
