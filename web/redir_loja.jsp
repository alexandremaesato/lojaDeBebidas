<%-- 
    Document   : redir_loja
    Created on : May 8, 2015, 11:00:05 AM
    Author     : hednisk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:set var="redir" value="loja" scope="session" />    
<!redireciona p index!!!>
<c:redirect url="/index.jsp"/>
