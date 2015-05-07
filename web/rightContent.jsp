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
    <div class="title_box">Procurar</div>
      <div class="border_box">
        <input type="text" name="newsletter" class="newsletter_input" value="palavra-chave"/>
        <a href="#" class="join">Busca</a> </div>
      <div class="shopping_cart">
        <div class="title_box">Carro de compras</div>
        <div class="cart_details"> 3 itens <br />
          <span class="border_cart"></span> Total: <span class="price">350R$</span> </div>
        <div class="cart_icon"><a href="#"><img src="images/shoppingcart.png" alt="" width="35" height="35" border="0" /></a></div>
      </div>
      
      
      <div class="banner_adds"> <a href="#"><img src="images/bann1.jpg" alt="" border="0" /></a> </div>
    </div>
