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
    }


    /**
     * Test of ListarId method, of class BolsilloDAO.
     */
    @Test
    public void testListarId() {
        System.out.println("ListarId");
        String id = "7";
        BolsilloDAO instance = new BolsilloDAO();
        String expeResult="bus";
        Bolsillo result = instance.ListarId(id);
        assertTrue("Probando nombre del bolsillo", result.getNombre_bolsillo().equals(expeResult));
    }

    /**
     * Test of agregar method, of class BolsilloDAO.
     */
    @Test
    public void testAgregar() {
        System.out.println("agregar");
        Bolsillo bol = new Bolsillo();
        bol.setId_bolsillo(0);
        bol.setNombre_bolsillo("tesito");
        bol.setPresupuesto_bolsillo(600000);
        bol.setGasto_bolsillo(400000);
        bol.setId_categoria(5);
        bol.setId_usuario(181);
        BolsilloDAO instance = new BolsilloDAO();
        int expResult = 1;
        int result = instance.agregar(bol);
        assertEquals(expResult, result, "Se agrego el bolsillo correctamente ");
    }

    /**
     * Test of actualizar method, of class BolsilloDAO.
     */
    @Test
    public void testActualizar() {
        System.out.println("actualizar");
        Bolsillo bol = new Bolsillo();
        bol.setId_bolsillo(146);
        bol.setNombre_bolsillo("tesito funciona3");
        bol.setPresupuesto_bolsillo(600001);
        bol.setGasto_bolsillo(400001);
        bol.setId_categoria(5);
        bol.setId_usuario(181); //el usuario no existe 
        BolsilloDAO instance = new BolsilloDAO();
        int expResult = 1; //como el ususario no existe el resultado esperado es 0 es decir, no actualiza
        int result = instance.actualizar(bol);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class BolsilloDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 147;
        BolsilloDAO instance = new BolsilloDAO();
        int expResult = 1;
        int result = instance.delete(id);
        assertEquals(expResult, result);
    }
    
}
