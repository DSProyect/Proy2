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
public abstract class Orden {
    protected String idOrden;
    protected double total;
    protected boolean pagado;
    protected boolean cocinado;
    protected boolean entregado;
    protected String idCliente;
    protected String idMesero;
    protected String idCocinero;

    public Orden() {
    }

    public Orden(String idOrden, double total, boolean pagado, boolean cocinado, boolean entregado, String idCliente, String idMesero) {
        this.idOrden = idOrden;
        this.total = total;
        this.pagado = pagado;
        this.cocinado = cocinado;
        this.entregado = entregado;
        this.idCliente = idCliente;
        this.idMesero = idMesero; 
    }

    public Orden(String idOrden, double total, boolean pagado, boolean cocinado, boolean entregado, String idCliente, String idMesero, String idCocinero) {
        this.idOrden = idOrden;
        this.total = total;
        this.pagado = pagado;
        this.cocinado = cocinado;
        this.entregado = entregado;
        this.idCliente = idCliente;
        this.idMesero = idMesero;
        this.idCocinero = idCocinero;
    }
    
    

    public String getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(String idPedido) {
        this.idOrden = idPedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public boolean isCocinado() {
        return cocinado;
    }

    public void setCocinado(boolean cocinado) {
        this.cocinado = cocinado;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(String idMesero) {
        this.idMesero = idMesero;
    }

    public String getIdCocinero() {
        return idCocinero;
    }

    public void setIdCocinero(String idCocinero) {
        this.idCocinero = idCocinero;
    }
}
