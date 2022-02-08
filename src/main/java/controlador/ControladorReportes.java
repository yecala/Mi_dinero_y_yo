/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.DAO.CategoriaDAO;
import modelo.DAO.ReportesDAO;
import modelo.POJO.Categoria;

/**
 *
 * @author Usuario
 */
public class ControladorReportes extends HttpServlet {

    ReportesDAO dao = new ReportesDAO();
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
            out.println("<title>Servlet ControladorReportes</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorReportes at " + request.getContextPath() + "</h1>");
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

        HttpSession session = request.getSession();
        int id_usuario = (int) session.getAttribute("idUsuario");

        String accion = request.getParameter("accion");
        switch (accion) {
            case "Listar":
                List<Categoria> datos = new ArrayList<>();
                datos = dao.listar(id_usuario);

                long totalPresu = 0;
                long totalGasto = 0;
                for (Categoria presu : datos) {
                    totalPresu = totalPresu + presu.getPresupuesto_categoria();
                    totalGasto = totalGasto + presu.getGasto_categoria();
                }

                long presuTotal = dao.PresupuestoTotal(id_usuario);
                long ahorroEsperado = presuTotal - totalPresu;
                long ahorroReal = presuTotal - totalGasto;

                if (ahorroEsperado < 0) {
                    String NotificacionMala="Tu presupuesto esta bajo ceros";
                    session.setAttribute("Notificacion",NotificacionMala);

                }else{
                    String NotificacionBuena="Esta planeando ahorros sigue asi";
                    session.setAttribute("Notificacion",NotificacionBuena);
                
                }
                if (ahorroReal < 0) {
                    String NotificacionMala="Has gastado mas de lo que abarca tu presupuesto!";
                    session.setAttribute("Notificacion",NotificacionMala);

                }else{
                    String NotificacionBuena="Estas ahorrando mucho sigue asi!";
                    session.setAttribute("Notificacion",NotificacionBuena);
                
                }
                

                request.setAttribute("datos", datos);
                request.setAttribute("totalPresu", totalPresu);
                request.setAttribute("totalGasto", totalGasto);
                request.setAttribute("presuTotal", presuTotal);
                request.setAttribute("ahorroEsperado", ahorroEsperado);
                request.setAttribute("ahorroReal", ahorroReal);

                request.getRequestDispatcher("Reportes.jsp").forward(request, response);
                break;

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
