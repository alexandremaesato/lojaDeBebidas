<%-- 
    Document   : carrinhoCompleto
    Created on : Jun 3, 2015, 7:39:44 PM
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <fmt:setLocale value="pt-BR" />
    <script type="text/javascript" src="js/valida_form.js"></script>
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <c:set var="total" value="${total}" />
    <!DOCTYPE html>
    <body>
        <div class="center_content">
            <div id="main_content">
                <div class="center_title_bar">Carrinho de Compras</div>
                    <form >
                <c:forEach var="produtos" items="${ListaProdutos}" begin="0" varStatus="i">
                    <div class="prod_box_big">
                        <div class="center_prod_box_big">
                            <div class="product_img_big"> <img src="${produtos.descricao}" alt="" border="0" />

                            </div>
                            <div class="details_big_box">
                                <div class="product_title_big">${produtos.nome}</div>
                                <div class="specifications"> Estoque: <span class="blue">${produtos.estoque.quantidade}</span><br />
                                    Descrição :<span class="blue">${produtos.descricao}  ${produtos.categoria.nome}</span><br />
                                    Quantidade: <input id="quantidade${i.index}" type="text"  min="1" max="20" onchange="atualizaValorQuantidade(${i.index})" onblur="getValorTotal()"  value="${produtos.quantidade}" size="1" ></br>
                                        <div class="prod_price">Valor Unitario: <span id="valor${i.index}" class="price">${produtos.valor}</span></div> 
                                        <div class="prod_price_big">Subtotal: R$<span  class="price" ></span> <input type="text" id="subvalor${i.index}" size="5"  /></div>
                                        <div id="" hidden="" type=""></div>
                                </div>
                                <a href="servletCarrinhoCompleto?action=delete&idProduto=${produtos.idProduto}&idCarrinho=${carrinho.idCarrinho}" class="prod_buy">Remover</a></div>
                        </div>
                    </div>
                        <script>atualizaValorQuantidade(${i.index});
                        subvalor${i.index};
                        </script>                 
                </c:forEach> 
                <div class="prod_box_big">
                    <div class="center_prod_box_big">
                        <div class="product_title">
                            <div class="prod_price_big" id="total">Valor Total: <fmt:formatNumber value="${total}" type="currency"/></div>
                        </div>
                    </div>
                </div>
                            
                </form>
                
            </div>
        </div>
    </body >
</html>