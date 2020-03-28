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
import javax.servlet.http.HttpSession;

/**
 *
 * @author dryro
 */
public class SessionLogin extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        
        HttpSession sessao = req.getSession();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Livraria</title>");
        out.println("</head>");
        out.println("<body>");
        
        if(req.getParameter("username").equals("adri") &&    
                req.getParameter("password").equals("123456")){
            sessao.setAttribute("logado", "true");
            sessao.setAttribute("usuario", req.getParameter("username"));
            
            out.println("<a href=\"vitrine.jsp\">Navegar pela loja</a>");
        } else {
            out.println("<p>Usuário e/ou senha incorretos</p>");   
            out.println("<a href=\"login.jsp\">Tentar novamente</a>");
        }
        
        out.println("</body>");
        out.println("</html>");
    }
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        
        out.println("<html>");
        out.println("<head>"); 
        out.println("<title>Livraria</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Até logo!</p>");
        out.println("</body>");
        out.println("</html>");
        
        HttpSession sessao = req.getSession();        
        sessao.invalidate();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
