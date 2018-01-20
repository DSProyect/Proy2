/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs.Actores;

import TDAs.Control.Ctrl;

/**
 *
 * @author User
 */
public abstract class Empleado {
    protected String identificacion;
    protected String nombres;
    protected String apellidos;
    protected int Edad;
    protected double sueldo;
    protected String usuario;
    protected int tipoEmp;
    protected Ctrl ctrl;
    

    public Empleado(String identificacion, String nombres, String apellidos, int Edad, double sueldo, String usuario) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.Edad = Edad;
        this.sueldo = sueldo;
        this.usuario = usuario;
    }
    
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Ctrl getCtrl() {
        return ctrl;
    }

    public void setCtrl(Ctrl ctrl) {
        this.ctrl = ctrl;
    }
}
