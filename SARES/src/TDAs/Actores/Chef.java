/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs.Actores;

import Constants.Constants;
import TDAs.Control.CtrlChef;
import TDAs.DB.Consult;
import TDAs.Ordenes.ColaPedidos;
import TDAs.Ordenes.Orden;
import java.util.Queue;


/**
 *
 * @author User
 */
public class Chef extends Empleado implements Update{
    Queue<Orden> ordenes = new ColaPedidos().colaOrden(Consult.getInstancia().obtenerOrdenesNuevas());
    
    
    public Chef(String identificacion, String nombres, String apellidos, int edad, double sueldo, String usuario) {
        super(identificacion, nombres, apellidos, edad, sueldo, usuario);
        this.tipoEmp = Constants.chef;
        ctrl = new CtrlChef(this);
    }
    

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
