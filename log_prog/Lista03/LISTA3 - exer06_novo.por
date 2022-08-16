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
programa{
	funcao inicio(){
		real n1,n2,teste
		caracter op
		caracter perg = 'y'

		faca{
			escreva("Entre com o valor do primeiro número: ")
			leia(n1)
			escreva("Entre com o valor do segundo número: ")
			leia(n2)
			escreva("A operação desejada: ")
			leia(op)
	
			escolha(op){
			
				caso '*':
					multiplica(n1,n2)
					pare

				caso '/':
					divisao(n1,n2)
					pare

				caso '+':
					soma(n1,n2)
					pare

				caso '-':
					subtracao(n1,n2)

				caso contrario:
					escreva("\nErro de preenchimento")		
			}
			escreva("\n-------------\n")
			escreva ("\nDeseja continuar o programa? [y/n]")
			leia (perg)
			limpa()			
		}enquanto (perg=='Y' ou perg=='y')
		limpa()
		escreva ("\nFinalizado Programa\n")
	}




	funcao multiplica(real n1, real n2){
		escreva("\nO resultado de ",n1, " * ",n2," é :",n1*n2,"\n") 
		
	}
	funcao divisao(real n1, real n2){
		se (n2!=0){
			escreva("\nO resultado de ",n1, " / ",n2," é :",n1/n2,"\n") 	
		}
		senao{
			escreva ("\nNão se pode fazer divisão por zero.","\n") 
		}
	}
	
	funcao soma(real n1, real n2){
		escreva("\nO resultado de ",n1, " + ",n2," é :",n1+n2,"\n") 
	}
	
	funcao subtracao(real n1, real n2){
		escreva("\nO resultado de ",n1, " - ",n2," é :",n1-n2,"\n") 
	}



		
		}
		
	}

	
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1050; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */