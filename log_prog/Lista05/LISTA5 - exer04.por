/*
SERRATEC - 
DEV: RODRIGO PENNA
TURMA: 06, PETROPOLIS

LISTA 5 - Questao 04
4 - Escreva uma função que ordena um vetor com 20 números.


*/
programa{
	//FUNCAO PRINCIPAL
	funcao inicio(){

		//DECLARACAO DE VARIAVEIS

		//Definição do tamanho do vetor
		const inteiro tamanhoVetor = 20
		real vetorEntrada[tamanhoVetor],aux


		//ENTRADA DE DADOS
		
		//Looping para preenchimento do vetor
		para(inteiro i=0;i<tamanhoVetor;i++){
			escreva("Entre com o ",i+1,"º número :","\n")
			leia(vetorEntrada[i])
		}


		//PROCESSAMENTO DE DADOS

		//Looping para realizar a ordenacao do vetor
		para (inteiro i=0;i<tamanhoVetor;i++){
			para(inteiro j=i;j<tamanhoVetor;j++){
				se (vetorEntrada[i]>vetorEntrada[j]){
					aux = vetorEntrada[i]
					vetorEntrada[i] = vetorEntrada[j]
					vetorEntrada[j] = aux
				}
			}	
		}

		//SAIDA DE DADOS

		//Looping para exibicao dos valores ordenados do vetor
		para(inteiro i=0;i<tamanhoVetor;i++){
			escreva(vetorEntrada[i]," ")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 976; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */