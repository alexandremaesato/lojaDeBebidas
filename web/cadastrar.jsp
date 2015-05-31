<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Loja Bebidas</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
<link rel="stylesheet" type="text/css" href="style.css" />
<!--[if IE 6]>
<link rel="stylesheet" type="text/css" href="iecss.css" />
<![endif]-->
<script type="text/javascript" src="js/boxOver.js"></script>

<script>
$(function() {
    $( "#datepicker" ).datepicker({
                                    dateFormat: 'dd-mm-yy',
                                    dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],
                                    dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
                                    dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
                                    monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
                                    monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
                                    nextText: 'Próximo',
                                    prevText: 'Anterior',
                                    defaultDate: -10000,
                                    changeMonth: true,
                                    changeYear: true,
                                    minDate:'-16570',
                                    maxDate:'-6570'
                            });
  });	
	
	

</script>
<script src="js/valida_form.js"></script>

</head>

    <%-- <jsp:useBean id="menu" class="pacote.Controle" scope="session" /> --%>


<c:set var="tipo" value="${sessionScope.tipo}" />




<body>
   
<div id="main_container">
    <c:import url="header.jsp" />
  <div id="main_content">
    <div id="menu_tab">
        <ul class="menu">   
        <c:import url="menuTop.jsp" />
        </ul>
    </div>
    <!-- end of menu tab -->
    <div class="crumb_navigation"> Navigation: <span class="current">Home</span> </div>
    
   <div class="center_content">
           <table class="contact_form">
        <h1>Cadastrar</h1>
         <form action="servletLogar?action=gravar" method="POST" onsubmit="return validate_form(this);" >  
            <tr><td></br>Nome: <td><input type="text" name="nome" value=""/></td></td></tr>
            <td></br>Login: <td><input type="text" id="login" name="login" value="" onchange='testeLogin(getElementById("login"))' /><td><div name="loginres" id="loginres"></div></td></td></td></tr>
            <tr><td></br>Senha:<td><input type="password" name="senha" value=""/></td></td></tr>
            <tr><td></br>Repita senha:<td><input type="password" name="senha2" value=""/></td></td></tr>
            <tr><td></br>Data Nascimento: <td><input id="datepicker" type="text" name="data" size="10"></td></tr>
            <tr><td></br>Sexo:
                <td><SELECT NAME = "sexo">
                    <OPTION value="masculino">Masculino </option>
                    <OPTION value="feminino">Feminino </option>
                </SELECT>
                </td></tr>
            <tr><td></br>CPF:<td><input id="cpf" type="text" name="cpf" onchange='testeCpf(getElementById("cpf"))' /><td><div id="cpfres"></div></td></td></tr>
            <tr><td></br>Email:<td><input type="text" name="email" value=""/></td></tr>
            <tr><td></br>Telefone:<td><input type="text" name="telefone" onkeypress="mascara(this, '## ####-####')" maxlength="12"/></td></td></tr>
            <tr><td></br>Celular:<td><input type="text" name="celular" onkeypress="mascara(this, '## #####-####')" maxlength="13"/></td></td></tr>
            
            </br>
            <tr><td></br>Cep: <td><input type="text" id="cep"  name="cep"  onblur="atualizacep(this.value)" maxlength="9"/></td></td></tr>
            <tr><td></br>Endereço: <td><input type="text" name="rua" id="rua" value=""/></td></td></tr>
            <tr><td></br>Número: <td><input type="text" name="numero" value=""/></td></td></tr>
            <tr><td></br>Bairro:<td> <input type="text" id="bairro" name="bairro" value=""/></td></td></tr>
            <tr><td></br>Cidade:<td> 
                    <select name="cidade">
                        <c:forEach var="c" items="${cidades}">
                            <option value="${c}"><c:out value="${c}"/></option></br>
                    </c:forEach>
                    </select>    
                    </td></td></tr>
            <tr><td></br>Complemento: <td><input type="text" name="complemento" value=""/></td></td></tr>
            <tr><td></br><td><input class="botao" type="submit" value="Ok"></td></td></tr>
        </form>
    </table>
</div>
  </div>
  <!-- end of main content -->
  <c:import url="footer.jsp" />
</div>
<!-- end of main_container -->

</body>
</html>


