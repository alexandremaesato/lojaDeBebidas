<%-- 
    Document   : Cadastrar
    Created on : May 15, 2015, 10:52:50 AM
    Author     : hednisk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="center_content">

 <table>
            <h1>Cadastrar</h1>
            <form action="servletCadastrar" method="POST" onsubmit="return validacadastroentrada(this);" >  
                <tr><td>Nome: <input type="text" name="nome" value=""/></td></tr>
                <tr><td>Login: <input type="text" name="login" value=""/></td></tr>
                <tr><td>Senha:<input type="text" name="senha" value=""/></td></tr>
                <tr><td>Data Nascimento: </td><td><input id="datepicker" type="date" name="data" size="15"></td></tr>
                <tr><td>Sexo:</td><td>
                    <SELECT NAME = "sexo" value="feminino">
                    <OPTION value='f'>feminino
                    <OPTION value='f'>masculino
                    </SELECT>
                    </td></tr>
                <tr><td>CPF:<input type="text" name="cpf" value=""/></td></tr>
                <tr><td>Email:<input type="text" name="email" value=""/></td></tr>
                <tr><td>Telefone:<input type="text" name="telefone" value=""/></td></tr>
                <tr><td>Celular:<input type="text" name="celular" value=""/></td></tr>
                <tr><td><input type="submit" value="Ok"></td></tr>
            </form>
        </table>
</div>