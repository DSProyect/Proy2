/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs.Pago;

/**
 *
 * @author User
 */
public class PagoTarjeta implements Estrategia {
    private int numeroCuenta;

    public PagoTarjeta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    
    @Override
    public void pay(double total) {
        System.out.println("Pago exitoso");
    }
    
}
