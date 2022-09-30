

async function populateProduto(){
    apagarConteudo("container")
    var respostaAPI = await fetch("https://mocki.io/v1/c0e9b845-a506-4353-91e7-f061317eb8ce");
    
    var produtos = await respostaAPI.json()

    produtos.map( item => {
        var card =
        ` 
            <div class="col-xl-2 col-lg-3 col-md-3 col-sm-3 d-flex p-1 align-items-stretch ">
                <div class="card text-center bg-light">
                    <img id="imgCard" src=${item.imagem} class="card-img-top" onclick="showModal(${item.id})">            
                    <div class="card-header">
                        ${item.preco}
                    </div>
                    <div class="card-body">
                        <h5 class="card-title ">${item.nome}</h5>
                    </div>            
                    <div class="card-footer">
                    <form class="d-block">
                        <button class="btn btn-dark" ">
                            Adicionar ao carrinho
                        </button>
                    </form>
                    <small class="text-sucess">ESTOQUE: ${item.estoque}</small>
                    </div>
                </div>
            </div>  
        `
        document.getElementById("container").insertAdjacentHTML('afterbegin', card)
    })
}

populateProduto()

var modalWrap = null;
async function  showModal (id) {

    if (modalWrap !== null){
        modalWrap.remove();
    }

    var respostaAPI = await fetch("https://mocki.io/v1/c0e9b845-a506-4353-91e7-f061317eb8ce");
    
    var produtos = await respostaAPI.json()
    
    produtos.map( item => { 

        if (item.id == id){
            
            modalWrap = document.createElement(`div`);

            modalWrap.innerHTML = 
            `             
                <div class="modal" class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="staticBackdropLabel">Dados do Produto</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 d-flex  align-items-center ">
                                    <div class="container text-center bg-light">
                                        <div class="row">
                                            <div class="col">
                                                <img src=${item.imagem} class="card-img-top" >    
                                            </div>
                                            <div class="col">
                                                <div class="mb-2 mt-3 d-flex  align-items-center">
                                                    <h5 class="card-text">${item.nome}</h5>
                                                </div> 

                                                <div class="col mt-5 ">
                                                    <h6 class="text-start">Descrição : </h6>
                                                    <p class="text-start">
                                                        ${item.descricao}
                                                    </p>
                                                </div> 

                                                <div class="col mt-5 mb-5 d-flex  align-items-left">
                                                    <h6 class="card-text">PREÇO : <strong>${item.preco}</strong></h6>
                                                    
                                                </div>
                                                    
                                                <div class="col mt-5 mb-5 d-flex  align-items-left">
                                                    <small class="text-sucess">
                                                        ESTOQUE: <strong>${item.estoque}</strong>
                                                    </small>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>  
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            
            `
        
            document.body.append(modalWrap);
        
            var modal = new bootstrap.Modal(modalWrap.querySelector('.modal'));
            modal.show();
        }
    })
}


async function populateProdutoProcura(){     
    
    var nome = document.getElementById("pesquisa").value

    var respostaAPI = await fetch("https://mocki.io/v1/c0e9b845-a506-4353-91e7-f061317eb8ce");
    
    var produtos = await respostaAPI.json()

    apagarConteudo("container")

    var encontrado = false
    
    if (isNaN(nome)==true){
        produtos.map( item => {

            if (item.nome == nome){
                var card =
                ` 
                    <div class="col-xl-2 col-lg-3 col-md-4 col-sm-4 d-flex p-2 align-items-stretch ">
                        <div class="card text-center bg-light">
                            <img id="imgCard" src=${item.imagem} class="card-img-top" onclick="showModal(${item.id})">            
                            <div class="card-header">
                                ${item.preco}
                            </div>
                            <div class="card-body">
                                <h5 class="card-title">${item.nome}</h5>
                            </div>            
                            <div class="card-footer">
                            <form class="d-block">
                                <button class="btn btn-dark" ">
                                    Adicionar ao carrinho
                                </button>
                            </form>
                            <small class="text-sucess">ESTOQUE: ${item.estoque}</small>
                            </div>
                        </div>
                    </div>  
                `
                encontrado = true
                document.getElementById("container").insertAdjacentHTML('afterbegin', card)
            }
        })
        if (encontrado==false ){
            missingItem()
        }
    }
    else {
        populateProduto()
    }
     
}


function apagarConteudo(elementID) {
    document.getElementById(elementID).innerHTML = "";
}


function missingItem(){
    
    var card = ` 
        <div id="missing">
            <div class="col-xl-12 col-lg-12col-md-12 col-sm-12 d-flex p-2 justify-content-center">
                <div class="d-flex p-2 justify-content-center">
                    <h1  class="text-center p-3"> Item não encontrado </h5>
                </div> 
            </div>  
        </div> 
    `
    document.getElementById("container").insertAdjacentHTML('afterbegin', card)


    console.log(document.getElementById("missing"))
    console.log(document.getElementById("pesquisa").value)
}


// EVITAR RELOAD DA PAGINA
document.getElementById("botaoBuscar").addEventListener("click", function(event){
    event.preventDefault()
  });


document.getElementById("pesquisa").addEventListener("input", function(){
    if(document.getElementById("pesquisa").value=="" || document.getElementById("pesquisa").value==null){
        populateProduto()
        apagarConteudo("missing")
    }
});




var activities = document.getElementById("seletor");

activities.addEventListener("change", function(){

    if(activities.value=="Ordernar pelo nome"){
        
        filtro(null)
    }
    else if(activities.value=="Ordernar pelo maior preço"){
        filtro(1)
    }
    else if(activities.value=="Ordernar pelo menor preço"){
        filtro(2)
    }
})


async function filtro(preco){
    apagarConteudo("container")
    if (preco == null){
       
        var respostaAPI = await fetch("https://mocki.io/v1/c0e9b845-a506-4353-91e7-f061317eb8ce");
        
        var produtos = await respostaAPI.json()
        
        var nomes = []

        produtos.map( item => {

            nomes.push(item.nome)

        })

        var nomeOrdem = nomes.sort()

        nomeOrdem = nomeOrdem.reverse()

        for (let i =0; i<nomeOrdem.length;i++){

            produtos.map( item => {

                if (item.nome==nomeOrdem[i]){
                    
                    var card =
                    ` 
                        <div class="col-xl-2 col-lg-3 col-md-3 col-sm-3 d-flex p-1 align-items-stretch ">
                            <div class="card text-center bg-light">
                                <img id="imgCard" src=${item.imagem} class="card-img-top" onclick="showModal(${item.id})">            
                                <div class="card-header">
                                    ${item.preco}
                                </div>
                                <div class="card-body">
                                    <h5 class="card-title ">${item.nome}</h5>
                                </div>            
                                <div class="card-footer">
                                <form class="d-block">
                                    <button class="btn btn-dark" ">
                                        Adicionar ao carrinho
                                    </button>
                                </form>
                                <small class="text-sucess">ESTOQUE: ${item.estoque}</small>
                                </div>
                            </div>
                        </div>  
                    `
                    document.getElementById("container").insertAdjacentHTML('afterbegin', card)
                    
                }
            })

        }

        


    }
    else{

        if (preco==1){
            
            var respostaAPI = await fetch("https://mocki.io/v1/c0e9b845-a506-4353-91e7-f061317eb8ce");
            
            var produtos = await respostaAPI.json()
            
            var nomeOrdem = produtos.sort(function compare(a, b) {
                if (a.preco < b.preco ) return -1;
                if (a.preco  > b.preco ) return 1;
                return 0;
            })
        
            nomeOrdem.map( item => {
                        
                var card =
                ` 
                    <div class="col-xl-2 col-lg-3 col-md-3 col-sm-3 d-flex p-1 align-items-stretch ">
                        <div class="card text-center bg-light">
                            <img id="imgCard" src=${item.imagem} class="card-img-top" onclick="showModal(${item.id})">            
                            <div class="card-header">
                                ${item.preco}
                            </div>
                            <div class="card-body">
                                <h5 class="card-title ">${item.nome}</h5>
                            </div>            
                            <div class="card-footer">
                            <form class="d-block">
                                <button class="btn btn-dark" ">
                                    Adicionar ao carrinho
                                </button>
                            </form>
                            <small class="text-sucess">ESTOQUE: ${item.estoque}</small>
                            </div>
                        </div>
                    </div>  
                `
                document.getElementById("container").insertAdjacentHTML('afterbegin', card)
            })
        }

        else if (preco==2){

              
            var respostaAPI = await fetch("https://mocki.io/v1/c0e9b845-a506-4353-91e7-f061317eb8ce");
            
            var produtos = await respostaAPI.json()
            
            var nomeOrdem = produtos.sort(function compare(a, b) {
                if (a.preco < b.preco ) return -1;
                if (a.preco  > b.preco ) return 1;
                return 0;
            })

            nomeOrdem = nomeOrdem.reverse()
        
            nomeOrdem.map( item => {
                        
                var card =
                ` 
                    <div class="col-xl-2 col-lg-3 col-md-3 col-sm-3 d-flex p-1 align-items-stretch ">
                        <div class="card text-center bg-light">
                            <img id="imgCard" src=${item.imagem} class="card-img-top" onclick="showModal(${item.id})">            
                            <div class="card-header">
                                ${item.preco}
                            </div>
                            <div class="card-body">
                                <h5 class="card-title ">${item.nome}</h5>
                            </div>            
                            <div class="card-footer">
                            <form class="d-block">
                                <button class="btn btn-dark" ">
                                    Adicionar ao carrinho
                                </button>
                            </form>
                            <small class="text-sucess">ESTOQUE: ${item.estoque}</small>
                            </div>
                        </div>
                    </div>  
                `
                document.getElementById("container").insertAdjacentHTML('afterbegin', card)
            })

        }


    }
}