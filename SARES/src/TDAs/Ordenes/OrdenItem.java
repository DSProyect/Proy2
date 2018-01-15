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
public class OrdenItem {
    private String idOrdenItem;
    private String idOrden;
    private String idItem;
    private int cantidadArticulos;
    private String observaciones;


    public OrdenItem(String idOrdenItem, String idOrden, String idItem, String observaciones) {
        this.idOrdenItem = idOrdenItem;
        this.idOrden = idOrden;
        this.idItem = idItem;
        this.observaciones = observaciones;
    }

    public String getIdOrdenItem() {
        return idOrdenItem;
    }

    public void setIdOrdenItem(String idOrdenItem) {
        this.idOrdenItem = idOrdenItem;
    }

    public String getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(String idOrden) {
        this.idOrden = idOrden;
    }

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public int getCantidadArticulos() {
        return cantidadArticulos;
    }

    public void setCantidadArticulos(int cantidadArticulos) {
        this.cantidadArticulos = cantidadArticulos;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
