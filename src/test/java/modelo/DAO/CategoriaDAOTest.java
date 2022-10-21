/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.util.List;
import modelo.POJO.Categoria;
import modelo.POJO.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pipe_
 */
public class CategoriaDAOTest {
    
    public CategoriaDAOTest() {
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
     * Test of listar method, of class CategoriaDAO.
     */
    @Test
    public void testListar() {
        System.out.println("listar categorias: se envian datos de una categoria existente");
        int id_categoria =4;
        CategoriaDAO instance = new CategoriaDAO();
        Categoria cat = new Categoria();
        String expResult = "Viajes";
        List result = instance.listar();
        cat = (Categoria) result.get(2);
        String result1 = cat.getNombre_categoria();
        assertEquals(expResult, result);
    }
    
     @Test
    public void testListarFalla() {
        System.out.println("listar categorias: se envian datos de una categoria que no existe");
        int id_categoria =6;
        CategoriaDAO instance = new CategoriaDAO();
        Categoria cat = new Categoria();
        String expResult = "Hola mundo";
        List result = instance.listar();
        cat = (Categoria) result.get(4);
        String result1 = cat.getNombre_categoria();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of ListarId method, of class CategoriaDAO.
     */
    @Test
    public void testListarId() {
        System.out.println("Listar categoria por id con datos correctos");
        String id_categoria = "1";
        CategoriaDAO instance = new CategoriaDAO();
        String expResult = "Control de gastos";
        Categoria result = instance.ListarId(id_categoria);
        assertTrue("Probando consejo de la categoria", result.getConsejo().equals(expResult));

    }
    
    @Test
     public void testListarIdFalla() {
        System.out.println("Listar categoria por id con datos inexistentes en base de datos");
        String id_categoria = "5";
        CategoriaDAO instance = new CategoriaDAO();
        String expResult = "Inversión";
        Categoria result = instance.ListarId(id_categoria);
        assertTrue("Probando consejo de la categoria", result.getConsejo().equals(expResult));

    }
    
    /**
     * Test of actualizar method, of class CategoriaDAO.
     */
    @Test
    public void testActualizar() {
        System.out.println("actualizar categoria: se envian los datos correctos de una categoria");
        Categoria categ = new Categoria();
        categ.setNombre_categoria("Salud");
        categ.setConsejo("Deber invertir bien");
        categ.setId_categoria(2);
        CategoriaDAO instance = new CategoriaDAO();
        int expResult = 1;
        int result = instance.actualizar(categ);
        assertEquals(expResult, result);
    }
     @Test
    public void testActualizarFalla() {
        System.out.println("actualizar categoria: se envian los datos de una categoria que no existe");
        Categoria categ = new Categoria();
        categ.setNombre_categoria("Plantas");
        categ.setConsejo("Invertir es importante");
        categ.setId_categoria(8);
        CategoriaDAO instance = new CategoriaDAO();
        int expResult = 1;
        int result = instance.actualizar(categ);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of num_bolsillos method, of class CategoriaDAO.
     */
    @Test
    public void testNum_bolsillos() {
        System.out.println("id del primero bolsillo de la categoria");
        String id_categoria ="4";
        CategoriaDAO instance = new CategoriaDAO();
        int expResult = 158;
        int result = instance.num_bolsillos(id_categoria);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of num_bolsillos method, of class CategoriaDAO.
     */
    @Test
    public void testNum_bolsillosFalla() {
        System.out.println("id del primero bolsillo de la categoria");
        String id_categoria ="8";
        CategoriaDAO instance = new CategoriaDAO();
        int expResult = 158;
        int result = instance.num_bolsillos(id_categoria);
        assertEquals(expResult, result);
    }
   

    /**
     * Test of delete method, of class CategoriaDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("Eliminar una categoria existente");
        String id_categoria = "11";
        CategoriaDAO instance = new CategoriaDAO();
        int expResult = 1;
        int result = instance.delete(id_categoria);
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of delete method, of class CategoriaDAO.
     */
    @Test
    public void testDeleteFalla() {
        System.out.println("Eliminar una categoria que no existe");
        String id_categoria = "6";
        CategoriaDAO instance = new CategoriaDAO();
        int expResult = 1;
        int result = instance.delete(id_categoria);
        assertEquals(expResult, result);
    }

    /**
     * Test of agregar method, of class CategoriaDAO.
     */
    @Test
    public void testAgregar() {
        System.out.println("agregar categoria");
        Categoria cat = new Categoria();
        cat.setId_categoria(7);
        cat.setNombre_categoria("Imprevistos");
        cat.setConsejo("Debes ahorrar un poco para gastos imprevistos");
        CategoriaDAO instance = new CategoriaDAO();
        int expResult = 1;
        int result = instance.agregar(cat);
        assertEquals(expResult, result);
    }

     /**
     * Test of agregar method, of class CategoriaDAO.
     */
    @Test
    public void testAgregarFalla() {
        System.out.println("agregar categoria con un id ya existente");
        Categoria cat = new Categoria();
        cat.setId_categoria(9);
        cat.setNombre_categoria("Vehiculo");
        cat.setConsejo("Debes ahorrar un poco para gastos de tu vehiculo");
        CategoriaDAO instance = new CategoriaDAO();
        int expResult = 1;
        int result = instance.agregar(cat);
        assertEquals(expResult, result);
    }

    /**
     * Test of sumarPresupuestoGasto method, of class CategoriaDAO.
     */
    @Test
    public void testSumarPresupuestoGasto() {
        System.out.println("sumarPresupuestoGasto");
        int id_usuario = 0;
        int id_categoria = 0;
        CategoriaDAO instance = new CategoriaDAO();
        Categoria expResult = null;
        Categoria result = instance.sumarPresupuestoGasto(id_usuario, id_categoria);
        assertEquals(expResult, result);
    }

    /**
     * Test of presupuestoDisponible method, of class CategoriaDAO.
     */
    @Test
    public void testPresupuestoDisponible() {
        System.out.println("presupuesto Disponible de un usuario");
        int id_usuario = 81;
        CategoriaDAO instance = new CategoriaDAO();
        Usuario expResult = new Usuario();
        expResult.setId_usuario(222);
        expResult.setPresupuesto_total(360000);
        expResult.setPresupuesto_disponible(368000);
        Usuario result = instance.presupuestoDisponible(id_usuario);
        assertEquals(expResult.getPresupuesto_disponible(), result.getPresupuesto_disponible());
    }
    
     /**
     * Test of presupuestoDisponible method, of class CategoriaDAO.
     */
    @Test
    public void testPresupuestoDisponibleFalla() {
        System.out.println("presupuesto Disponible de un usuario");
        int id_usuario = 95;
        CategoriaDAO instance = new CategoriaDAO();
        Usuario expResult = new Usuario();
        expResult.setId_usuario(222);
        expResult.setPresupuesto_total(360000);
        expResult.setPresupuesto_disponible(368000);
        Usuario result = instance.presupuestoDisponible(id_usuario);
        assertEquals(expResult.getPresupuesto_disponible(), result.getPresupuesto_disponible());
    }
    
}
