//SERRATEC - 
//DEV: RODRIGO PENNA
//TURMA: 06, PETROPOLIS

//LISTA EXERCICIO 3 - 02
/*2 - Escreva um programa que faça a tabuada de um número n.
Exemplo de entrada: 6 
Saída esperada:
6x1 = 6 6x2 = 12
6x3 = 18 6x4 = 24
... ... 6x10 = 60   */

programa{
	funcao inicio(){
		//DECLARACAO DE VARIAVEL
		real numero
		inteiro i = 0
				
		//ENTRADA DE DADOS
		escreva("Digite o número para saber a tabuada: ")
		leia(numero)

		//PROCESSAMENTO E SAIDA DE DADOS
		se (numero>=0){
			
			enquanto (i<=10){
				escreva (numero," x ",i ," = ",numero*i, "\n")
				
				i += 1
			}
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
 * @POSICAO-CURSOR = 572; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */