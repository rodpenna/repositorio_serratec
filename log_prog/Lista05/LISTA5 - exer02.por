//SERRATEC - 
//DEV: RODRIGO PENNA
//TURMA: 06, PETROPOLIS

//LISTA EXERCICIO 5 - 02
/*2 - Escreva um programa que armazene X números em um vetor e calcule o valor
médio do vetor.  

*/


programa{
	//FUNCAO PRINCIPAL
	funcao inicio(){

		//DECLARACAO DE VARIAVEIS

		//Definicao do tamanho do vetor
		const inteiro tamanhoVetor = 10
		inteiro numero
		real vetor[tamanhoVetor],soma=0.0,media

		//ENTRADA DE DADOS

		//Looping para preenchimento + soma dos valores do vetor
		para (inteiro i=0;i<tamanhoVetor;i++){
			escreva("digite o valor do ",i+1,"º elemento: ")
			leia(vetor[i])
			escreva("\n")
			soma += vetor[i]
		}

		//PROCESSAMENTO DE DADOS

		//Calculo da media dos valores do vetor
		media = soma / (tamanhoVetor)

		//SAIDA DE DADOS

		//Exibicao do valor da media
		limpa()
		escreva("A media dos valores do vetor é: ",media,"\n")
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 781; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */