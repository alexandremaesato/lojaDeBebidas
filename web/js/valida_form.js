	function validate_form(formulario) {
	if (formulario.nome.value == "")
		{
			alert("Campo nome Obrigatório!");
			return false;
		}
		
	if ($("#loginres").text() !== "Ok"){
            alert("Login já existente!");
            return false;
        }    			
	
        if (formulario.login.value.length < 5)
		{
			alert("Seu login precisa ter mais de 5 caracteres!");
			return false;
		}
	
        if (formulario.login.value == "")
		{
			alert("Campo login Obrigatório!");
			return false;
		}
        
             
		
				
	if (formulario.nome.value.length < 5)
		{
			alert("Seu nome precisa ter mais de 5 caracteres!");
			return false;
		}
	
	if (formulario.senha.value.length < 6)
		{
			alert("Senha precisa ter pelo menos 6 caracteres");
			return false;
		}	
	if (formulario.senha.value != formulario.senha2.value)
		{
			alert("Senhas Diferentes");
			return false;
		}
		
	if (TestaCPF(formulario.cpf.value)==false)
		{
			alert("CPF Invalido");
			return false;
		}
        if ($("#cpfres").text() !== "Ok"){
            alert("CPF já existente!");
            return false;
        }        
	
	if (formulario.endereco.value == null || formulario.endereco.value.length == "")	
		{
			alert("Falta Endereco");
			return false;
		}
	
	if (validaEmail(formulario.email.value)== false)
		{
			alert("Email Invalido");
			return false;
		}
	if (formulario.descricao.value.length > 300)
		{
			alert("Descricao passou de 100 caracteres");
			return false;
		}
			
	

	else 
		{
		return true; // submete
		}
	}



function Verifica_Hora(campo)
{
 var vCampo = campo.value;
 if (vCampo.length == 5 && vCampo.substring(2,3) == ":" )
 {
  var retorno = false;
  var Hora = parseInt(vCampo.substring(0,2));
  var Minuto = parseInt(vCampo.substring(3,5));
  retorno = ((Hora >=0 && Hora <=23) && (Minuto >=0 && Minuto <=59) ) ;
  if (!retorno)
  {
   alert("Hora inválida");
   campo.value = "";
  }
 }
 else
 {
  alert("Hora inválida");
  campo.value = "";
 }
}


	function VerificaData(digData) 
{
	var bissexto = 0;
	var data = digData; 
	var tam = data.length;
	if (tam == 10) 
	{
		var dia = data.substr(0,2)
		var mes = data.substr(3,2)
		var ano = data.substr(6,4)
		if ((ano > 1900)||(ano < 2100))
		{
			switch (mes) 
			{
				case '01':
				case '03':
				case '05':
				case '07':
				case '08':
				case '10':
				case '12':
					if  (dia <= 31) 
					{
						return true;
					}
					break
				
				case '04':		
				case '06':
				case '09':
				case '11':
					if  (dia <= 30) 
					{
						return true;
					}
					break
				case '02':
					/* Validando ano Bissexto / fevereiro / dia */ 
					if ((ano % 4 == 0) || (ano % 100 == 0) || (ano % 400 == 0)) 
					{ 
						bissexto = 1; 
					} 
					if ((bissexto == 1) && (dia <= 29)) 
					{ 
						return true;				 
					} 
					if ((bissexto != 1) && (dia <= 28)) 
					{ 
						return true; 
					}			
					break						
			}
		}
	}	
	alert("A Data "+data+" é inválida!");
	return false;
}


	function TestaCPF(strCPF) { 
	var Soma; 
	var Resto; 
	Soma = 0; 
	if (strCPF == "00000000000") 
		return false; 
	for (i=1; i<=9; i++) 
		Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (11 - i); 
		Resto = (Soma * 10) % 11; if ((Resto == 10) || (Resto == 11)) Resto = 0; 
		if (Resto != parseInt(strCPF.substring(9, 10)) ) 
		return false; 
		Soma = 0; 
		for (i = 1; i <= 10; i++) Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (12 - i); 
		Resto = (Soma * 10) % 11; 
		if ((Resto == 10) || (Resto == 11)) Resto = 0; 
		if (Resto != parseInt(strCPF.substring(10, 11) ) ) 
			return false; return true; } 
	var strCPF = "12345678909"; 
	//alert(TestaCPF(strCPF));



	function validaEmail(email){
    var str = email;
    var filtro = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    if(filtro.test(str)) {
        return true;
    } else {
        return false;
    }
}




function validate_form_casamento(formulario) {
	if (formulario.datepicker.value == null || formulario.datepicker.value.length == "")
		{
			alert("Data do casamento faltando");
			return false;
		}
	
	
	if (Verifica_Hora(formulario.hora)==false)
	{
		return false;
	}
		
	
	if (formulario.conjuge.value == null || formulario.conjuge.value.length == "")
		{
			alert("Nome do Conjuge é obrigatório.");
			return false
		}
	
	if (formulario.numeroconvidados.value == "" || formulario.numeroconvidados.value == null ){
		alert("Numero de convidados é obrigadório.");
		return false;}
		
	if (formulario.igreja.value == ""){
		alert("Nome da igreja é obrigatório.");
		return false;}
	
	if (formulario.padrinho1.value == ""){
		alert("É preciso colocar pelo menos um casal de padrinhos.");
		return false;}
	else
	{
		return true;
	}
	
}

function valida_busca_cliente(formulario){
			
	if (formulario.nome.value == "")
		{
			alert("Campo nome Obrigatório!");
			return false;
		}
		
				
	if (formulario.nome.value.length < 5)
		{
			alert("Seu nome precisa ter mais de 5 caracteres!");
			return false;
		}
	
	if (formulario.from.value == null || formulario.from.value == "" || formulario.to.value == null || formulario.to.value == "")
		{
			alert("Data invalida!");
			return false;
		}
}

function cpft(a){
if (TestaCPF(a.value)==false)
		{
			alert("CPF Invalido");
			return false;
		}
}

function mascara(t, mask){
     var i = t.value.length;
     var saida = mask.substring(1,0);
     var texto = mask.substring(i)
     if (texto.substring(0,1) != saida){
     t.value += texto.substring(0,1);
     }
 }
 
 function testeCpf() {
                var page = "servletAjaxCadastro?acao=cpf&cpf="+cpf.value;
                $.post(page, function(responseText) { // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
                $('#cpfres').text(responseText);         // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
                });
}

function testeLogin() {
                var page = "servletAjaxCadastro?acao=login&login="+login.value;
                $.post(page, function(responseText) { // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
                $('#loginres').text(responseText);         // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
                });
}

function atualizacep(cep){
      cep = cep.replace(/\D/g,"");
      url="http://cep.correiocontrol.com.br/"+cep+".js";
      s=document.createElement('script');
      s.setAttribute('charset','utf-8');
      s.src=url;
      document.querySelector('head').appendChild(s);
    }

    function correiocontrolcep(valor){
      if (valor.erro) {
        alert('Cep não encontrado');
        return;
      };
      document.getElementById('rua').value=valor.logradouro;
      document.getElementById('bairro').value=valor.bairro;
      //document.getElementById('localidade').value=valor.localidade;
      //document.getElementById('uf').value=valor.uf;
    }
    
    function atualizaValorQuantidade(index) {
    var valor = document.getElementsByName('valor');
    //v = document.getElementById('total');
    document.getElementById('subvalor' + index).value = document.getElementById('quantidade' + index).value * document.getElementById('valor' + index).innerText;
    
}


function alteraItemCarrinho(index) {
    var id = "#idQuantidade"+index;
    id = $(id).val();
    
    var quantidade = "#quantidade"+index;
    quantidade = $(quantidade).val();
    
    $.post( 'servletCarrinho?action=alterar&id='+id+'&quantidade='+quantidade );
    setTimeout("alert('Valor atualizado');", 2);
    window.location.replace('redir_carrinhoCompleto.jsp');  
}

function removeItemCarrinho(index) {
    var id = "#idProduto"+index;
    id = $(id).val();
    
    var idCarrinho = "#idCarrinho"+index;
    idCarrinho = $(idCarrinho).val();
    
    $.post( 'servletCarrinho?action=delete&idProduto='+id+'&idCarrinho='+idCarrinho );
    setTimeout("alert('Item excluido');", 2);
    window.location.replace('redir_carrinhoCompleto.jsp');  
}

function getValorTotal(){
    var page = "servletCarrinhoCompleto?action=total";
    $.post(page, function (responseText) { // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
        $('#total').text(responseText);         // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
    });
    alert();   
}

function replaceString(valor){  
    //alert(document.getElementById("valor").value);  
    //var valor = document.getElementById("valor").value;
    valor.value = valor.value.replace(",","."); 
}



