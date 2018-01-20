/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs.Actores;

import Constants.Personal;
import TDAs.Control.CtrlMesero;

/**
 *
 * @author User
 */
public class Mesero extends Empleado{

    public Mesero(String identificacion, String nombres, String apellidos, int edad, double sueldo, String user) {
        super(identificacion, nombres, apellidos, edad, sueldo, user);
        this.type = Personal.mesero;
        control = new CtrlMesero(this);
    }
    
    
    
}
