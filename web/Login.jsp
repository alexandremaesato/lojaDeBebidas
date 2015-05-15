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
            <form action="servletDeslogar" method=POST>  
                     <input type="submit" value="Deslogar" /><br/>
            </form>
       </c:when>
       
       
        <c:otherwise>
            <form action="servletLogar" method=POST>  
                Login:  <input type=text size="12" name=nome  /><br/>
                Senha:   <input type=text size="12" name=nome /><br/>
                <input type="submit" value="Ok" /><br/>
                <a href="redir_cadastrar.jsp">Cadastrar</a>
            </form>
       </c:otherwise>    

    </c:choose>
       
      
  
 
