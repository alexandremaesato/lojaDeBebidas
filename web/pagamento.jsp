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
                <div class="center_title_bar">Pagamento</div>
                <form>
                    <div class="prod_box_big">
                        <div class="center_prod_box_big">
                            <div class="contact_form">
                                <h1>Dados Cadastrais</h1>

                                <table class="tableCompra">
                                    <tr><td>Nome: <td>${cliente.nome}</td></td></tr>
                                    <tr><td>Data Nascimento: <td>${cliente.dataNascimento}</td></tr>
                                    <tr><td>Sexo:<td>${cliente.sexo}</td></tr>
                                    <tr><td>CPF:<td>${cliente.cpf}<td><div id="cpfres"></div></td></td></tr>
                                    <tr><td>Email:<td>${cliente.email}</td></tr>
                                    <tr><td>Telefone:<td>${cliente.telefone}</td></td></tr>
                                    <tr><td>Celular:<td>${cliente.celular}</td></td></tr>

                                    </br>
                                    <tr><td>Cep: <td>${cliente.endereco.cep}</td></td></tr>
                                    <tr><td>Endereço: <td>${cliente.endereco.rua}</td></td></tr>
                                    <tr><td>Número: <td>${cliente.endereco.numero}</td></td></tr>
                                    <tr><td>Bairro:<td> ${cliente.endereco.bairro}</td></td></tr>
                                    <tr><td>Cidade:<td> ${cliente.endereco.cidade.cidade}</td></td></tr>
                                    <tr><td>Complemento: <td>${cliente.endereco.complemento}</td></td></tr>
                                </table>
                                </br>
                                <h1>Endereco de Entrega</h1>
                                <h3><td><tr>Endereco de entrega o mesmo do Cadastro</tr><tr><input id="checar" type="checkbox"  onclick="alteraCampos();"</tr></td></br></h3>
                                    <table class="tableCompra">
                                        <form action="servletPagamento?action=pagar" method="POST" onsubmit="return validate_form(this);" >   


                                            <tr><td>Cep: <td><input type="text" id="cepe"  name="cep"  onblur="atualizacep(this.value)"  maxlength="9"/></td></td></tr>
                                            <tr><td>Endereço: <td><input type="text" name="ruae" id="rua" value=""/></td></td></tr>
                                            <tr><td>Número: <td><input type="text" name="numeroe" value=""/></td></td></tr>
                                            <tr><td>Bairro:<td> <input type="text" id="bairroe" name="bairro" value=""/></td></td></tr>
                                            <tr><td>Cidade:<td> 
                                                        <select name="cidadee">
                                                            <c:forEach var="c" items="${cidades}">
                                                                <option value="${c.cidade}"><c:out value="${c.cidade}"/></option></br>
                                                            </c:forEach>
                                                        </select>    
                                                    </td></td></tr>
                                            <tr><td></br>Complemento: <td><input id="complementoe" type="text" name="complemento" value=""/></td></td></tr>

                                            <tr><td></br><td></td></td></tr>
                                    </table>

                                    </form>

                                    <div class="" id="stotal">Taxa de Entrega: <fmt:formatNumber value="10" type="currency"/></div>
                                    <div class="valorTotal" id="total">Valor Total: <fmt:formatNumber value="${carrinho.total+5}" type="currency"/></div>
                                    <div><input class="botao" formmethod="post" formaction="" type="submit" value="Pagar"></div>
                            </div>
                        </div>
                    </div>

                </form>

            </div>
        </div>
    </body >
</html>