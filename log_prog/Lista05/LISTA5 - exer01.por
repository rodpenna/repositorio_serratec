//SERRATEC - 
//DEV: RODRIGO PENNA
//TURMA: 06, PETROPOLIS

//LISTA EXERCICIO 5 - 01
/*1 - Escreva um programa que leia 10 números inteiros do teclado e armazena no
vetor. Após isso, imprima os 10 inteiros em ordem inversa ao que foi digitado. 

*/

programa{
	//FUNCAO PRINCIPAL
	funcao inicio(){

		//DECLARACAO DE VARIAVEIS
		real vetor[10]


		//ENTRADA DE DADOS

		//Looping para preenchimento do vetor
		para (inteiro i=0;i<10;i++){
			escreva("Digite o ",i+1,"° número: ")
			leia(vetor[i])
			escreva("\n")
		}

		//PROCESSAMENTO E SAIDA DE DADOS
		
		limpa()
		escreva("O resultado do vetor em ordem inversa: \n")
		//Looping para exibicao dos valores em ordem inversa a digitada
		para(inteiro i=9;i>=0;i--){
			escreva("\nElemento ",10-i,"º com valor: ",vetor[i])
		}		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 688; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */