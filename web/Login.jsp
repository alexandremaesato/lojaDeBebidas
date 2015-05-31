<%-- 
    Document   : Cadastro
    Created on : May 1, 2015, 12:29:22 PM
    Author     : Alexandre
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

       
       <%-- Verificar se esta logado --%>
    <jsp:useBean id="cliente" class="pacote.Cliente" scope="session"/>
    
    <c:choose>
        <c:when test="${not empty sessionScope.nome}">
           ${sessionScope.nome}</br>
            <a href="logout.jsp">Deslogar</a>
        </c:when>
        <c:otherwise>
            <form action="servletLogar?action=logar" method=POST>  
                Login:  <input type=text name=login  /><br/>
                Senha:   <input type=password name=senha /><br/>
                <input class="botao" type="submit" value="Ok" /><br/>
                <c:set var="centerContent" value="${body.centerContent('cadastrar')}" /><br/>
                <input class="botao" type="submit" formmethod="post" formaction="servletLogar?action=cadastrar" value="Cadastrar">     
            </form>
       </c:otherwise>    
    </c:choose>
       
      
  
 
