/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs.Control;

import GUIs.GuiAdmin;
import TDAs.Actores.Admin;
import java.awt.event.ActionEvent;

/**
 *
 * @author User
 */
public class CtrlAdmin implements Ctrl {
    private GuiAdmin frame;
    private Admin administrador;
    
    public CtrlAdmin(Admin administrador){
        frame = new GuiAdmin();
        this.administrador = administrador;
        this.administrador.setCtrl(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void view() {
        frame.setVisible(true);
    }
}
