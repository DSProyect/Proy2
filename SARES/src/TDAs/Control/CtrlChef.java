/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs.Control;

import GUIs.GuiChef;
import TDAs.Actores.Chef;
import java.awt.event.ActionEvent;

/**
 *
 * @author User
 */
public class CtrlChef implements Ctrl{
    private GuiChef ventana;
    private Chef chef;

    public CtrlChef(Chef chef) {
        this.chef = chef;
        this.chef.setControl(this);
        ventana = new GuiChef();
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
