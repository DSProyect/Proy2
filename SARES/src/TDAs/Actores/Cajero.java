/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs.Actores;

import Constants.Personal;
import TDAs.Control.CtrlCajero;

/**
 *
 * @author User
 */
public class Cajero extends Empleado {
    public Cajero(String identificacion, String nombres, String apellidos, int Edad, double sueldo, String usuario) {
        super(identificacion, nombres, apellidos, Edad, sueldo, usuario);
        this.type = Personal.cajero;
        control = new CtrlCajero(this);
    }
}
