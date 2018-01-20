/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs.Actores;

import Constants.Constants;
import TDAs.Control.CtrlDeliverBoy;

/**
 *
 * @author User
 */
public class DeliverBoy extends Empleado{

    public DeliverBoy(String identificacion, String nombres, String apellidos, int edad, double sueldo, String user) {
        super(identificacion, nombres, apellidos, edad, sueldo, user);
        this.tipoEmp = Constants.deliverBoy;
        ctrl = new CtrlDeliverBoy(this);
    }
    
}
