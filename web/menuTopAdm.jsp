<%-- 
    Document   : menuTopAdm
    Created on : May 13, 2015, 3:38:44 PM
    Author     : Ina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

      <ul class="menu">
        <li><a href="servletProduto?action=pagina" formmethod="post" class="nav"> Home </a></li>
        <li class="divider"></li>
        <li><a href="redir_loja.jsp" class="nav">Nossa Loja</a></li>
        <li class="divider"></li>
        <li><a href="redirect_prod.jsp" class="nav">Produtos</a></li>
        <li class="divider"></li>
        <li><a href="redir_busca.jsp" class="nav">Busca Clientes</a></li>
        <li class="divider"></li>
         <li><a href="redir_cadastroCateg.jsp" class="nav">Cadastro de Categoria</a></li>
        <li class="divider"></li>
         <li><a href="servletCategoria?action=listacat" formmethod="post" class="nav">Cadastro de Produto</a></li>
        <li class="divider"></li>
         <li><a href="redir_ajuda.jsp" class="nav">Ajuda</a></li>
        <li class="divider"></li>
      </ul>
   