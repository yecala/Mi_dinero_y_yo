/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import modelo.DAO.BolsilloDAO;
import modelo.POJO.Bolsillo;

/**
 *
 * @author Usuario
 */
public class ControladorBolsillos extends HttpServlet {

    BolsilloDAO dao = new BolsilloDAO();
    Bolsillo bol = new Bolsillo();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorBolsillos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorBolsillos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_usuario = 0;
        int id_categoria = 0;
        HttpSession session = request.getSession();
        id_usuario = (int) session.getAttribute("idUsuario");
        id_categoria = (int) session.getAttribute("categoria_actual");
        
        
       
        String accion = request.getParameter("accion");
        switch (accion) {
            case "Listar":

                List<Bolsillo> datos = dao.listar(id_usuario, id_categoria);
                
                long sumabolsillos;
                
                
                        
                request.setAttribute("datos", datos);
                
                request.getRequestDispatcher("tablaBolsillos.jsp").forward(request, response);
                break;

            case "Nuevo":
                request.getRequestDispatcher("agregarBolsillos.jsp").forward(request, response);
                break;

            case "Guardar":

                String nombres = request.getParameter("txtnombre");
                String presu = request.getParameter("txtpresupuesto");
                String gasto = request.getParameter("txtgasto");

                long presupuesto = Long.parseLong(presu);
                long gastoReal = Long.parseLong(gasto);

                bol.setNombre_bolsillo(nombres);
                bol.setPresupuesto_bolsillo(presupuesto);
                bol.setGasto_bolsillo(gastoReal);
                bol.setId_categoria(id_categoria);
                bol.setId_usuario(id_usuario);

                dao.agregar(bol);
                
                request.getRequestDispatcher("ControladorBolsillos?accion=Listar").forward(request, response);

                break;
                
                
            case "Editar":
                String ide = request.getParameter("id");
                Bolsillo bolsi = dao.ListarId(ide);
                
                request.setAttribute("Bolsillo", bolsi);
                
                request.getRequestDispatcher("editarBolsillo.jsp").forward(request, response);
                break;
                
                
            case "Actualizar":
               
                String nombres1 = request.getParameter("txtnombre");
                String presu1 = request.getParameter("txtpresupuesto");
                String gasto1 = request.getParameter("txtgasto");
                String idBolsi = request.getParameter("id");
                int idbol = Integer.parseInt(idBolsi);
                long presupuesto1 = Long.parseLong(presu1);
                long gastoReal1 = Long.parseLong(gasto1);

                bol.setId_bolsillo(idbol);
                bol.setNombre_bolsillo(nombres1);
                bol.setPresupuesto_bolsillo(presupuesto1);
                bol.setGasto_bolsillo(gastoReal1);
                bol.setId_categoria(id_categoria);
                bol.setId_usuario(id_usuario);

                dao.actualizar(bol);
                request.getRequestDispatcher("ControladorBolsillos?accion=Listar").forward(request, response);
                break;

            case "Delete":
                String id2 = request.getParameter("id");
                int id3 = Integer.parseInt(id2);
                
                dao.delete(id3);
                request.getRequestDispatcher("ControladorBolsillos?accion=Listar").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
