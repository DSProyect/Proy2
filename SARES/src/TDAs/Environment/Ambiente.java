/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs.Environment;

/**
 *
 * @author User
 */
public abstract class Ambiente {
    private String id;
    protected String nombre;
    protected String descripcion;
    private boolean eliminado;

    public Ambiente(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
    
    public void aggDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    
    
}
