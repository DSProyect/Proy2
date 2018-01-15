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
    protected String identificacion,nombres,apellidos,user;
    protected int edad,type;
    protected double sueldo;
    protected Ctrl control;
    
    public Empleado() {
    } 

    public Empleado(String identificacion, String nombres, String apellidos, int edad, double sueldo, String user) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.sueldo = sueldo;
        this.user = user;
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
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Ctrl getControl() {
        return control;
    }

    public void setControl(Ctrl control) {
        this.control = control;
    }
}
