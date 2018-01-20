/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs.Actores;

import Constants.Personal;
import TDAs.Control.CtrlChef;

/**
 *
 * @author User
 */
public class Chef extends Empleado{

    public Chef(String identificacion, String nombres, String apellidos, int edad, double sueldo, String usuario) {
        super(identificacion, nombres, apellidos, edad, sueldo, usuario);
        this.type = Personal.chef;
        control = new CtrlChef(this);
    }
    
}
