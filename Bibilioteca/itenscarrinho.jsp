<%-- 
    Document   : itenscarrinho
    Created on : 30/03/2020, 16:41:36
    Author     : dryro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livraria</title>
    </head>
    <body>
        <h3>Carrinho de compras - itens adicionados</h3>
        <%@ page import="javax.servlet.http.*" %>
        
        <table>
        <%
            Cookie cookies[];
            
            if(request.getCookies() != null){
                cookies = request.getCookies();
                int i = 0;
                
                while(i < cookies.length){
                    out.println("<tr>");
                    
                    if(cookies[i].getName().equals("1")){
                        out.println("<td>Eclipse</td>");
                        out.println("<td>19,90</td>");
                        out.println("<td>" + cookies[i].getValue() + "</td>");
                    } else if(cookies[i].getName().equals("2")){
                        out.println("<td>O caçador de pipas</td>");
                        out.println("<td>23,00</td>");
                        out.println("<td>" + cookies[i].getValue() + "</td>");
                    } else if(cookies[i].getName().equals("3")){
                        out.println("<td>O vendedor de sonhos</td>");
                        out.println("<td>14,90</td>");
                        out.println("<td>" + cookies[i].getValue() +"</td>");
                    }
                    
                    out.println("</tr>");
                    i++;
                }
            }
        %>
        </table>
        <br>
        <a href="vitrine.jsp">Continuar comprando</a>
    </body>
</html>
