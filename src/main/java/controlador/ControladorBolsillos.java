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
import modelo.DAO.CategoriaDAO;
import modelo.POJO.Bolsillo;
import modelo.POJO.Categoria;
import modelo.POJO.Usuario;

/**
 *
 * @author Usuario
 */
public class ControladorBolsillos extends HttpServlet {

    BolsilloDAO dao = new BolsilloDAO();
    CategoriaDAO daoCAT = new CategoriaDAO();
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
        /*
        int id_categorias = Integer.parseInt(request.getParameter("idCategoria"));
        String nom_cate = request.getParameter("nomCate");
        
        HttpSession session =request.getSession();
        session.setAttribute("categoria_actual", id_categorias);
        session.setAttribute("nom_categoria", nom_cate);*/
        HttpSession session = request.getSession();

        int id_usuario = (int) session.getAttribute("idUsuario");
        int id_categoria = (int) session.getAttribute("categoria_actual");

        Categoria cat = new Categoria();
        cat = daoCAT.sumarPresupuestoGasto(id_usuario, id_categoria);

        Usuario usu = new Usuario();
        usu = daoCAT.presupuestoDisponible(id_usuario);

        long presupuesto_disponible = usu.getPresupuesto_total() - usu.getPresupuesto_disponible();

        usu.setPresupuesto_disponible(presupuesto_disponible);

        request.setAttribute("Usuario", usu);
        request.setAttribute("Categoria", cat);

        request.getRequestDispatcher("tablaBolsillos.jsp").forward(request, response);
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

        Categoria cat = new Categoria();
        Usuario usu = new Usuario();
        if (session.getAttribute("idUsuario") != null) {

            id_usuario = (int) session.getAttribute("idUsuario");
            id_categoria = (int) session.getAttribute("categoria_actual");

            cat = daoCAT.sumarPresupuestoGasto(id_usuario, id_categoria);

            usu = daoCAT.presupuestoDisponible(id_usuario);

            long presupuesto_disponible = usu.getPresupuesto_total() - usu.getPresupuesto_disponible();

            usu.setPresupuesto_disponible(presupuesto_disponible);

            request.setAttribute("Usuario", usu);
            request.setAttribute("Categoria", cat);

        }

        //request.getRequestDispatcher("tablaBolsillos.jsp").forward(request, response);
        String accion = request.getParameter("accion");
        switch (accion) {
            case "Listar":

                if (session.getAttribute("idUsuario") != null) {
                    id_usuario = (int) session.getAttribute("idUsuario");
                    id_categoria = (int) session.getAttribute("categoria_actual");

                    cat = daoCAT.sumarPresupuestoGasto(id_usuario, id_categoria);
                    usu = daoCAT.presupuestoDisponible(id_usuario);
                    long presupuesto_disponible = usu.getPresupuesto_total() - usu.getPresupuesto_disponible();
                    usu.setPresupuesto_disponible(presupuesto_disponible);

                    List<Bolsillo> datos = dao.listar(id_usuario, id_categoria);

                    request.setAttribute("Usuario", usu);
                    request.setAttribute("Categoria", cat);
                    request.setAttribute("datos", datos);

                    request.getRequestDispatcher("tablaBolsillos.jsp").forward(request, response);
                } else {

                    String error = "Debe registrarse para crear y ver bolsillos";
                    request.setAttribute("error", error);
                    request.getRequestDispatcher("tablaBolsillos.jsp").forward(request, response);

                }

                break;

            case "Nuevo":

                if (session.getAttribute("idUsuario") != null) {
                    id_usuario = (int) session.getAttribute("idUsuario");
                    id_categoria = (int) session.getAttribute("categoria_actual");

                    cat = daoCAT.sumarPresupuestoGasto(id_usuario, id_categoria);
                    usu = daoCAT.presupuestoDisponible(id_usuario);
                    long presupuesto_disponible = usu.getPresupuesto_total() - usu.getPresupuesto_disponible();
                    usu.setPresupuesto_disponible(presupuesto_disponible);

                    List<Bolsillo> datos = dao.listar(id_usuario, id_categoria);

                    request.setAttribute("Usuario", usu);
                    request.setAttribute("Categoria", cat);
                    

                     request.getRequestDispatcher("agregarBolsillos.jsp").forward(request, response);
                } else {
                    request.setAttribute("Usuario", usu);
                    request.setAttribute("Categoria", cat);
                    request.getRequestDispatcher("agregarBolsillos.jsp").forward(request, response);
                }
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
                request.setAttribute("Usuario", usu);
                request.setAttribute("Categoria", cat);

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
