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
import modelo.DAO.CategoriaDAO;
import modelo.POJO.Categoria;

/**
 *
 * @author Usuario
 */
public class ControladorCategorias extends HttpServlet {

    CategoriaDAO dao = new CategoriaDAO();
    Categoria cate = new Categoria();
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
            out.println("<title>Servlet ControladorCategorias</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorCategorias at " + request.getContextPath() + "</h1>");
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
              String accion = request.getParameter("accion");
        switch (accion) {
            case "Listar":

                List<Categoria> datos = dao.listar();
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("adminCategorias.jsp").forward(request, response);
                break;

            case "Editar":
                String ide = request.getParameter("id");
                Categoria cat = dao.ListarId(ide);
                request.setAttribute("Categoria", cat);
                request.getRequestDispatcher("editCategoria.jsp").forward(request, response);
                break;

            case "Actualizar":
                String id1 = request.getParameter("txtid");
                String nom1 = request.getParameter("txtnom");
                String presupuesto1 = request.getParameter("txtpresupuesto");
                String gasto1 = request.getParameter("txtgasto");

                int idint = Integer.parseInt(id1);
                long presupuestlolong = Long.parseLong(presupuesto1);
                long gastolong = Long.parseLong(gasto1);
                
                cate.setId_categoria(idint);
                cate.setNombre_categoria(nom1);
                cate.setPresupuesto_categoria(presupuestlolong);
                cate.setGasto_categoria(gastolong);
                
                dao.actualizar(cate);
                request.getRequestDispatcher("ControladorCategorias?accion=Listar").forward(request, response);
                break;
            case "Delete":
                String id2 = request.getParameter("id");
                dao.delete(id2);
                request.getRequestDispatcher("ControladorCategorias?accion=Listar").forward(request, response);
                break;

            case "Nuevo":
                request.getRequestDispatcher("agregarCategorias.jsp").forward(request, response);
                break;
                
                
            case "submit":
                
                String id = request.getParameter("txtid");
                String nombres = request.getParameter("txtnombres");
                String presupuesto = request.getParameter("txtpresupuesto");
                String gasto = request.getParameter("txtgasto");
                
                int id3 = Integer.parseInt(id);
                long presupuesto3 = Long.parseLong(presupuesto);
                long gasto3 = Long.parseLong(gasto);
                
                cate.setId_categoria(id3);
                cate.setNombre_categoria(nombres);
                cate.setPresupuesto_categoria(presupuesto3);
                cate.setGasto_categoria(gasto3);
                
                dao.agregar(cate);
                request.getRequestDispatcher("ControladorCategorias?accion=Listar").forward(request, response);
                
                    
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
