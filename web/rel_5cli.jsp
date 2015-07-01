<%-- 
    Document   : rel_5cli
    Created on : May 13, 2015, 3:48:38 PM
    Author     : Ina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="center_content">
<br />
					<a href="redir_relatorios.jsp"> Relatório de Cliente</a>&nbsp;
					<a href="redir_produtos.jsp"> Relatório de Produtos</a>&nbsp;
					<a href="redir_faturamento.jsp"> Faturamento da loja</a>&nbsp;
					<a href="redir_cli5.jsp"> Clientes que mais compraram</a>
					<br /><br />
 <br/> 
<form action="servletCliente" method="POST" onsubmit="">
Escolha o período: <br/><input type="text" name="di" size="8"/>(dd-mm-aaaa) a <input type="text" name="df" size="8"/>(dd-mm-aaaa) <br/> <br/>
		<Button type="submit" name="action" value="maiscompraram">Listar Clientes que mais compraram</button>
</form>
</div>
