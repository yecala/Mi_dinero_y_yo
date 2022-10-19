/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package modelo.DAO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import modelo.POJO.Bolsillo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class BolsilloDAOTest {
    
    public BolsilloDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("----------Comienzo del test-----------");
    }
    
    @After
    public void tearDown() {
        System.out.println("Hora:"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")));
    }

    /**
     * Test of listar method, of class BolsilloDAO.
     */
    @Test
    public void testListar() {
        
        System.out.println("Test de listar bolsillos");
        int id_usuario = 181;
        int id_categoria = 3;
        BolsilloDAO instance = new BolsilloDAO();
        int expResult = 3;
        System.out.println("RESULTADO ESPERADO / RESULTADO OBTENIDO");
        List result = instance.listar(id_usuario, id_categoria);
        assertTrue("El numero de bolsillos debe ser igual a " + expResult, result.size()==expResult);
       // assertEquals(expResult , result.size());
        
        //assertEquals("El resultado esperado son " + expResult + "bolsillos --> ", result.size());
        
    }

//    /**
//     * Test of ListarId method, of class BolsilloDAO.
//     */
//    @Test
//    public void testListarId() {
//        System.out.println("ListarId");
//        String id = "";
//        BolsilloDAO instance = new BolsilloDAO();
//        Bolsillo expResult = null;
//        Bolsillo result = instance.ListarId(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of agregar method, of class BolsilloDAO.
//     */
//    @Test
//    public void testAgregar() {
//        System.out.println("agregar");
//        Bolsillo bol = null;
//        BolsilloDAO instance = new BolsilloDAO();
//        int expResult = 0;
//        int result = instance.agregar(bol);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of actualizar method, of class BolsilloDAO.
//     */
//    @Test
//    public void testActualizar() {
//        System.out.println("actualizar");
//        Bolsillo bol = null;
//        BolsilloDAO instance = new BolsilloDAO();
//        int expResult = 0;
//        int result = instance.actualizar(bol);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of delete method, of class BolsilloDAO.
//     */
//    @Test
//    public void testDelete() {
//        System.out.println("delete");
//        int id = 0;
//        BolsilloDAO instance = new BolsilloDAO();
//        int expResult = 0;
//        int result = instance.delete(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
