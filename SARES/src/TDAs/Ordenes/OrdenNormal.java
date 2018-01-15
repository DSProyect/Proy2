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
    private String idMesa;

    public OrdenNormal() {
    }

    public OrdenNormal(String idMesa, String idOrden, double total, boolean pagado, boolean cocinado, boolean entregado, String idCliente, String idMesero) {
        super(idOrden, total, pagado, cocinado, entregado, idCliente, idMesero);
        this.idMesa = idMesa;
    }

    public OrdenNormal(String idMesa, String idOrden, double total, boolean pagado, boolean cocinado, boolean entregado, String idCliente, String idMesero, String idCocinero) {
        super(idOrden, total, pagado, cocinado, entregado, idCliente, idMesero, idCocinero);
        this.idMesa = idMesa;
    }

    public String getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(String idMesa) {
        this.idMesa = idMesa;
    }
}
