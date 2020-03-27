/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dryro
 */
public class Quiz extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession sessao = request.getSession();
        
        if (sessao.isNew()){
            //transferindo a requesição para outro arquivo  
            RequestDispatcher dispatcher = request.getRequestDispatcher("quiz.html"); 
            dispatcher.forward(request, response);     
        }
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        
        long creationTime, submitTime, intervalTime;
        HttpSession sessao = req.getSession();
        
        //retorna a hora que a sessão foi criada em milissegundos
        creationTime = sessao.getCreationTime(); 
        //retorna a hora atual do sistema
        submitTime = System.currentTimeMillis();
        /*subtraindo a hora da criação da sessão da hora atual do sistema
        e dividindo por 1000 que corresponde a um segundo*/
        intervalTime = (submitTime - creationTime) / 1000;
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Quiz</title>");
        out.println("</head>");
        out.println("<body>");
        
        if (intervalTime > 30) //verificando se o tempo de 30 segundos foi respeitado
            out.println("<p>Que pena! " +"Você não respondeu no tempo permitido!</p>");
        else {
            int acertos = 0;
            
            if (req.getParameter("p1") != null &&req.getParameter("p1").charAt(0) == 'a')
                acertos++;
            if (req.getParameter("p2") != null &&req.getParameter("p2").charAt(0) == 'c')
                acertos++;
            if (req.getParameter("p3") != null &&req.getParameter("p3").charAt(0) == 'd')
                acertos++;
            
            if (acertos == 0){   
                out.println("<p>Que pena. Você não acertou nenhuma. " 
                        +"Estude mais para a próxima vez.</p>");
            } else{   
                out.println("<p>Você acertou " + acertos +" resposta(s).</p>");
            }
        }
            
        out.println("<a href=\"quiz\">Responder de novo</a>");
        out.println("</body>");
        out.println("</html>");
        sessao.invalidate(); //destrói a sessão ativa
        
        
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
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
}
