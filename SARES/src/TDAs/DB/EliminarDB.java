/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs.DB;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carmina
 */
public class EliminarDB {
    private static EliminarDB instancia = new EliminarDB();
    private String cadenaDeLlamada;
    private CallableStatement llamada;
    private ResultSet resultado;

    public EliminarDB() {
    }

    public static EliminarDB getInstancia() {
        return instancia;
    }
    
    public boolean eliminarUsuario(String usuario){
        cadenaDeLlamada = "{CALL EliminarUsuario(?)}";
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, usuario);
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean eliminarOrden(String idOrden){ //Correcto
        cadenaDeLlamada = "{CALL EliminarOrden(?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, Integer.parseInt(idOrden));
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean eliminarMesa(String idMesa){
        cadenaDeLlamada = "{CALL EliminarMesa(?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, Integer.parseInt(idMesa));
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean elminarItemOrden(String idOrden, String idItem){
        cadenaDeLlamada = "{CALL EliminarOrden(?,?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, Integer.parseInt(idOrden));
            llamada.setInt(2, Integer.parseInt(idItem));
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean eliminarAmbiente(String idAmbiente){
        cadenaDeLlamada = "{CALL EliminarAmbiente(?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, Integer.parseInt(idAmbiente));
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean eliminarCliente(String cedula){
        cadenaDeLlamada = "{CALL eliminarCliente(?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, cedula);
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
