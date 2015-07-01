<%-- 
    Document   : rel_produtos
    Created on : May 13, 2015, 3:48:09 PM
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
<h3>Produtos mais vendido em um período do ano especificado:</h3><br/>
<form action="servletCliente" method="POST" onsubmit="">

Escolha o período: <input type="text" name="di" size="8"/>(dd-mm-aaaa) a <input type="text" name="df"  size="8"/>(dd-mm-aaaa)
<Button type="submit" name="action" value="maisvend">Produtos mais Vendidos</button>

</form>
					
					<br />
<h3>Compras efetivadas em um determinado período:</h3><br/>
<form action="servletCliente" method="POST" onsubmit="">
Escolha o período: <input type="text" name="di" size="8"/>(dd-mm-aaaa) a <input type="text" name="df"  size="8"/>(dd-mm-aaaa)
<Button type="submit" name="action" value="pvendidos">Listar Produtos Vendidos</button>
</form>
					
</div>
