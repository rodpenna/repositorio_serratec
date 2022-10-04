

function enviarFormulario(){

    var nome = document.getElementById("txtNome").value;
    var cpf = document.getElementById("txtCPF").value;
    var texto = document.getElementById("txtArea").value; 

    console.log(isNaN(texto))
    console.log(isNaN(cpf))
    console.log(isNaN(nome))

    if(checkEmail() && isNaN(nome) && isNaN(texto) ){
        alert('Mensagem enviada');
    }
    else {
        //Removido para poder funcionar os required do form dentro do html
        alert('Erro de preechimento dos campos');
       
    }


}




function checkEmail() {
    var email = document.getElementById('txtEmail');
    var filter = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (!filter.test(email.value)) {
        return false;
        
    }
    else{
        return true;
        
    }
}

var txtNome = document.getElementById("txtNome");
txtNome.addEventListener("input", () => {
  if (txtNome.validity.tooLong || txtNome.validity.tooShort || txtNome.validity.valueMissing) {
    txtNome.setCustomValidity("NOME DEVE TER PELO MENOS 4 CARACTERES");
    txtNome.reportValidity();
  } else { txtNome.setCustomValidity(""); }
});

var txtEmail = document.getElementById("txtEmail");
txtEmail.addEventListener("input", () => {
  if (txtEmail.validity.tooLong || txtEmail.validity.tooShort || txtEmail.validity.valueMissing || checkEmail()==false) {
    txtEmail.setCustomValidity("EMAIL DEVE SER DA FORMA exemplo@exemplo.com ou exemplo@exemplo.com.br");
    txtEmail.reportValidity();
  } else { txtEmail.setCustomValidity(""); }
});

var txtCPF = document.getElementById("txtCPF");
txtCPF.addEventListener("input", () => {
  if (txtCPF.validity.tooLong || txtCPF.validity.tooShort || txtCPF.validity.valueMissing) {
    txtCPF.setCustomValidity("CPF DEVE TER 11 NÚMEROS.");
    txtCPF.reportValidity();
  } else { txtCPF.setCustomValidity(""); }
});





// EVITAR RELOAD DA PAGINA
// document.getElementById("botaoEnviar").addEventListener("click", function(event){
//   event.preventDefault()
// });