<%-- 
    Document   : carrinho
    Created on : May 31, 2015, 4:12:15 PM
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="pt-BR" /> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="shopping_cart">
        <div class="title_box">Carro de compras</div>
        
        <div class="cart_details">Items ${carrinho.quantidade}<br />
          <span class="border_cart"></span> Total: <span class="price"><fmt:formatNumber value="${carrinho.total}" minFractionDigits="2" type="currency"/></span> </div>
        <div class="cart_icon"><a href="redir_carrinhoCompleto.jsp"><img src="images/shoppingcart.png" alt="" width="35" height="35" border="0" /></a></div>
      </div> 
    </body>
</html>
