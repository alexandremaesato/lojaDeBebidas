<%-- 
    Document   : centerContentTeste
    Created on : 05/05/2015, 12:35:40
    Author     : Alexandre
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="center_content">
    <form action="servletProduto?action=listaprod" method="POST" onsubmit="return validacadastroentrada(this);" >  
        <h2>Categoria: 

            <SELECT NAME = "cat" id="cat">
                <option value="todos" selected>Todas Categorias</option>
                <c:forEach var="l" items="${lista}">
                    <option value="${l.idCategoria}"><c:out value="${l.nome}"/></option></br>
                </c:forEach>
            </SELECT></h2>
        <h2>Ordernar por: 

            <SELECT NAME = "ordem" id="ordem">
                <OPTION value="nome ASC;">ordem alfabética ascendente
                <OPTION value="nome DESC; ">ordem alfabética descendente
                <OPTION value="valor DESC;">preço descendente
                <OPTION value="valor ASC;">preço ascendente
            </SELECT></h2>
        <input type="submit" value="Ok">
    </form>
    </br></br>	
    <!-- Start of Main Content Area -->
    <div id="main_content">
        <div class="h_divider">&nbsp;</div>
        <!-- Start Left Sub Item -->
        <div class="sub_left">

            <c:forEach var="p" items="${produtos}">
                <div class="sub_items_header">
                    <h1><c:out value="${p.nome}"/></h1>
                    <h2><c:out value="${p.descricao}"/></h2>
                </div>                          
                <div class="sub_items_image"> <img src="<c:url value="${p.imagem}"/>" width="167" height="164" alt="Sub Item Name" /> </div>
                <div class="sub_items_text">
                    <p><c:out value="${p.descricao}"/></p>
                    <p> <strong> Quantidade em estoque <br />
                            <c:out value="${p.quantidade}"/> </strong> </p>
                </div>
                <div class="sub_items_cartinfo">
                    <div class="price">
                        <h2><c:out value="${p.valor}"/>R$</h2>
                    </div>
                    <div class="addtocart"> <a href="#"><span>Add to Cart</span></a> </div>
                    <div class="clearthis">&nbsp;</div>
                </div>
                <div class="h_divider">&nbsp;</div>

                </br></c:forEach>


        </div>


    </div>
</div>