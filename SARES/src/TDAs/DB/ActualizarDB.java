/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs.DB;

import TDAs.Environment.CrearAmbiente;
import TDAs.Ordenes.OrdenItem;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carmina
 */
public class ActualizarDB {
    private static ActualizarDB instancia = new ActualizarDB();
    private String cadenaDeLlamada;
    private CallableStatement llamada;
    private ResultSet resultado;

    public ActualizarDB() {
    }

    public static ActualizarDB getInstancia() {
        return instancia;
    }
    
    public boolean actualizarItemOrden(OrdenItem ordenItem){ //Correcto
        cadenaDeLlamada = "{CALL ActualizarDetalleOrden(?,?,?,?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, Integer.parseInt(ordenItem.getIdItem()));
            llamada.setInt(2, Integer.parseInt(ordenItem.getIdOrden()));
            llamada.setInt(3, ordenItem.getCantidadArticulos());
            llamada.setString(4, ordenItem.getObservaciones());
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean actualizarMesa(String idMesa, int asientos, boolean disponibilidad, String ambiente){
        cadenaDeLlamada = "{CALL ActualizarMesa(?,?,?,?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, Integer.parseInt(idMesa));
            llamada.setInt(2, asientos);
            llamada.setBoolean(3, disponibilidad);
            llamada.setInt(4, Integer.parseInt(new CrearAmbiente().crearAmbiente(ambiente).getId()));
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean actualizarAmbiente(String nombre, String nuevoNombre){
        cadenaDeLlamada = "{CALL ActualizarAmbiente(?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, nombre);
            llamada.setString(2, nuevoNombre);
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean actualizarCliente(String cedula, String nombre, String apellido, String direccion){
        cadenaDeLlamada = "{CALL actualizarCliente(?,?,?,?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, cedula);
            llamada.setString(2, nombre);
            llamada.setString(3, apellido);
            llamada.setString(4, direccion);
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    
    }
    
    
    
    
}
