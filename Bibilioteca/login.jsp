<%-- 
    Document   : login
    Created on : 27/03/2020, 18:16:13
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
        <h3>Página Principal</h3>
        <%@ page import="javax.servlet.http.*" %>
        
        <%
            HttpSession sessao = request.getSession();
            
            if (sessao.getAttribute("logado") == null)    
                    sessao.setAttribute("logado", "false");
            if (sessao.isNew() || sessao.getAttribute("logado").equals("false")){ 
            //abrindo o if    
        %>
            
                <form action="sessionLogin" method="post">
                     Usuário: <input type="text" name="username"><br>
                     Senha: <input type="password" name="password" 
                                   style="margin-left: 11px;"><br><br>
                     <input type="submit" value="Entrar">
                </form>
        
        <%     
            //fechando o if
            } else { //abrindo o else     
        %>
        
                <h2>Olá, <%= session.getAttribute("usuario") %></h2>
                <a href="sessionLogin">Sair</a>
            
        <%  }  //fechando o else %>
        
        <br>
        <a href="vitrine.jsp">Navegar pela loja</a>
    </body>
</html>
