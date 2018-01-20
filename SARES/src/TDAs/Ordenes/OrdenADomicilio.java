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
public class OrdenADomicilio extends Orden {
    private String direccionEntrega;

    public OrdenADomicilio(String direccionEntrega, String idOrden, double total, boolean pagado, boolean cocinado, boolean entregado, String idCliente, String idMesero, String idCuenta) {
        super(idOrden, total, pagado, cocinado, entregado, idCliente, idMesero, idCuenta);
        this.direccionEntrega = direccionEntrega;
    }

    /*public OrdenADomicilio(String direccionEntrega, String idOrden, double total, boolean pagado, boolean cocinado, boolean entregado, String idCliente, String idMesero, String idCocinero) {
        super(idOrden, total, pagado, cocinado, entregado, idCliente, idMesero, idCocinero);
        this.direccionEntrega = direccionEntrega;
    }*/

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }
}
