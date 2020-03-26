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
public class Situacao extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        String situacao;
        char sexo;
        float nota1, nota2;
        
        PrintWriter out;
        resp.setContentType("text/html;charset=UTF-8");
        out = resp.getWriter();
        
        if(req.getParameter("sexo") != null){
            sexo = req.getParameter("sexo").charAt(0);
        } else {
            sexo = ' ';
        }
        
        nota1 = Float.parseFloat(req.getParameter("nota1").replace(',', '.'));
        nota2 = Float.parseFloat(req.getParameter("nota2").replace(',', '.'));
        
        if((nota1 + nota2) / 2 >= 7){
            if(sexo == 'F'){
                situacao = "Aprovada";
            } else {
                situacao = "Aprovado";
            }
        } else {
            if(sexo == 'F'){
                situacao = "Reprovada";
            } else {
                situacao = "Reprovado";
            }
        }
        
        out.println("<html>");        
        out.println("<head>");
        out.println("<title>Histórico Escolar</title>");        
        out.println("</head>");        
        out.println("<body>");
        out.println("<h2>Histórico Escolar</h2>");
        out.println("<p>Nome: " + req.getParameter("nome") + "</p>");
        out.println("<p>Média: " + ( (nota1 + nota2) / 2 ) + "</p>");
        out.println("<p>Situação: " + situacao + "</p>");        
        out.println("</body>");        
        out.println("</html>");  
        
     }    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
