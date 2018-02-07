/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import TDAs.Control.CtrlMesero;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Carmina
 */
public class TestPedido {
    
    public TestPedido() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @TestPedido. For example:
    //
    @Test
    public void calcularTiempoPedidoMasDe1Plato() {
        int tiempoEsperado = new CtrlMesero().calcularTiempoPedido(1);
        int tiempoEstimado = 13;
        assertEquals(tiempoEsperado, tiempoEstimado, "error por que hay mas platos por hacer");
    }
    
    @Test
    public void calcularTiempoPedido1Plato() {
        int tiempoEsperado = new CtrlMesero().calcularTiempoPedido(2);
        System.out.println(tiempoEsperado);
        int tiempoEstimado = 3;
        assertEquals(tiempoEsperado, tiempoEstimado, "deben concordar");
    }
       
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
