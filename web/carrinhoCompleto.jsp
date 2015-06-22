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
    <c:set var="quantidade" value="${total}" />
    <!DOCTYPE html>
    <body>
        <div class="center_content">
            <div id="main_content">
                <div class="center_title_bar">Carrinho de Compras</div>
                <form >
                    <c:forEach var="lista" items="${carrinho.produtosCarrinho}" begin="0" varStatus="i">
                        <div class="prod_box_big">
                            <div class="center_prod_box_big">
                                <div class="product_img_big"> <img src="${lista.produto.imagem}" alt="" border="0" />

                                </div>
                                <div class="details_big_box">
                                    <div class="product_title_big">${lista.produto.nome}</div>
                                    <div class="specifications"> Estoque: <span class="blue">${lista.produto.estoque.quantidade}</span><br />
                                        Descrição :<span class="blue">${lista.produto.descricao}  ${lista.produto.categoria.nome}</span><br />
                                        Quantidade: <input id="quantidade${i.index}" type="text"  min="1" max="20".  value="${lista.quantidade}"  size="1" > 
                                            <input type="hidden" id="idProduto${i.index}" value="${lista.idProduto}" />
                                            <input type="hidden" id="idCarrinho${i.index}" value="${lista.idCarrinho}" />
                                            <input type="hidden" id="index" value="${i.index}" />
                                            <input type="hidden" id="idQuantidade${i.index}" value="${i.index}" />
                                            <input class="botao" type="button" onclick="alteraItemCarrinho('${i.index}')" value="Atualizar" />
                                            <div class="prod_price">Valor Unitario: <span id="valor${i.index}" class="price"><fmt:formatNumber value="${lista.produto.valor}" type="currency"/></span></div> 
                                            <div class="prod_price_big">Subtotal: <span  class="price" ></span> <fmt:formatNumber value="${lista.produto.valor * lista.quantidade}" type="currency"/></div>
                                            <div id="" hidden="" type=""></div>
                                    </div>
                                    <input class="botao" type="button" onclick="removeItemCarrinho('${i.index}')" value="remove" />        
                                </div>
                            </div>
                        </div>
                                      
                    </c:forEach> 
                    <div class="prod_box_big">
                        <div class="center_prod_box_big">
                            <div class="product_title">
                                <div class="prod_price_big" id="total">Valor Total: <fmt:formatNumber value="${carrinho.total}" type="currency"/></div>
                                <div><input class="button" type="button" onclick="" value="Finalizar Compra" /></div>
                            </div>
                        </div>
                    </div>

                </form>

            </div>
        </div>
    </body >
</html>