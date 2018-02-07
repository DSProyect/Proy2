/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs.Actores;


import Constants.Constants;
import GUIs.GuiMesero;
import GUIs.RealizarPedido;

import TDAs.Control.CtrlMesero;
import TDAs.DB.Consult;
import TDAs.DB.IngresosDB;
import TDAs.Ordenes.ColaPedidos;
import TDAs.Ordenes.OrdenItem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author User
 */
public class Mesero extends Empleado implements Update{
    ColaPedidos cola= ColaPedidos.getInstancia();
    private OrdenItem OrdenItem;
    
    
    public Mesero(String identificacion, String nombres, String apellidos, int edad, double sueldo, String user) {
        super(identificacion, nombres, apellidos, edad, sueldo, user);
        this.tipoEmp = Constants.mesero;
        ctrl = new CtrlMesero(this);
    }

    public Mesero() {
    }

    public void ingresarDetalleOrden(OrdenItem OrdenItem) {
        this.OrdenItem = OrdenItem;
        IngresosDB.getInstancia().addItemOrden(OrdenItem);
    }
    
    public void ingresarPedidoACola(int idOrden,int tipoCola){
        //cola.add(idPedido);
        
        if(tipoCola==Constants.preferencial){
            cola.addPedidoPrioridad(idOrden);
        }
        else{
            cola.addPedidoNormal(idOrden);
        }
    }
   
    
    @Override
    public void update() {
        System.out.println("El pedido ha sido puesto en la cola para ser preparado");
    }
    
    
    
    
    
}
