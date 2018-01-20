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
 * @author User
 */
public class Consult {
    private static Consult instancia = new Consult();
    private String cadenaDeLlamada;
    private CallableStatement llamada;
    private ResultSet resultado;

    public Consult() {
    }
    
    public static Consult getInstancia(){
        return instancia;
    }
    
    public boolean usuarioExiste(String usuario){
        cadenaDeLlamada = "{CALL buscarUsuario(?)}";
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
    
    public boolean datosUsuarioCorrectos(String usuario, String contrasena){
        cadenaDeLlamada = "{CALL verificarUsuarioContrasena(?,?)}";
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, usuario);
            llamada.setString(2, contrasena);
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public ResultSet obtenerPersonalPorUsuario(String usuario){
        cadenaDeLlamada = "{CALL ObtenerPersonalPorUsuario(?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, usuario);
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    public boolean addMesa(Mesa mesa){
        cadenaDeLlamada = "{CALL AgregarMesa(?,?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, Integer.toString(mesa.getAsientos()));
            llamada.setString(2, mesa.getAmbiente().getId());
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean addItemOrden(OrdenItem ordenItem){
        cadenaDeLlamada = "{CALL AgregarItemAOrden(?,?,?,?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, ordenItem.getIdItem());
            llamada.setString(2, ordenItem.getIdOrden());
            llamada.setString(3, Integer.toString(ordenItem.getCantidadArticulos()));
            llamada.setString(4, ordenItem.getObservaciones());
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean actualizarItemOrden(OrdenItem ordenItem){
        cadenaDeLlamada = "{CALL ActualizarDetalleOrden(?,?,?,?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, ordenItem.getIdItem());
            llamada.setString(2, ordenItem.getIdOrden());
            llamada.setString(3, Integer.toString(ordenItem.getCantidadArticulos()));
            llamada.setString(4, ordenItem.getObservaciones());
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean eliminarOrden(String idOrden){
        cadenaDeLlamada = "{CALL EliminarOrden(?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, idOrden);
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean aggOrden(Orden orden){
        cadenaDeLlamada = "{CALL NuevaOrden(?,?,?,?)}";
        resultado = null;
        //Corregir el metodo en la base de datos debe ser OrdenCuenta
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, orden.getIdCliente());
            llamada.setString(2, orden.getIdMesero());
            llamada.setString(3, orden.getIdCuenta());
            llamada.setString(4, orden.getIdOrden());
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean eliminarMesa(String idMesa){
        cadenaDeLlamada = "{CALL EliminarMesa(?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, idMesa);
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean aceptarOrden(String idOrden, String idChef){
    cadenaDeLlamada = "{CALL AceptarOrden(?,?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, idOrden);
            llamada.setString(2, idChef);
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean ordenTerminada(String idOrden){
        cadenaDeLlamada = "{CALL OrdenTerminada(?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, idOrden);
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean ordenPagada(String idOrden){
        return true;
    }
    
    public int obtenerTotalCuenta(String idCuenta){
        return 0;
    }
}
