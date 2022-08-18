/*
SERRATEC - 
DEV: RODRIGO PENNA
TURMA: 06, PETROPOLIS

TRABALHO - Questao 02
2. Programar uma calculadora com as operações: soma, subtração, multiplicação e divisão. Deverá ter
um menu com as opções de operação. Após a escolha da operação deverá permitir a inserção de
dois valores e executar a conta. Deverá apresentar o resultado ao usuário e perguntar se ele deseja
fazer novo cálculo ou se deseja encerrar o programa. Deverá permitir voltar ao menu caso a escolha
seja fazer novo cálculo ou sair caso a escolha seja encerrar o programa.



PENDENCIAS - SAIDA APENAS COM O RESULTADO N ou n


*/
programa{
	
	//FUNCAO PARA MULTIPLICAR DOIS VALORES
	funcao multiplicar(real n1, real n2){
		limpa()
		escreva("O resultado de ",n1, " * ",n2,"  é :  ",n1*n2,"\n") 
	}


	//FUNCAO PARA DIVIDIR DOIS VALORES
	funcao dividir(real n1, real n2){
		se (n2!=0){
			limpa()
			escreva("O resultado de ",n1, " / ",n2,"  é :  ",n1/n2,"\n") 	
		}
		senao{
			limpa()
			escreva ("Não se pode fazer divisão por zero.","\n") 
		}
	}

	
	//FUNCAO PARA SOMAR DOIS VALORES
	funcao somar(real n1, real n2){
		limpa()
		escreva("O resultado de ",n1, " + ",n2,"  é :  ",n1+n2,"\n") 
	}

	
	//FUNCAO PARA SUBTRAIR DOIS VALORES
	funcao subtrair(real n1, real n2){
		limpa()
		escreva("O resultado de ",n1, " - ",n2,"  é :  ",n1-n2,"\n") 
	}

	//FUNCAO PRINCIPAL
	funcao inicio(){

		//DECLARACAO DE VARIAVEIS
		caracter perg,op
		real n1,n2


		//ENTRADA DE DADOS
		escreva("Oque deseja fazer?")
		escreva("\n[ 'C'alcular | 'S'air ]: ")
		leia(perg)

	enquanto(perg!='S'){
		escolha(perg){
			
			//Caso deseja calcular
			caso 'C':
				limpa()
				escreva("Escolha uma operação")
				escreva("\n[ '*' Multiplicação | '/' Divisão | '+' Adição | '-' Subtração ]: ")
				leia (op)

				escreva("\nDigite o valor do primeiro número: ")
				leia(n1)

				escreva("\nDigite o valor do segundo número: ")
				leia(n2)

				//Laço para obter a operacao desejada
				escolha(op){
				
					caso '*':
						multiplicar(n1,n2)
						pare

					caso '/':
						dividir(n1,n2)
						pare

					caso '-':
						subtrair(n1,n2)
						pare
						
					caso '+':
						somar(n1,n2)
						pare

					caso contrario:
							limpa()
							escreva("Erro de preenchimento, escolha uma operação válida")
							escreva("\nReiniciando programa...")
							pare						
				}
				escreva("\n\n[ 'C'alcular | 'S'air ]: ")
				leia(perg)
	
			//Para sair do programa			
			caso 'S':
				pare

			//Validação de entrada
			caso contrario:
				limpa()
				escreva("Opção inválida, digite uma opção válida")
				escreva("\n[ 'C'alcular | 'S'air ]: ")
				leia(perg)
				pare		
		}
	}
		
		//SAIDA DO PROGRAMA		
		escreva("\nFinalizado usuario")

		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1575; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */