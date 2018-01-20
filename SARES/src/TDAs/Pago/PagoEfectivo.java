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
public class PagoEfectivo implements Estrategia {

    @Override
    public void pay(double total) {
        System.out.println("Se pago en EFECTIVO");
    }
    
}
