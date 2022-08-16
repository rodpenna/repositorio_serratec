//SERRATEC - 
//DEV: RODRIGO PENNA
//TURMA: 06, PETROPOLIS

//LISTA EXERCICIO 3 - 01
/*1 - Modifique o exercício 6 da lista anterior para imprimir os números de 1 até n e
também realizar sua soma.
Exemplo de entrada: 6 Saída esperada: 1 2 3 4 5 6  21  */

programa{
	funcao inicio(){
		//DECLARACAO DE VARIAVEL
		inteiro numero,soma
		inteiro i = 1
				
		//ENTRADA DE DADOS
		escreva("Digite um número inteiro: ")
		leia(numero)

		//PROCESSAMENTO E SAIDA DE DADOS
		se (numero>0){
			soma = 0
			enquanto (i<=numero){
				escreva (i," ")
				soma +=i
				i += 1
			}
			escreva (" ",soma)	
		}
		senao{
				escreva("\nErro de preenchimento\n")	
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 589; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */