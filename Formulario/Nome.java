/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dryro
 */
public class Nome extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        String nome_completo, pronome;
        char sexo;
        
        PrintWriter out;
        resp.setContentType("text/html");
        out = resp.getWriter();
        
        nome_completo = req.getParameter("nome") + " " + req.getParameter("sobre");
        
        if(req.getParameter("sexo") != null){
            sexo = req.getParameter("sexo").charAt(0);
        } else {
            sexo = ' ';
        }
        
        if(sexo == 'F'){
            pronome = "Sra. ";
        } else if(sexo == 'M'){
            pronome = "Sr.";
        } else {
            pronome = "";
        }
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Seu nome</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Olá, " + pronome + nome_completo + "!</p>");
        out.println("</body>");
        out.println("</html>");
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
