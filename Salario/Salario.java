/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dryro
 */
public class Salario extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        
        float salbase, grat, desc, salbruto, salliquido;
        DecimalFormat df = new DecimalFormat("R$ 0.00");
        
        salbase = Float.parseFloat(req.getParameter("salbase").replace(',', '.'));
        grat = Float.parseFloat(req.getParameter("grat").replace(',', '.'));
        desc = Float.parseFloat(req.getParameter("desc").replace(',', '.'));
        
        salbruto = salbase + salbase * (grat / 100);
        salliquido = salbruto - salbruto * (desc / 100);
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Salário</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Folha de pagamento</h2>");
        out.println("<p>Salário líquido: " + df.format(salliquido) + "</p>");
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
