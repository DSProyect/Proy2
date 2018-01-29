/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs.Ordenes;

import TDAs.Actores.Observador;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Carmina
 */
public class ColaPedidos extends Observador{
    private static ColaPedidos instancia = new ColaPedidos();
    private Queue<Integer> colaNormal;
    private Queue<Integer> colaPrioridad;
    private Queue<Integer> colaPorEntregar;
    
    private ColaPedidos(){
        colaNormal = new LinkedList<>();
        colaPrioridad = new LinkedList<>();
        colaPorEntregar = new LinkedList<>();
    }   

    public void addPedidoNormal(int idOrden){
        colaNormal.offer(idOrden);
        notificarObservadores();
    }
    
    public void addPedidoPrioridad(int idOrden){
        colaPrioridad.offer(idOrden);
        notificarObservadores();
    }
    
    public void addPedidoPorEntregar(int idOrden){
        colaPorEntregar.offer(idOrden);
        notificarObservadores();
    }
    
    public int atenderPedidoNormal(){
        return colaNormal.poll();
    }
    
    public int atenderPedidoPrioridad(){
        return colaPrioridad.poll();
    }
    
    public int entregarPedido(){
        return colaPorEntregar.poll();
    }
    
    public static ColaPedidos getInstancia(){
        return instancia;
    }
          
}
