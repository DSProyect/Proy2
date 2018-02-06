/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs.Ordenes;

import TDAs.DB.Consult;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    protected int tiempoPreparacion;
    protected String idMesero;
    protected String idCocinero;
    protected String idCuenta;
    protected boolean prioridad = false;
    
    public Orden(String idMesero, String idCuenta) {
        this.idMesero = idMesero;
        this.idCuenta = idCuenta;
        this.pagado = false;
        this.cocinado = false;
        this.entregado = false;
    }
    //verificar este constructor
    
    
    public String getIdCuenta() {
        return idCuenta;
    }

    public Orden(String idOrden, double total, boolean pagado, boolean cocinado, boolean entregado, int tiempoPreparacion, String idMesero, String idCocinero, String idCuenta) {
        this.idOrden = idOrden;
        this.total = total;
        this.pagado = pagado;
        this.cocinado = cocinado;
        this.entregado = entregado;
        this.tiempoPreparacion = tiempoPreparacion;
        this.idMesero = idMesero;
        this.idCocinero = idCocinero;
        this.idCuenta = idCuenta;
    }
    
    public void tienePrioridad(){
        if(Consult.getInstancia().tienePrioridadOrden(idOrden)){
            this.prioridad = true;
        }
    }

    public boolean isPrioridad() {
        return prioridad;
    }
    
    
    
    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }
    

    public String getIdOrden() {
        return idOrden;
    }

    public double getTotal() {
        return total;
    }

    public void calcularTotal() {
        //obtenerTotalOrden(idOrden); bases de datos
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

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    /*private void aggId() {
        if(Integer.parseInt(this.idOrden) == 0 ){
            try {
                ResultSet rs = Consult.getInstancia().obtenerIdOrden();
                idOrden = Integer.toString(rs.getInt(1)+1);
            } catch (SQLException ex) {
                Logger.getLogger(Orden.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }*/
    
}
