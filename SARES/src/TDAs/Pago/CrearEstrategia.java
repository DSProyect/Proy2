/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs.Pago;

/**
 *
 * @author Carmina
 */
public class CrearEstrategia {
    public Estrategia Crear(String es){
        switch (es.toUpperCase()) {
            case "Dinero Electronico":
                return new PagoDE();
            case "Tarjeta de Credito":
                return new PagoTarjeta();
            default:
                return new PagoEfectivo();
        }
    }
}
