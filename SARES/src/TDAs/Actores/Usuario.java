/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs.Actores;


import Constants.Constants;
import TDAs.DB.Consult;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Usuario {
    private String usuario;
    private String contrasena;
    private Empleado empleado;

    public Usuario() {
    }

    public Usuario(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public void crearEmpleado(ResultSet rs){
        try{
            switch (rs.getInt(6)){
                case Constants.admin:
                    empleado = new Admin(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(7));
                    break;
                case Constants.cajero:
                    empleado = new Cajero(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(7));
                    break;
                case Constants.chef:
                    empleado = new Chef(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(7));
                    break;
                case Constants.mesero:
                    empleado = new Mesero(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(7));
                    break;
                case Constants.deliverBoy:
                    empleado = new DeliverBoy(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(7));
                    break;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void iniciarSesion(){
        if(Consult.getInstancia().usuarioExiste(usuario)){
            if(!Consult.getInstancia().datosUsuarioCorrectos(usuario, contrasena)){
                JOptionPane.showMessageDialog(null, "La contrasena no corresponde a ese usuario.", "Mensaje del sistema.", JOptionPane.ERROR_MESSAGE);
            }else{
                crearEmpleado(Consult.getInstancia().obtenerPersonalPorUsuario(usuario));
                empleado.getCtrl().view();
                JOptionPane.showMessageDialog(null, "Ingreso Exitoso", "Mensaje del sistema.", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "No existe ese usuario en la base de datos.", "Mensaje del sistema.", JOptionPane.ERROR_MESSAGE);
        }
    }
}
