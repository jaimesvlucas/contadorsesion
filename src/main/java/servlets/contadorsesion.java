/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DAW-B
 */
public class contadorsesion extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            HttpSession sesion = request.getSession();
            String titulo = null;

            //Pedimos el atributo, y verificamos si existe
            Integer contadorVisitas= (Integer) sesion.getAttribute("contadorVisitas");

            //Si es igual a nulo, quiere decir que es la primera
            //vez que accedemos al recurso
            if (contadorVisitas == null) {
                contadorVisitas = new Integer(1);
                titulo = "Bienvenido por primera vez...";
            } else {
                //si es distinto de nulo, incrementamos el contador
                titulo = "Bienvenido Nuevamente...";
                contadorVisitas += 1;
            }

            //En cualquier caso, agregamos el valor del contador
            //a la sesion
            sesion.setAttribute("contadorVisitas", contadorVisitas);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet contadorsesion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet contadorsesion at " + request.getContextPath() + "</h1>");
            out.println("<h2> " + titulo + "</h2>");
            out.println("<h2>Numero de acceso al recurso " + contadorVisitas + "</h2>");
            out.println("<h2>ID de la sesion " + sesion.getId() + "</h2>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
        processRequest(request, response);
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
