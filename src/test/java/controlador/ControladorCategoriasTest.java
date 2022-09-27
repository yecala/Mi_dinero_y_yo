/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controlador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class ControladorCategoriasTest {
    
    public ControladorCategoriasTest() {
    }

    @org.junit.Test
    public void testProcessRequest() throws Exception {
        System.out.println("processRequest");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        ControladorCategorias instance = new ControladorCategorias();
        instance.processRequest(request, response);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testDoGet() throws Exception {
        System.out.println("doGet");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        ControladorCategorias instance = new ControladorCategorias();
        instance.doGet(request, response);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testDoPost() throws Exception {
        System.out.println("doPost");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        ControladorCategorias instance = new ControladorCategorias();
        instance.doPost(request, response);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testGetServletInfo() {
        System.out.println("getServletInfo");
        ControladorCategorias instance = new ControladorCategorias();
        String expResult = "";
        String result = instance.getServletInfo();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
