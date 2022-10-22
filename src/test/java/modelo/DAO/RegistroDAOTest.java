/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package modelo.DAO;

import modelo.POJO.Registro;
import modelo.POJO.Usuario;
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
public class RegistroDAOTest {
    
    public RegistroDAOTest() {
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
     * Test of guardarUsuario method, of class RegistroDAO.
     */
    @Test
    public void testGuardarUsuario() throws Exception {
        System.out.println("guardarUsuario");
        Registro usuario = new Registro();
        usuario.setNombre("Logan");
        usuario.setCorreo("logan@gmail.com");
        usuario.setContraseña("12345678lL");
        usuario.setPresupuesto(100444);
        
        RegistroDAO instance = new RegistroDAO();
        int expResult = 1;
        int result = instance.guardarUsuario(usuario);
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of guardarUsuario method, of class RegistroDAO. CON FALLA
     */
    @Test
    public void testGuardarUsuarioFalla() throws Exception {
        System.out.println("guardar Usuario: no se envia los campos vacios");
        Registro usuario = new Registro();
        usuario.setNombre("");
        usuario.setCorreo("");
        usuario.setContraseña("");
        
        RegistroDAO instance = new RegistroDAO();
        int expResult = 1;
        int result = instance.guardarUsuario(usuario);
        assertEquals(expResult, result);
        
    }

    
}
