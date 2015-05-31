<%-- 
    Document   : logout
    Created on : May 10, 2015, 8:07:17 PM
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%session.invalidate();%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sessao Finalizada</h1>
        <a href="index.jsp">Voltar</a>
    </body>
</html>
