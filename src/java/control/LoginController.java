/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import inject.servlet.ApplicationContextServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.server.authorization.authorization.Authorizator;

/**
 *
 * @author koxa
 */
public class LoginController extends ApplicationContextServlet {
    
    private static final String SUBMITTED_PARAMETER_NAME = "submitted";
    private static final String REQ_SUBMITTED_ATTRIBUTE_NAME = "req_submitted";

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getParameter(SUBMITTED_PARAMETER_NAME) == null) {
            request.setAttribute(REQ_SUBMITTED_ATTRIBUTE_NAME, "false");
            request.getRequestDispatcher("./login.jsp").forward(request, response);
            return;
        } else {
            request.setAttribute(REQ_SUBMITTED_ATTRIBUTE_NAME, "true");
        }
        
        Authorizator authorizator = new Authorizator(request);
        authorizator.check(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
