<%-- 
    Document   : leftContentTest
    Created on : 05/05/2015, 12:31:39
    Author     : Alexandre
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="ord" value="nome DESC;"/>
<!DOCTYPE html>
<div class="left_content">
      <div class="title_box">Categorias</div>
      <ul class="left_menu">
          <c:forEach var="l" items="${lista}"> 
              <li class="even"><a href="servletCategoria?action=buscamenuleft&id=${l.idCategoria}&ordem=nenhum" formmethod="post" ><c:out value="${l.nome}"/></a></li>
         </c:forEach>
      </ul>
    </div>
