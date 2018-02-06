/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs.DB;

import TDAs.Environment.Ambiente;
import TDAs.Environment.CrearAmbiente;
import TDAs.Environment.Mesa;
import TDAs.Ordenes.Orden;
import TDAs.Ordenes.OrdenItem;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        cadenaDeLlamada = "{CALL ObtenerEmpleadoPorUsuario(?)}";
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
    
    public boolean aceptarOrden(String idOrden, String idChef){
    cadenaDeLlamada = "{CALL AceptarOrden(?,?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, Integer.parseInt(idOrden));
            llamada.setInt(2, Integer.parseInt(idChef));
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean ordenTerminada(int idOrden){
        cadenaDeLlamada = "{CALL OrdenTerminada(?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, idOrden);
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public void faltaIngredientes(String idItem){
        cadenaDeLlamada = "{CALL FaltaIngrediente(?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, Integer.parseInt(idItem));
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public ResultSet obtenerMesa(String idMesa){
        cadenaDeLlamada = "{CALL obtenerMesa(?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, Integer.parseInt(idMesa));
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    public boolean ordenPagada(String idOrden){
        return true;
    }
    
    public ResultSet totalCuenta(String idCuenta){ //CREAR EN LA BASE DE DATOS
        cadenaDeLlamada = "{CALL total(?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, Integer.parseInt(idCuenta));
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println("error totalcuenta");
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    public boolean cambiarUsuario(String usuario, String nuevoUsuario){
        cadenaDeLlamada = "{CALL CambiarUsuario(?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, usuario);
            llamada.setString(2, nuevoUsuario);
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
        
    public ResultSet verificarUsuarioContraseña(String usuario, String contra){
        cadenaDeLlamada = "{CALL verificarUsuarioPorContrasena(?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, usuario);
            llamada.setString(2, contra);
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    public ResultSet buscarOrden(String idOrden){
        cadenaDeLlamada = "{CALL BuscarOrden(?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, Integer.parseInt(idOrden));
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    public boolean existeOrden(String idOrden){
        cadenaDeLlamada = "{CALL BuscarOrden(?)}";
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
    
    public ResultSet obtenerIdOrden(){
        cadenaDeLlamada = "{CALL obtenerCantOrden()}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultado;

    }
    
    public ResultSet obtenerOrdenesNuevas(){
        cadenaDeLlamada = "{CALL obtenerOrdenesNuevas()}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    public boolean tienePrioridadOrden(String idOrden){
        cadenaDeLlamada = "{CALL tienePrioridadOrden(?)}";
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
    
    public boolean existeCliente(String cedula){
        cadenaDeLlamada = "{CALL existeCliente(?)}";
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
    
    public ResultSet obtenerCliente(String cedula){
        cadenaDeLlamada = "{CALL obtenerCliente(?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, cedula);
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    public ResultSet obtenerCuenta(String idCuenta){
        cadenaDeLlamada = "{CALL verCuenta(?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, Integer.parseInt(idCuenta));
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println("error obtenercuenta");
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    public boolean existeCuenta(String idCuenta){
        cadenaDeLlamada = "{CALL verCuenta(?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, Integer.parseInt(idCuenta));
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()){
                return true;
            }
        }catch(SQLException ex){
            System.out.println("error obtenercuenta");
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    
    public boolean cuentaDisponible(String idCuenta){
        cadenaDeLlamada = "{CALL cuentaDisponible(?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, Integer.parseInt(idCuenta));
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public ResultSet obtenerAmbiente(String id){
        cadenaDeLlamada = "{CALL obtenerAmbiente(?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, Integer.parseInt(id));
            resultado = llamada.executeQuery();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }       
        return resultado;
    }
    
    public ResultSet ObtenerTipoPago(){
        cadenaDeLlamada = "{CALL obtenerTipopago()}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }       
        return resultado;
    }
    
    public ResultSet obtenerCategorias(){
        cadenaDeLlamada = "{CALL obtenerCategoria()}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }       
        return resultado;
    }
    
    public ResultSet obtenerItemXCategoria(String nombre){
        cadenaDeLlamada = "{CALL obtenerItemXCategorias(?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, nombre);
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }       
        return resultado;
    }
    
    public ResultSet obtenerIdItem(String nombre){
        cadenaDeLlamada = "{CALL obtenerIdItem(?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, nombre);
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }       
        return resultado;
    }
    
    public ResultSet obtenerCuentas(){
        cadenaDeLlamada = "{CALL obtenerCuentas()}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }       
        return resultado;
    }
    
    public ResultSet obtenerOrdenCuenta(String id){
        cadenaDeLlamada = "{CALL obtenerOrdenDeCuenta(?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, id);
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }       
        return resultado;
    }
    
    public ResultSet obtenerMesaDisponibles(){
        cadenaDeLlamada = "{CALL obtenerMesasVacias()}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }       
        return resultado;
    }
    
    public ResultSet obtenerMaxIdOrden(){
        cadenaDeLlamada = "{CALL obtenerMaxIdOrden()}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }       
        return resultado;
    }
}
