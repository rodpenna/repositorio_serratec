

    const populateContato = async () => {
        //API DOS DADOS DOS ALUNOS
        // https://mocki.io/v1/4e8cf745-6d8b-4c3d-beb1-7f8887d41984

        var respostaApiDados = await fetch("https://mocki.io/v1/4e8cf745-6d8b-4c3d-beb1-7f8887d41984");
        var dadosResposta1 = await respostaApiDados.json();

        const usuarios = ["arthurcler","arthurGiangiarulo","Lguedes2","RenataRaulino","rodpenna"];
    
        for (let i =0; i<usuarios.length;i++){

            var respostaAPIGit = await fetch(`https://api.github.com/users/${usuarios[i]}`);
            var dadosGit = await respostaAPIGit.json();

            if (dadosGit.name == null){
                dadosGit.name = dadosGit.login
            }

            dadosResposta1.map( item => {

                if(item.usuario == usuarios[i] ){
                    var card =
                    ` 
                        <div class="contato" >
                            
                            <h2>${dadosGit.name}</h2>
                            
                            <img src="${dadosGit.avatar_url}" alt="fotoPerfil" >
                
                            <nav class="social">
                                <ul>
                                    <a href=${item.face} target="_blank"><li><img src="./img/facebook.svg" alt="facebook"></li></a>
                                    <a href=${item.twitter} target="_blank"><li><img src="./img/twitter.svg" alt="twitter"></li></a>
                                    <a href=${item.insta} target="_blank"><li><img src="./img/instagram.svg" alt="instagram"></li></a>
                                    <a href=${item.github} target="_blank"><li><img src="./img/github.svg" alt="github"></li></a>
                                </ul>
                            </nav>
                            
                        </div>
                
                    `
                    document.getElementById("painel").insertAdjacentHTML('afterbegin', card)
                }
            })
        }    
    }

    populateContato();