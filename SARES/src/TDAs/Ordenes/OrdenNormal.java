/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs.Ordenes;

/**
 *
 * @author User
 */
public class OrdenNormal extends Orden {

    /*public OrdenNormal(String idMesa, String idOrden, double total, boolean pagado, boolean cocinado, boolean entregado, String idCliente, String idMesero) {
        super(idOrden, total, pagado, cocinado, entregado, idCliente, idMesero);
        this.idMesa = idMesa;
    }*/

    public OrdenNormal(String idMesero, String idCuenta) {
        super(idMesero, idCuenta);
    }

    public OrdenNormal(String idOrden, double total, boolean pagado, boolean cocinado, boolean entregado, int tiempoPreparacion, String idMesero, String idCocinero, String idCuenta) {
        super(idOrden, total, pagado, cocinado, entregado, tiempoPreparacion, idMesero, idCocinero, idCuenta);
    }
    
    
}
