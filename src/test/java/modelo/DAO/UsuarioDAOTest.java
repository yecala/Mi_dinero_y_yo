/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package modelo.DAO;

import java.util.ArrayList;
import java.util.List;
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
public class UsuarioDAOTest {
    
    public UsuarioDAOTest() {
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
     * Test of listar method, of class UsuarioDAO. lista todos los usuarios
     */
    @Test
    public void testListar() {
        System.out.println("listar todos los ususarios");
        UsuarioDAO instance = new UsuarioDAO();
        Usuario us = new Usuario();
        String expResult=  "danielz@gmail.com";
        List result = instance.listar();
        us= (Usuario) result.get(0);
        String result1 = us.getCorreo();
        assertEquals(expResult, result1);
    }
    
    /**
     * Test of listar method, of class UsuarioDAO. lista todos los usuarios CON FALLA
     */
    @Test
    public void testListarFalla() {
        System.out.println("listar todos los ususarios: se compara con un dato que o esta en base de datos");
        UsuarioDAO instance = new UsuarioDAO();
        Usuario us = new Usuario();
        String expResult=  "k@mail.com";
        List result = instance.listar();
        us= (Usuario) result.get(2);
        String result1 = us.getCorreo();
        assertEquals(expResult, result1);
    }
    

    /**
     * Test of ListarId method, of class UsuarioDAO. lista un usuario por el id
     */
    @Test
    public void testListarId() {
        System.out.println("Listar por Id");
        String id = "222";
        UsuarioDAO instance = new UsuarioDAO();
        Usuario expResult = new Usuario();
        expResult.setId_usuario(222);
        expResult.setNombre_usuario("Zoey");
        expResult.setCorreo("zoey@gmail.com");
        expResult.setPassword("12345678zZ");
        expResult.setPresupuesto_total(100444);
        expResult.setEstado(1);
        expResult.setBit_admin(0);
        
        Usuario result = instance.ListarId(id);
        assertEquals(expResult.getPresupuesto_total(), result.getPresupuesto_total());
    }
    
    /**
     * Test of ListarId method, of class UsuarioDAO. lista un usuario por el id CON FALLA
     */
    @Test
    public void testListarIdFalla() {
        System.out.println("Listar por Id: se envia usuario inexistente");
        String id = "2";
        UsuarioDAO instance = new UsuarioDAO();
        Usuario expResult = new Usuario();
        expResult.setId_usuario(222);
        expResult.setNombre_usuario("Zoey");
        expResult.setCorreo("zoey@gmail.com");
        expResult.setPassword("12345678zZ");
        expResult.setPresupuesto_total(100444);
        expResult.setEstado(1);
        expResult.setBit_admin(0);
        
        Usuario result = instance.ListarId(id);
        assertEquals(expResult.getPresupuesto_total(), result.getPresupuesto_total());
    }

    /**
     * Test of actualizar method, of class UsuarioDAO.
     */
    @Test
    public void testActualizar() {
        System.out.println("actualizar un ususario");
        Usuario u = new Usuario();
        u.setId_usuario(222);
        u.setNombre_usuario("Zoey 1");
        u.setCorreo("zoey@gmail.com");
        u.setPassword("12345678zZ");
        u.setPresupuesto_total(100444);
        u.setEstado(1);
        u.setBit_admin(0);
        UsuarioDAO instance = new UsuarioDAO();
        int expResult = 1;
        int result = instance.actualizar(u);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of actualizar method, of class UsuarioDAO.
     */
    @Test
    public void testActualizarFalla() {
        System.out.println("actualizar: se envia un usuario inexistente");
        Usuario u = new Usuario();
        u.setId_usuario(3);
        u.setNombre_usuario("Zoey 1");
        u.setCorreo("zoey@gmail.com");
        u.setPassword("12345678zZ");
        u.setPresupuesto_total(100444);
        u.setEstado(1);
        u.setBit_admin(0);
        UsuarioDAO instance = new UsuarioDAO();
        int expResult = 1;
        int result = instance.actualizar(u);
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of delete method, of class UsuarioDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("Desactivar usuario");
        Usuario u = new Usuario();
        u.setId_usuario(201);
        UsuarioDAO instance = new UsuarioDAO();
        int expResult = 1;
        int result = instance.delete(u);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of delete method, of class UsuarioDAO. CON FALLA
     */
    @Test
    public void testDeleteFalla() {
        System.out.println("Desactivar usuario: se envia usuario inexistente");
        Usuario u = new Usuario();
        u.setId_usuario(2);
        UsuarioDAO instance = new UsuarioDAO();
        int expResult = 1;
        int result = instance.delete(u);
        assertEquals(expResult, result);
    }

    /**
     * Test of agregar method, of class UsuarioDAO.
     */
    @Test
    public void testAgregar() {
        System.out.println("agregar un nuevo usuario");
        Usuario p = new Usuario();
        p.setId_usuario(1);
        p.setNombre_usuario("lola");
        p.setCorreo("lola@gmail.com");
        p.setPassword("12345678lL");
        p.setPresupuesto_total(222000);
        p.setEstado(1);
        p.setBit_admin(1);
        UsuarioDAO instance = new UsuarioDAO();
        int expResult = 1;
        int result = instance.agregar(p);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of agregar method, of class UsuarioDAO. CON FALLA
     */
    @Test
    public void testAgregarFalla() {
        System.out.println("agregar un nuevo usuario: no se envian todos los datos");
        Usuario p = new Usuario();
        p.setId_usuario(1);
        p.setNombre_usuario("lola");
        p.setCorreo("lola@gmail.com");
        //p.setPassword("12345678lL");
        p.setPresupuesto_total(222000);
        p.setEstado(1);
        p.setBit_admin(1);
        UsuarioDAO instance = new UsuarioDAO();
        int expResult = 1;
        int result = instance.agregar(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerUsuarioPorEmail method, of class UsuarioDAO.
     */
    @Test
    public void testObtenerUsuarioPorEmail() {
        System.out.println("obtenerUsuarioPorEmail");
        String correo = "zoey@gmail.com";
        UsuarioDAO instance = new UsuarioDAO();
        Usuario expResult = new Usuario();
        expResult.setId_usuario(222);
        expResult.setNombre_usuario("Zoey 1");
        expResult.setCorreo("zoey@gmail.com");
        expResult.setPassword("12345678zZ");
        expResult.setPresupuesto_total(100444);
        expResult.setEstado(1);
        expResult.setBit_admin(0);
        Usuario result = instance.obtenerUsuarioPorEmail(correo);
        assertEquals(expResult.getPassword(), result.getPassword());
        
    }
    
    /**
     * Test of obtenerUsuarioPorEmail method, of class UsuarioDAO. CON FALLA
     */
    @Test
    public void testObtenerUsuarioPorEmailFalla() {
        System.out.println("obtener Usuario Por Email: se envia un correo inexistente");
        String correo = "zoey@g.com";
        UsuarioDAO instance = new UsuarioDAO();
        Usuario expResult = new Usuario();
        expResult.setId_usuario(222);
        expResult.setNombre_usuario("Zoey 1");
        expResult.setCorreo("zoey@gmail.com");
        expResult.setPassword("12345678zZ");
        expResult.setPresupuesto_total(100444);
        expResult.setEstado(1);
        expResult.setBit_admin(0);
        Usuario result = instance.obtenerUsuarioPorEmail(correo);
        assertEquals(expResult.getPassword(), result.getPassword());
        
    }

    /**
     * Test of actualizarPerfil method, of class UsuarioDAO.
     */
    @Test
    public void testActualizarPerfil() {
        System.out.println("actualizarPerfil");
        Usuario u = new Usuario();
        u.setId_usuario(241);
        u.setNombre_usuario("Lolita");
        u.setPassword("123456789zZ");
        u.setPresupuesto_total(0);
        
        UsuarioDAO instance = new UsuarioDAO();
        int expResult = 1;
        int result = instance.actualizarPerfil(u);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of actualizarPerfil method, of class UsuarioDAO. CON FALLA
     */
    @Test
    public void testActualizarPerfilFalla() {
        System.out.println("actualizar Perfil: se envia id de ussuario inexistente ");
        Usuario u = new Usuario();
        u.setId_usuario(4);
        u.setNombre_usuario("Lolita");
        u.setPassword("123456789zZ");
        u.setPresupuesto_total(0);
        
        UsuarioDAO instance = new UsuarioDAO();
        int expResult = 1;
        int result = instance.actualizarPerfil(u);
        assertEquals(expResult, result);
    }
    
}
