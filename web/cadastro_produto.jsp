<%-- 
    Document   : cadastro_produto
    Created on : May 13, 2015, 3:44:33 PM
    Author     : Ina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="center_content">
		<table border=0 style="margin:30; margin-top:30" >
			<tr>
				<td>
				<h1 >Cadastre um novo Produto</h1></br>
					
				    <form method="post" onsubmit="return validacadastroentrada(this);">	
					<table>		
						<tr>	<td> Produto: </td>
							<td>
							<input type="text"/>
							</td>
						</tr>
						<tr>	<td> Categoria:</td>
							<td>
							<SELECT NAME = "produto">
							<OPTION>cat1
							<OPTION>cat2
							</SELECT>
							</td>
						</tr>
						<tr>	<td> Imagem: </td>
							<td>
							<input type="img"/>
							</td>
						</tr>
						<tr>	<td> Descri&ccedilao: </td>
							<td>
							<input type="text"/>
							</td>
						</tr>
						<tr>	<td> Valor unit&aacuterio: </td>
							<td>
							<input type="text"/>
							</td>
						</tr>
						<tr>	<td> Quantidade em estoque: </td>
							<td>
							<input type="text"/>
							</td>
						</tr>
						<tr>	<td colspan=2><input type="submit" value="Cadastrar!"></td></tr>
					</table>
				    </form>
				
				</td>
			</tr>		
		</table>
</div>