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
        <c:when test="${not empty sessionScope.cliente.nome}">
           ${sessionScope.cliente.nome}</br>
           <form action="servletLogar?action=deslogar&login=${sessionScope.cliente.login}" method="post">
                
                <input class="botao" type="submit" value="Deslogar" /><br/>
           </form>     
        </c:when>
           <c:when test="${not empty sessionScope.funcio.nome}">
           ${sessionScope.cliente.nome}</br>
           <form action="servletLogar?action=deslogarF&login=${sessionScope.funcio.login}" method="post">
                
                <input class="botao" type="submit" value="Deslogar" /><br/>
           </form>     
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
       
      
  
 
