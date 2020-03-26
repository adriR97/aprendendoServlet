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
public class Contar extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {     
        
        String nome;
        int vogais = 0, consoantes = 0, espaco = 0;
        
        PrintWriter out;
        out = resp.getWriter();
        resp.setContentType("text/html;charset=UTF-8");
        
        nome = req.getParameter("nome").toUpperCase();
        
        for(int i=0; i<nome.length();i++){
            switch(nome.charAt(i)){
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U': 
                    vogais++;
                    break;
                case ' ':
                    espaco++;
                    break;
                default:
                    consoantes++;
            }
        }
        
        out.println("<html>");        
        out.println("<head>");
        out.println("<title>Vogais e consoantes</title>");        
        out.println("</head>");        
        out.println("<body>");
        out.println("<h2>Seu nome</h2>");
        out.println("<p>Qtde. de caracteres: " + nome.length() + "</p>");
        out.println("<p>Qtde. de vogais: " + vogais  + "</p>");
        out.println("<p>Qtde. de consoantes: " + consoantes + "</p>");
        out.println("<p>Qtde. de espaços em branco: " + espaco + "</p>");        
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
