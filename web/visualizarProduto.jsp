<%-- 
    Document   : centerContentTeste
    Created on : 05/05/2015, 12:35:40
    Author     : Alexandre
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="pt-BR" />  
<!DOCTYPE html>

<div class="center_content">
    <div class="center_title_bar"></div>
    <div class="prod_box_big">
        <div class="center_prod_box_big">
            <div class="product_img_big"> 
                <img src="${produto.imagem}" alt="" border="0">

            </div>
            <div class="details_big_box">
                <div class="product_title_big">${produto.nome}</div>
                <div class="specifications">Tipo: <span class="blue">${produto.categoria.nome}</span><br>
                    Envio: <span class="blue"> Motoboy</span><br>
                    Descrição :<span class="blue">${produto.descricao}</span><br>
                    
                </div>
                <div class="prod_price_big"><span class="price"><fmt:formatNumber value="${produto.valor}" type="currency"/></span></div>
                <form>
                <input  id="2" class="botao" type="submit" formaction="servletCarrinho?action=addNoCarrinho&id=${produto.idProduto}" formmethod="post"    value="Adicionar" />
                </form>
            </div>
        </div>
    </div>
</div>