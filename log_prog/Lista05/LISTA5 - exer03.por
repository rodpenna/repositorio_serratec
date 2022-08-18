//SERRATEC - 
//DEV: RODRIGO PENNA
//TURMA: 06, PETROPOLIS

//LISTA EXERCICIO 5 - 03
/*3 - Escreva uma função que retorna todos os valores duplicados de um
array  

*/


programa{
	//FUNCAO PARA VERIFICAR IGUALDADE DE VALORES DO VETOR
	funcao verificarIgual (){

		//DECLARACAO DE VARIAVEIS

		//Definicao do tamanho do vetor
		const inteiro tamanhoVetor = 10
		real vetorRepetido[tamanhoVetor],vetor[tamanhoVetor]
		inteiro z=0


		//ENTRADA DE DADOS

		//Looping para preenchimento do vetor
		para (inteiro i=0;i<tamanhoVetor;i++){
			escreva("digite o valor do ",i+1,"º elemento: ")
			leia(vetor[i])
			escreva("\n")
		}

		//PROCESSAMENTO DE DADOS

		//Looping para definicao dos valores repetidos e armazenamento em novo vetor
		para (inteiro i =0;i<tamanhoVetor;i++){
			para (inteiro j=i+1;j<tamanhoVetor;j++){
				se ((vetor[i]==vetor[j])){
					vetorRepetido[z] = vetor[i]
					z++				
				}			
			}
		}

		//SAIDA DE DADOS

		//Looping para escrever o valores duplicados se houver
		para (inteiro i=0;i<z;i++){
			escreva(vetorRepetido[i],"  \n")
		}
	}

	//FUNCAO PRINCIPAL
	funcao inicio(){
		//Chamada da funcao
		verificarIgual()
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 991; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */