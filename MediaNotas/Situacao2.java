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
public class Situacao2 extends HttpServlet {

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
        float nota1 = 0, nota2 = 0;
        boolean notasOk;
        
        PrintWriter out;
        out = resp.getWriter();        
        resp.setContentType("text/html;charset=UTF-8");
        
        if(req.getParameter("sexo") != null){
            sexo = req.getParameter("sexo").charAt(0);
        } else{
            sexo = ' ';
        }
        
        //tratamento de exceção
        try{
            nota1 = Float.parseFloat(req.getParameter("nota1").replace(',', '.'));
            nota2 = Float.parseFloat(req.getParameter("nota2").replace(',', '.'));
            notasOk = true;
        }catch (Exception e){
            notasOk = false;
        }
        
        if(notasOk){
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
        } else {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Histórico Escolar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Histórico Escolar</h2>");
            out.println("<p>A(s) nota(s) não é(são) válida(s).</p>");
            out.println("<p>Favor verificar e digitar novamente.</p>");
            out.println("</body>");
            out.println("</html>");
        }
        
        
        
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
