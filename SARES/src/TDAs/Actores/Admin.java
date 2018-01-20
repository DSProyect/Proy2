/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs.Actores;

import Constants.Constants;
import TDAs.Control.CtrlAdmin;

/**
 *
 * @author User
 */
public class Admin extends Empleado {
   public Admin(String identificacion, String nombres, String apellidos, int Edad, double sueldo, String usuario) {
        super(identificacion, nombres, apellidos, Edad, sueldo, usuario);
        this.tipoEmp = Constants.admin;
        ctrl = new CtrlAdmin(this);
    }
}
