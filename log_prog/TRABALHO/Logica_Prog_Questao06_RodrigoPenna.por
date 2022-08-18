/*
SERRATEC - 
DEV: RODRIGO PENNA
TURMA: 06, PETROPOLIS

TRABALHO - Questao 06
6. Elabore um programa em que o usuário informa dois números (n1 e n2). O primeiro número (n1)
indica o início do laço de repetição e o segundo número (n2) o fim do laço de repetição. O
programa deverá imprimir a soma de todos os números pares no intervalo entre n1 e n2.
*/
programa{
	//FUNCAO PRINCIPAL
	funcao inicio(){

		//DECLARACAO DE VARIAVEIS
		inteiro n1,n2,soma=0,i

		//ENTRADA DE DADOS
		escreva("Digite o valor do primeiro número: ")
		leia(n1)
		escreva("\nDigite o valor do segundo número: ")
		leia(n2)

		i = n1

		//Looping para obter a soma dos numeros pares entre o intervalo
		enquanto (i<=n2){
			se(i%2 == 0){
				soma += i
			}
			i++
		}

		//SAIDA DE DADOS
		escreva("\n\nA soma dos pares e: ",soma,"\n")
	}	
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 598; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */