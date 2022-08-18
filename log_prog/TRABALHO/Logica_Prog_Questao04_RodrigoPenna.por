/*
SERRATEC - 
DEV: RODRIGO PENNA
TURMA: 06, PETROPOLIS

TRABALHO - Questao 02
4. Faça um programa que mostre um menu contendo 2 opções: 1. Fibonacci 2. Fatorial. Ao escolher o
numero 1 solicite que o usuário escolha a quantidade de números da série de Fibonacci ele quer
imprimir e execute a função recursivamente. Ao escolher a opção 2 solicite ao usuário que escolha
o número que deseja para o cálculo do Fatorial e execute a função recursivamente.


*/
programa{
	//FUNCAO PRINCIPAL
	funcao inicio(){

		//DECLARACAO DE VARIAVEIS
		
		inteiro perg
		inteiro resp


		//ENTRADA DE DADOS 

		
		escreva("Oque deseja fazer?")
		escreva("\n[ 1 - Fibonacci | 2 - Fatorial | 3 - Sair]: ")
		leia(perg)


		enquanto(perg!=3){
			escolha(perg){
				//Escolheu Fibonacci		
				caso 1:
					limpa()
					escreva("Quantos números de fibonacci deseja visualizar?")
					leia(resp)
					fibonacci(resp)
					pare

				//Escolheu Fatorial
				caso 2:
					limpa()
					escreva("Qual valor deseja calcular o fatorial? ")
					leia(resp)
					fatorial(resp)
					pare

				//Validacao da resposta do que fazer
				caso contrario:
				limpa()
				escreva("Oque deseja fazer?")
				escreva("\n[ 1 - Fibonacci | 2 - Fatorial | 3 - Sair ]: ")
				leia(perg)
			
			}
			
				escreva("\n--------\n")
				escreva("\nOque deseja fazer?")
				escreva("\n[ 1 - Fibonacci | 2 - Fatorial | 3 - Sair ]: ")
				leia(perg)
		}	
	}



	funcao fibonacci (inteiro n){
	/*
	1 solicite que o usuário escolha a quantidade de números da série de Fibonacci ele quer
	imprimir e execute a função recursivamente
	*/
		inteiro ultimo=1,penultimo=1,termo, i=1

		limpa()
		se (n!=0){
		
			escreva("O ",i,"° número fibo é: 0\n")
	
			para (i;i<n;i++){
				enquanto((i==1) ou (i==2)){
					escreva("O ",i+1,"° número fibo é: 1\n")
					i++
				}
				//Troca de valor entre as variaveis
				termo = ultimo + penultimo
				penultimo = ultimo
				ultimo = termo
	
				//SAIDA DE DADOS
				
				escreva("O ",i+1,"° número fibo é: ",termo,"\n")
			}
		}
		senao{
			limpa()
			escreva("A posição desejada não é válida\n")
		}	
	}
		



	//FUNCAO PARA CALCULO DO FATORIAL
	funcao fatorial(inteiro n){
	/* Ao escolher a opção 2 solicite ao usuário que escolha
	o número que deseja para o cálculo do Fatoria */
		inteiro numero = n
		se (n==0 ou n==1){
			escreva("1")	
		}
		senao{
			inteiro resp = n
			enquanto (n > 2){
				n--
				resp *= n			
			}
			limpa()
			escreva(numero," fatorial é igual a : ",resp)
		}
	}	
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1632; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */