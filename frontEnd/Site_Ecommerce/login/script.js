
    // LOGIN PAGE

    async function verificarLogin(){
        var user = "ABc1"
        var pass = "ABc1"
     

        if ( ( user == document.getElementById("usuario").value ) && ( pass==document.getElementById("senha").value ) ) {
            window.location.href= "./loginOk.html"
        }
        else{


            if (document.getElementById("usuario").value==""){
                alert("Nome de usuario Invalido  ----- ABc1");
            }
            else if (document.getElementById("senha").value==""){
            
                alert("Senha Invalida  ----- ABc1");
            }
            else {
                alert("Login Invalido  ----- ABc1");
            }         
        }
        
    }