<%-- 
    Document   : vitrine
    Created on : 27/03/2020, 20:17:40
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
        <h3>Vitrine</h3>
        <%@ page import="javax.servlet.http.*" %>
        
        <%
            HttpSession sessao = request.getSession();
            
            if(sessao.getAttribute("logado") != null){ //abrindo primeiro if
                if(sessao.getAttribute("logado").equals("true")){ //abrindo segundo if                    
        %>
        
                    <p>Olá, <%= sessao.getAttribute("usuario") %>! Seja bem-vindo!</p>
                    
        <%
                //fechando segundo if 
                } else { //abrindo 
        %>
        
                    <p>Olá, visitante! Seja bem-vindo!</p>
        
        <%
                }//fechando else
            } else { //fechando primeiro if e abrindo else
        %>
        
                <p>Olá, visitante! Seja bem-vindo!</p> 
        
        <%  }//fechando else %>
        
        <table>
            <tr>
                <td>
                    <img src="imagens/eclipse.jpg" style="width: 200px;"><br>
                    Eclipse<br>19,90<br>Comprar
                </td>                        
                <td>
                    <img src="imagens/cacador_pipas.jpg" style="width: 198px;"><br>
                    O caçador de pipas<br>23,00<br>Comprar             
                </td>                        
                <td><img src="imagens/vendedor_sonhos.jpg" style="width: 200px;"><br>
                    O vendedor de sonhos<br>14,90<br>Comprar
                </td>
            </tr>   
        </table>
        
        <br>
        <a href="login.jsp">Página principal</a>
        
    </body>
</html>
