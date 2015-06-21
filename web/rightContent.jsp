<%-- 
    Document   : rightContentTest
    Created on : 05/05/2015, 12:37:36
    Author     : Alexandre
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="right_content">
    <div class="title_box">Login</div>
    <div class="border_box">
        <c:import url="Login.jsp" />
    </div>
        <c:if test="${not empty sessionScope.cliente.nome}">
            <c:import url="carrinho.jsp" />
            
        </c:if>
      <div class="banner_adds"> <a href="#"><img src="images/bann1.jpg" alt="" border="0" /></a> </div>
    </div>
