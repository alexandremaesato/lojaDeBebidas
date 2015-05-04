<%-- 
    Document   : Cadastrar
    Created on : May 4, 2015, 11:03:21 AM
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <script src="funcoes.js"></script>
            <title>Loja de Bebidas</title>	
            <link rel="stylesheet" href="nome.css">
            <script src="jquery.js"></script>
            <script src="jquery-ui.js"></script>
            <script>
                    $(function() {
                    $( "#datepicker" ).datepicker();
                    });
            </script>
    </head>
    <body>
        <table>
            <h1>Cadastrar</h1>
            <form action="servletCadastrar" method="POST" onsubmit="return validacadastroentrada(this);" >  
                <tr><td>Nome: <input type="text" name="nome" value=""/></td></tr>
                <tr><td>Login: <input type="text" name="login" value=""/></td></tr>
                <tr><td>Senha:<input type="text" name="senha" value=""/></td></tr>
                <tr><td>Data Nascimento: </td><td><input id="datepicker" type="date" name="data" size="15"></td></tr>
                <tr><td>Sexo:</td><td>
                    <SELECT NAME = "sexo">
                    <OPTION>feminino
                    <OPTION>masculino
                    </SELECT>
                    </td></tr>
                <tr><td>CPF:<input type="text" name="cpf" value=""/></td></tr>
                <tr><td>Email:<input type="text" name="email" value=""/></td></tr>
                <tr><td>Telefone:<input type="text" name="telefone" value=""/></td></tr>
                <tr><td>Celular:<input type="text" name="celular" value=""/></td></tr>
                <tr><td><input type="submit" value="Ok"></td></tr>
            </form>
        </table>
    </body>
</html>
