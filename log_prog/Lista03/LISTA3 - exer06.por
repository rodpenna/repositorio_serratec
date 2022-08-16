//SERRATEC - 
//DEV: RODRIGO PENNA
//TURMA: 06, PETROPOLIS

//LISTA EXERCICIO 3 - 06
/*6 Reescreva o código da calculadora e transforme cada uma das operações ( + - * / )
em uma função. 

4 - Escreva um programa que funcione como uma calculadora simples de soma (+),
subtração(-), multiplicação(*) e divisão(/)
Exemplo de entrada:10 2 * 
Saída esperada: 10 * 2 = 20 

*/
programa
{
	funcao inicio()
{
		real n1,n2,teste
		caracter op
		caracter perg = 'y'


		enquanto (perg=='Y' ou perg=='y'){

			escreva("Entre com o valor do primeiro número: ")
			leia(n1)
			escreva("Entre com o valor do segundo número: ")
			leia(n2)
			escreva("A operação desejada: ")
			leia(op)
	
			se (op=='*' ou op=='-' ou op=='+' ou op=='/' ){
				escreva ("\nO resultado é: ",calc(n1,n2,op) ,"\n" )
			}
			senao {
				escreva("\nErro de preenchimento\n")
			}

			escreva("\n-------------\n")
			escreva ("\nDeseja continuar o programa? [y/n]")
			leia (perg)
			limpa()
		}
		limpa()
		escreva ("\nFinalizado Programa\n")
	}

	funcao real calc (real n1,real n2,caracter op){

		escolha (op){
			caso '*':
				retorne n1*n2

			caso '/':
				retorne n1/n2

			caso '-':
				retorne n1-n2

			caso '+':
				retorne n1+n2

			caso contrario:
				retorne 0.0
		
		}
		
	}

	
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 954; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */