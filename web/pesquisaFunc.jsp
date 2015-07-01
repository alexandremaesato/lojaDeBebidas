<%-- 
    Document   : pesquisaFunc
    Created on : May 13, 2015, 3:45:20 PM
    Author     : Ina
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="js/valida.js"></script>
<!DOCTYPE html>
<div class="center_content">
    
   <br/>
    <form action="servletFuncionario?action=pesquisa" method="POST" onsubmit="">	
        <h4>CPF: <input type="text" name="cpf" size="12">     Palavra chave: <input type="text" name="palavra" size="15"> <input type="submit" value="Pesquisar"></h4>
    </form>
    <br /><br />
    
    <table>
        <tr>		<th>  </th>
            <th> CPF</th> <th> </th> 
            <th> Nome</th> <th> </th> 
            <th> Email </th> 
            <th> Login </th> 
        </tr>
        <c:forEach var="l" items="${listafunc}">
        <tr>		<td> <input type="radio"  name="t" onclick="AnEventHasOccurred()" value="${l.cpf}"> </td>
            <td>  ${l.cpf}</td>  <td>  </td> 
            <td> ${l.nome}<input type="hidden"  name="nome" value="${l.nome}"></td>  <td>  </td> 
            <td> ${l.email}<input type="hidden"  name="mail" value="${l.email}"></td> 
            <td>${l.login}<input type="hidden"  name="login" value="${l.login}"></td>
            <input type="hidden"  name="tipo" value="${l.tipo}"><input type="hidden"  name="sexo" value="${l.sexo}">
            
        </tr>
        </c:forEach>
    </table>

    
    <br /><br />
    <form action="servletFuncionario?action=cadastra" method="POST" onsubmit="return validaFunc(this);">
        <table border=0 >
            <tr>	<td>    Nome Completo: </td><td><input type="text" id="nome" name="nome1" size="40"></td></tr>
            <tr>	<td>	CPF: </td><td><input type="text" id="cpf" name="cpf1" size="11"></td></tr>
            <tr>	<td>	Email:</td><td> <input type="text" id="email" name="email1" size="40"></td></tr>
            <tr>	<td>    Sexo: </td>
                <td>
                    <SELECT NAME = "sexo1"id="sexo">
                        <OPTION >
                        <OPTION value="feminino">feminino
                        <OPTION value="masculino">masculino
                    </SELECT>
                </td>
            </tr>
            <tr>	<td> Tipo: </td>
                <td>
                    <SELECT NAME = "tipo1"id="tipo">
                         <OPTION >
                        <OPTION value="2">Administrador
                        <OPTION value="3">Gerente
                    </SELECT>
                </td>
            </tr>
            <tr>	<td>    Login: </td><td><input type="text" id="login" name="login1" size="40"></td></tr>
            <tr>	<td>    Senha: </td><td><input type="text" id="senha" name="senha1" size="40"></td></tr>
        </table><br/>
        <input type="submit" value="Cadastrar/Alterar">
    
    </form><br />
    <form action="servletFuncionario?action=remove" method="POST" onsubmit="return validaCpf(this);">
        <input type="hidden"  id="cpf1" name="cpf">
    <input type="submit" value="Remover">
    </form>
</div>
