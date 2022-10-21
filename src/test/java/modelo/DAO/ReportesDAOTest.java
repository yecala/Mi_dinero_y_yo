/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package modelo.DAO;

import java.util.ArrayList;
import java.util.List;
import modelo.POJO.Categoria;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class ReportesDAOTest {
    
    public ReportesDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of listar method, of class ReportesDAO.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        int id_usuario = 148;
        ReportesDAO instance = new ReportesDAO();
        List<Categoria>  result = instance.listar(id_usuario);
        int expResult=80678; // La suma del presupuesto de todos los bolsillos de la categoria de menor id que tenga el usuario
        assertTrue("El presupuesto de la categoria debe ser " +expResult , result.get(0).getPresupuesto_categoria()==expResult);
        
    }
    
    /**
     * Test of listar method, of class ReportesDAO. CON FALLA
     */
    @Test
    public void testListarFalla() {
        System.out.println("Listar con falla: se envia un usuario inexistente");
        int id_usuario = 1;
        ReportesDAO instance = new ReportesDAO();
        List<Categoria>  result = instance.listar(id_usuario);
        int expResult=80678; // La suma del presupuesto de todos los bolsillos de la categoria de menor id que tenga el usuario
        assertTrue("El presupuesto de la categoria debe ser " +expResult , result.get(0).getPresupuesto_categoria()==expResult);
        
    }

    /**
     * Test of PresupuestoTotal method, of class ReportesDAO.
     */
    @Test
    public void testPresupuestoTotal() {
        System.out.println("PresupuestoTotal");
        int id_usuario = 161;
        ReportesDAO instance = new ReportesDAO();
        long expResult = 1000000;
        long result = instance.PresupuestoTotal(id_usuario);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of PresupuestoTotal method, of class ReportesDAO. CON FALLA
     */
    @Test
    public void testPresupuestoTotalFalla() {
        System.out.println("Presupuesto Total con falla: se envia un usuario inexistente ");
        int id_usuario = 2;
        ReportesDAO instance = new ReportesDAO();
        long expResult = 1000000;
        long result = instance.PresupuestoTotal(id_usuario);
        assertEquals(expResult, result);
    }
    
}
