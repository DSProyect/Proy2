/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs.DB;

import TDAs.Environment.Mesa;
import TDAs.Ordenes.Orden;
import TDAs.Ordenes.OrdenItem;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carmina
 */
public class IngresosDB {
    private static IngresosDB instancia = new IngresosDB();
    private String cadenaDeLlamada;
    private CallableStatement llamada;
    private ResultSet resultado;

    public IngresosDB() {
    }
    
    public boolean addMesa(Mesa mesa){ //Correcto
        cadenaDeLlamada = "{CALL AgregarMesa(?,?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, Integer.toString(mesa.getAsientos()));
            llamada.setInt(2, Integer.parseInt(mesa.getAmbiente().getId()));
            resultado = llamada.executeQuery();
                return true;
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public static IngresosDB getInstancia() {
        return instancia;
    }
    
    public boolean addItemOrden(OrdenItem ordenItem){ //Correcto
        cadenaDeLlamada = "{CALL AgregarItemAOrden(?,?,?,?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, Integer.parseInt(ordenItem.getIdItem()));
            llamada.setInt(2, Integer.parseInt(ordenItem.getIdOrden()));
            llamada.setInt(3, ordenItem.getCantidadArticulos());
            llamada.setString(4, ordenItem.getObservaciones());
            resultado = llamada.executeQuery();
            
                return true;
           
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean aggOrden(String idMesero, String idCuenta){ //Correcto
        cadenaDeLlamada = "{CALL NuevaOrden(?,?)}";
        resultado = null;
        //Corregir el metodo en la base de datos debe ser OrdenCuenta
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, idMesero);
            llamada.setInt(2, Integer.parseInt(idCuenta));
            resultado = llamada.executeQuery();
            return true;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean aggUsuario(String usuario, String contra){
        cadenaDeLlamada = "{CALL AgregarUsuario(?,?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, usuario);
            llamada.setString(2, contra);
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public boolean aggCliente(String cedula, String nombre, String apellido, String direccion){
        cadenaDeLlamada = "{CALL aggCliente(?,?,?,?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, cedula);
            llamada.setString(2, nombre);
            llamada.setString(3, apellido);
            llamada.setString(4, direccion);
            resultado = llamada.executeQuery();
                return true;
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean aggCuenta(String idCuenta, String cedula, int Descuento, double total, String tipo){
        cadenaDeLlamada = "{CALL aggCuenta2(?,?,?,?,?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, Integer.parseInt(idCuenta));
            llamada.setString(2, cedula);
            llamada.setInt(3, Descuento);
            llamada.setDouble(4, total);
            llamada.setString(5, tipo);
            resultado = llamada.executeQuery();
            
                return true;
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean aggCuentasVacias(boolean prioridad, String idMesa){
        cadenaDeLlamada = "{CALL aggCuenta(?,?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setBoolean(1, prioridad);
            llamada.setInt(2, Integer.parseInt(idMesa));
            resultado = llamada.executeQuery();
            return true;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
}
