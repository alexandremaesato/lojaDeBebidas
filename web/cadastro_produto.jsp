<%-- 
    Document   : cadastro_produto
    Created on : May 13, 2015, 3:44:33 PM
    Author     : Ina
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<c:set var="valor" value="1000000" />  
<fmt:setLocale value="pt-BR" /> 
<%@page import="java.util.List"%>
<%@page import="pacote.Categoria"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="js/valida_form.js"></script>
<div class="center_content">
    <table border=0 style="margin:30; margin-top:30" >
        <tr>

            <td>
                <h1 >Cadastre um novo Produto</h1></br>

                <form action="servletProduto?action=cadastrap" method="POST" onsubmit="return validacadastroentrada(this);" enctype="multipart/form-data" >	
                    <table>		
                        <tr>	<td> Produto: </td>
                            <td>
                                <input type="text" name="produto"/>
                            </td>
                        </tr>
                        <tr>	<td> Categoria:</td>
                            <td>
                                <SELECT NAME = "cat">
                                    <c:forEach var="l" items="${lista}">
                                        <option value="${l.idCategoria}"><c:out value="${l.nome}"/></option></br>
                                    </c:forEach>
                                </SELECT>
                            </td>
                        </tr>
                        <tr>	<td> Selecione uma Imagem: </td>
                            <td>
                                <input type="file" name="arq"/>
                                <input type="hidden" value="C:\Users\Alexandre\Google Drive\PROJETOS JAVA\LojaDeBebidas_TESTES\web\images" name="destino"/>

                            </td>
                        </tr>
                        <tr>	<td> Descri&ccedilao: </td>
                            <td>
                                <input type="text" name="descr"/>
                            </td>
                        </tr>
                        <tr>	<td> Valor unit&aacuterio: </td>
                            <td>
                                <input id="valor" type="text" name="valor" onblur='replaceString(this)'/>  
                            </td>
                        </tr>
                        <tr>	<td> Quantidade em estoque: </td>
                            <td>
                                <input type="text" name="qtd"/>
                            </td>
                        </tr>
                        <tr>	<td colspan=2><input type="submit" value="Cadastrar!"></td></tr>
                    </table>
                </form>

            </td>
        </tr>		
    </table>
</div>