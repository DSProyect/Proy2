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
    
    public boolean addMesa(Mesa mesa){ //Correcto
        cadenaDeLlamada = "{CALL AgregarMesa(?,?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, Integer.toString(mesa.getAsientos()));
            llamada.setInt(2, Integer.parseInt(mesa.getAmbiente().getId()));
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
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
            if(resultado.isBeforeFirst()){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
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
    
    public boolean aggOrden(Orden orden){ //Correcto
        cadenaDeLlamada = "{CALL NuevaOrden(?,?,?)}";
        resultado = null;
        //Corregir el metodo en la base de datos debe ser OrdenCuenta
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, orden.getIdMesero());
            llamada.setInt(2, Integer.parseInt(orden.getIdCuenta()));
            llamada.setInt(3, Integer.parseInt(orden.getIdOrden()));
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
    
    //public verMesas();
    //public verAmbientes();
    
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
    
    public int obtenerTotalCuenta(String idCuenta){ //CREAR EN LA BASE DE DATOS
        return 0;
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
    
    public boolean obtenerCuenta(String idCuenta){
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
    
    public boolean aggClienteCuenta(String idCuenta, String cedula, int Descuento){
        cadenaDeLlamada = "{CALL aggClienteCuenta(?,?,?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, Integer.parseInt(idCuenta));
            llamada.setString(2, cedula);
            llamada.setInt(3, Descuento);
            resultado = llamada.executeQuery();
            return true;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }       
    }
    
    public ResultSet obtenerAmbiente(String id){
        cadenaDeLlamada = "{CALL obtenerAmbiente(?)}";
        resultado = null;
        try{
            llamada = Coneccion.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, Integer.parseInt(id));
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }       
        return resultado;
    }
}
