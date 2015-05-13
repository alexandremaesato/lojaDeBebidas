<%-- 
    Document   : cadastro_categoria
    Created on : May 13, 2015, 3:43:59 PM
    Author     : Ina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="center_content">
		<table border=0 style="margin:30; margin-top:30" >
			<tr>
				<td> 
 					
				
				<h1 >Cadastre uma nova Categoria</h1></br>
					
				    <form method="post" onsubmit="return validacadastroentrada(this);">	
					<table>
						<tr>	<td>	Categoria: </td><td><input type="text" name="categoria" size="30"></td></tr>
						
	
						<tr>	<td> Produtos: </td>
							<td>
							<SELECT NAME = "produto">
							<OPTION>prod1
							<OPTION>prod2
							</SELECT>
							</td>
						</tr>
						<tr>	<td colspan=2><input type="submit" value="Cadastrar!"></td></tr>
					</table>
				    </form>
				
				</td>
			</tr>		
		</table>
</div>