
package TDAs.Actores;

import Constants.Constants;
import TDAs.Control.CtrlChef;
import TDAs.DB.Consult;
import TDAs.Ordenes.ColaPedidos;
import TDAs.Ordenes.Orden;
import java.util.Queue;

public class Chef extends Empleado implements Update{
    ColaPedidos cola = ColaPedidos.getInstancia();
    
    public Chef(String identificacion, String nombres, String apellidos, int edad, double sueldo, String usuario) {
        super(identificacion, nombres, apellidos, edad, sueldo, usuario);
        this.tipoEmp = Constants.chef;
        ctrl = new CtrlChef(this);
    }
    
    public Chef(){}
    
    public void cocinarOrden(int idOrden){
        System.out.println("Cocinando Orden N°: " + idOrden);
    }
    
    public void ordenTerminada(int idOrden){
        System.out.println("Orden terminada N°: " + idOrden);
        Consult.getInstancia().ordenTerminada(idOrden);
    }
    
    

    @Override
    public void update() {
        System.out.println("La ORDEN esta preparada para ser Entregada");
    }
    
}
