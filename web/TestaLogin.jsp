<%-- 
    Document   : TestaLogin
    Created on : May 1, 2015, 12:56:38 PM
    Author     : Alexandre
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

        
         <jsp:useBean id="p" class="pacote.Cliente" />
         <c:if test="${not empty sessionScope.p}"
        Nome: <jsp:getProperty name="cliente" property="nome" /><br/>  
 
