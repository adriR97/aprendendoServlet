<%-- 
    Document   : carrinho
    Created on : 30/03/2020, 16:36:25
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
        <h3>Carrinho de compras</h3>
        <%@ page import="javax.servlet.http.*" %>
        
        <%
            Cookie cookie;
            String codigo = "";
            
            codigo = request.getParameter("codigo");
            
            cookie = new Cookie(codigo, "1");
            response.addCookie(cookie);
        %>
        
        <p>Item adicionado no carrinho!</p>
        <a href="vitrine.jsp">Continuar comprando</a><br>
        <a href="itenscarrinho.jsp">Exibir carrinho</a>
    </body>
</html>
