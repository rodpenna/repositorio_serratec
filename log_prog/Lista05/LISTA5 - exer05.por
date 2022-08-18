/*
SERRATEC - 
DEV: RODRIGO PENNA
TURMA: 06, PETROPOLIS

LISTA 5 - Questao 05
5 - Escreva uma função que calcula a média dos números de um vetor, excluindo
o maior e o menor valor. 

*/
programa{

	//FUNCAO PARA VERIFICAR A MEDIA DE UM VETOR EXCLUINDO O MAIOR E MENOR VALOR
	funcao verificarMedia(){


		//DECLARACAO DE VARIAVEIS

		//Definição do tamanho do vetor
		const inteiro tamanhoVetor = 10
		//Declaracao das variaveis que serao utilizadas com os seus valores
		//maior = 0 e menor = (maior valor possivel) para poder trabalhar com as verificacoes
		real vetor[tamanhoVetor],soma=0.0,media,maior=0.0,menor=99999999.9

		//ENTRADA DE DADOS
		
		//Looping para preenchimento do vetor
		para (inteiro i=0;i<tamanhoVetor;i++){
			escreva("digite o valor do ",i+1,"º elemento: ")
			leia(vetor[i])
			escreva("\n")
		}


		//PROCESSAMENTO DE DADOS
		
		//Looping para verificacao do maior e menor valor do vetor
		para (inteiro i=0;i<tamanhoVetor;i++){
			se (vetor[i]>=maior){
				maior = vetor[i]
			}
			se (vetor[i]<=menor){
				menor = vetor[i]
			}
			//Somatorio para definir a media
			soma += vetor[i]
		}

		//SAIDA DE DADOS
		
		//Calculo da media do vetor
		media = (soma-maior-menor)/(tamanhoVetor-2)
		limpa()
		escreva("A media dos valores do vetor é: ",media,"\n")
	}

	//FUNCAO PRINCIPAL
	funcao inicio()
	{
		//Chamada da funcao para calcular a media
		verificarMedia()
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1372; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */