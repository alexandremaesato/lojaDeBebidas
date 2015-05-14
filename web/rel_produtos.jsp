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
<h3>Produto mais vendido em um período do ano especificado:</h3><br/>
Escolha o período: <input type="text" size="8"/> a <input type="text" size="8"/>
					<table>
					<tr>	
							<td> Produto mais vendido em -data- a -data-: </td> 
							<td> produto</td>
					</tr>
					
					</table>
					<br />
<h3>Compras efetivadas em um determinado período:</h3><br/>
Escolha o período: <input type="text" size="8"/> a <input type="text" size="8"/>
<table>
					<tr>	
							<td> Produto 1 </td> 
							<td> preço ...</td>
					</tr>
					<tr>
							<td> Produto 2</td> 
							<td> preço ... </td> 
					</tr>
					</table>
					
</div>
