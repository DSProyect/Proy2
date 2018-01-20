/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs.Control;

import GUIs.GuiDeliverBoy;
import TDAs.Actores.DeliverBoy;
import java.awt.event.ActionEvent;

/**
 *
 * @author User
 */
public class CtrlDeliverBoy implements Ctrl{
    private GuiDeliverBoy ventana;
    private DeliverBoy deliver;

    public CtrlDeliverBoy(DeliverBoy deliver) {
        this.deliver = deliver;
        this.deliver.setCtrl(this);
        ventana = new GuiDeliverBoy();
    }
    
    @Override
    public void view() {
        ventana.setVisible(true);    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
