<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Adega Dos Deuses</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<!--[if IE 6]>
<link rel="stylesheet" type="text/css" href="iecss.css" />
<![endif]-->
<script type="text/javascript" src="js/boxOver.js"></script>
</head>

<body>
<div id="main_container">
    <c:import url="header.jsp" />
  <div id="main_content">
    <div id="menu_tab">
         <c:choose>
        <c:when test="${sessionScope.tipo eq '3'}">
      <c:import url="menuTopGer.jsp" />
       </c:when>
        <c:when test="${sessionScope.tipo eq '2'}">
      <c:import url="menuTopAdm.jsp" />
       </c:when>
        <c:otherwise>
                  <c:import url="menuTop.jsp" />
                  </c:otherwise>
      </c:choose>
    </div>
    <!-- end of menu tab -->
    <div class="crumb_navigation">Navegação: <span class="current">Home</span> </div>
    <c:import url="leftContent.jsp" />
    <!-- end of left content -->
   
    
    <c:choose>
       <%--
       ...
         --%>
        <c:when test="${sessionScope.redir eq 'produtos'}">
            <c:import url="produtos.jsp" />
       </c:when>
        <c:when test="${sessionScope.redir eq 'home'}">
            <c:import url="centerContent.jsp" />
       </c:when>
        <c:when test="${sessionScope.redir eq 'loja'}">
            <c:import url="quemsomos.jsp" />
       </c:when>
         <c:when test="${sessionScope.redir eq 'ajuda'}">
            <c:import url="#.jsp" />
       </c:when>
        <c:when test="${sessionScope.redir eq 'busca'}">
            <c:import url="pesquisacli.jsp" />
       </c:when>
        <c:when test="${sessionScope.redir eq 'cadastrocate'}">
            <c:import url="cadastro_categoria.jsp" />
       </c:when>
        <c:when test="${sessionScope.redir eq 'cadastroprod'}">
            <c:import url="cadastro_produto.jsp" />
       </c:when>
        <c:when test="${sessionScope.redir eq 'editarFun'}">
            <c:import url="pesquisaFunc.jsp" />
       </c:when>
        <c:when test="${sessionScope.redir eq 'relatorios'}">
            <c:import url="rel_cli.jsp" />
       </c:when>
         <c:when test="${sessionScope.redir eq 'relat5cli'}">
            <c:import url="rel_5cli.jsp" />
       </c:when>
         <c:when test="${sessionScope.redir eq 'relatFaturamento'}">
            <c:import url="rel_faturamento.jsp" />
       </c:when>
         <c:when test="${sessionScope.redir eq 'relatProdutos'}">
            <c:import url="rel_produtos.jsp" />
       </c:when>
        <c:when test="${sessionScope.redir eq 'cadastrocli'}">
            <c:import url="cadastrar.jsp" />
       </c:when>
        <c:when test="${sessionScope.redir eq 'carrinhoCompleto'}">
            <c:import url="carrinhoCompleto.jsp" />
        </c:when>
        
         <c:otherwise>
             <c:import url="centerContent.jsp" />
        </c:otherwise>
       
        
   </c:choose>
    
    <!-- end of center content -->
    <c:import url="rightContent.jsp" />
    <!-- end of right content -->
  </div>
  <!-- end of main content -->
  <c:import url="footer.jsp" />
</div>
<!-- end of main_container -->

</body>
</html>
