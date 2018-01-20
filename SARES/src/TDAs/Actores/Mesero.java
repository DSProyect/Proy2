/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs.Actores;


import Constants.Constants;

import TDAs.Control.CtrlMesero;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author User
 */
public class Mesero extends Empleado implements Update{

    public Mesero(String identificacion, String nombres, String apellidos, int edad, double sueldo, String user) {
        super(identificacion, nombres, apellidos, edad, sueldo, user);
        this.tipoEmp = Constants.mesero;
        ctrl = new CtrlMesero(this);
    }
   
    
   
    
    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
