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
<style>

    .gallery.custom-state-active { background: #eee; }
    .gallery div { float: left; width: 156px; padding: 0.9em; margin: 0 0.4em 0.4em 0; text-align: center; }
    .gallery div h5 { margin: 0 0 0.4em; cursor: move; }
    .gallery div a { float: right; }
    .gallery div a.ui-icon-zoomin { float: left; }
    .gallery div img { width: 50%; cursor: move; height: 50% }
    .galery ul { width: 800px}

</style>
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
            <div class="ui-widget ui-helper-clearfix">
                <ul id="gallery" class="gallery ui-helper-reset ui-helper-clearfix">
                    <c:forEach var="p" items="${produtos}">
                        <form action="" method="post">
                            <div class="center_prod_box gallery">
                                <h5 class="ui-widget-header">${p.nome}</h5>
                                <img  src="${p.imagem}" alt="The peaks of High Tatras" width="96" height="72">

                                
                                        <h2><fmt:formatNumber value="${p.valor}" type="currency"/></h2>
                                        <div class="prod_details_tab"> 
                                            <input type="hidden" value="${p.idProduto}"/>
                                            <input  id="visualizar" class="botao" type="submit" formaction="servletProduto?action=visualizarProduto&id=${p.idProduto}" formmethod="post"    value="Visualizar" />
                                             
                                            <input  id="2" class="botao" type="submit" formaction="servletCarrinho?action=addNoCarrinho&id=${p.idProduto}" formmethod="post"    value="Adicionar" />
                                        </div>
                            </div>
                        </form>
                    </c:forEach>

                </ul>
            </div>


        </div>


    </div>
</div>