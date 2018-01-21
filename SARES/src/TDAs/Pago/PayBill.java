/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs.Pago;

import TDAs.DB.Consult;
import java.util.Date;

/**
 *
 * @author User
 */
public class PayBill {
    protected Date fecha;
    protected double total;
    protected Estrategia estrategiaDePago;
    protected String idCliente, idCuenta; 
    protected int Descuento;

    public PayBill(Date fecha, Estrategia estrategiaDePago,int descuento, String idCuenta, String idcliente) {
        this.fecha = fecha;
        this.estrategiaDePago = estrategiaDePago;
        this.idCliente = idcliente;
        this.Descuento = descuento;
        this.idCuenta = idCuenta;
        if(descuento > 0)
            realizarDescuento();
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

   
    
    private void realizarDescuento(){
        this.total = this.total * Descuento / 100;
    }
    public int getDescuento() {
        return Descuento;
    }

    public void setDescuento(int Descuento) {
        this.Descuento = Descuento;
    }
    
    
    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double calcularTotal() {
        //OBTENER EL TOTAL DE LA BASE DE DATOS
        //Consult cons = new Consult();
        //return cons.obtenerTotalCuenta(idCuenta);
        return total;
    }

    public Estrategia getEstrategiaDePago() {
        return estrategiaDePago;
    }

    public void setEstrategiaDePago(Estrategia estrategiaDePago) {
        this.estrategiaDePago = estrategiaDePago;
    }
    
    public void pagar(){
        this.estrategiaDePago.pay(total);
    }
}
