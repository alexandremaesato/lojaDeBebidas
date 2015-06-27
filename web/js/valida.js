function AnEventHasOccurred() {
var choices;
var nm;
var m;
var t;
var s;
var l;
var els = document.getElementsByName('t');
var n = document.getElementsByName('nome');
var mail= document.getElementsByName('mail');
var tipo= document.getElementsByName('tipo');
var sexo= document.getElementsByName('sexo');
var login= document.getElementsByName('login');

for (var i=0;i<els.length;i++){
  if ( els[i].checked ) {
    choices=els[i].value;
    nm=n[i].value;
    m=mail[i].value;
    t=tipo[i].value;
    s=sexo[i].value;
    l=login[i].value;
  }
}
document.getElementById("nome").value = nm;
document.getElementById("cpf").value = choices;
document.getElementById("email").value = m;
document.getElementById("tipo").value = t;
document.getElementById("sexo").value = s;
document.getElementById("login").value = l;
document.getElementById("cpf1").value = choices;
}

function validaFunc(formulario) {
    if (formulario.nome.value == "")
    {
        alert("Campo nome Obrigatório!");
        return false;
    }
    if (formulario.cpf.value == "")
    {
        alert("Campo cpf Obrigatório!");
        return false;
    }
    if (formulario.email.value == "")
    {
        alert("Campo email Obrigatório!");
        return false;
    }
    if (formulario.sexo.value == "")
    {
        alert("Campo sexo Obrigatório!");
        return false;
    }
    if (formulario.tipo.value == "")
    {
        alert("Campo tipo Obrigatório!");
        return false;
    }
    if (formulario.login.value == "")
    {
        alert("Campo login Obrigatório!");
        return false;
    }
    if (formulario.senha.value == "")
    {
        alert("Campo senha Obrigatório!");
        return false;
    }

}
function validaCpf(formulario) {
    if (formulario.cpf.value == "")
    {
        alert("Selecione um Funcionário!");
        return false;
    }
}
function validaProd(formulario) {
    if (formulario.produto.value == "")
    {
        alert("Digite um produto!");
        return false;
    }
    if (formulario.cat.value == "")
    {
        alert("Digite uma categoria!");
        return false;
    }
    if (formulario.arq.value == "")
    {
        alert("Selecione um arquivo!");
        return false;
    }
    if (formulario.descr.value == "")
    {
        alert("Digite uma descrição!");
        return false;
    }
    if (formulario.valor.value == "")
    {
        alert("Digite um valor!");
        return false;
    }
    if (formulario.qtd.value == "")
    {
        alert("Digite uma quantidade!");
        return false;
    }
}
function validaclisel(formulario) {
    if (formulario.t.value == "")
    {
        alert("Selecione um cliente!");
        return false;
    }
}
function validacategoria(formulario) {
    if (formulario.categoria.value == "")
    {
        alert("Digite uma categoria!");
        return false;
    }
}