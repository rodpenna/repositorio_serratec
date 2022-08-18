/*
SERRATEC - 
DEV: RODRIGO PENNA
TURMA: 06, PETROPOLIS

TRABALHO - Questao 07
7. Elabora um programa que solicita ao usuário a quantidade de números primos que ele quer que
seja impresso. Após imprima na tela a quantidade de números primos escolhida. Ex. Entrada 4
Saída 1 2 3 5

*/
programa{
	//FUNCAO PARA VERIFICAR SE UM NUMERO E PRIMO OU NAO
	funcao logico verificarPrimo(inteiro n){
		//DECLARACAO DE VARIAVEIS
		inteiro aux,primo=1

		//Looping para classificacao de primo ou nao
		para(aux=2 ; aux<=n/2 ; aux++ ){
			se ( (n % aux==0) ){
				primo=0
			}
		}
		//SAIDA DE DADOS
		se (primo==1){
			retorne verdadeiro
		}
		senao{
			retorne falso
		}
	}


	//FUNCAO PRINCIPAL
	funcao inicio(){

		//DECLARACAO DE VARIAVEIS
		//Definicao do tamanho do vetor
		const inteiro tamanhoVetor = 50

		inteiro n,contador,i,vetor[tamanhoVetor]
		logico ehPrimo
		caracter resp ='Y'

		//ENTRADA DE DADOS
		faca{
			escolha(resp){
				caso 'Y':
					contador=0
					i=0
					limpa()
					//Definicao do numero de primos deseja fazer
					escreva("Digite a quantidade de números primos que deseja visualizar: ")
					leia(n)
					//Validacao para a posicao desejada
					enquanto(n==0){
						limpa()
						escreva("Valor informado é inválido, entre com um valor entre 1 e ",tamanhoVetor,"\n")
						escreva("Caso deseje mais números aumente o tamanho do vetor")
						escreva("\n\nDigite a quantidade de números primos que deseja visualizar: ")
						leia(n)
					}

					//Looping para obtencao dos numeros primos
					enquanto( contador != n ){
						vetor[contador] = i
						ehPrimo = verificarPrimo(i)
						se ((ehPrimo==verdadeiro)){
								contador++
						}
						i++	
					}

					//SAIDA DE DADOS
					limpa()
					escreva("Os primos são: ")
					para ( i=0 ; i<n ; i++ ){
						escreva(vetor[i],"  ")
					}
					pare
	
				caso 'N':
					limpa()
					pare

				caso contrario:
					limpa()
					escreva("Opção inválida tente novamente")
					pare

			}//fim escolha
			escreva("\n\n-------------------\n")
			escreva("Deseja continuar calculando? [ Y | N ]: ")
			leia(resp)
		}enquanto(resp!='N')//fim faça
		limpa()
		escreva("Programa finalizado pelo usuário\n\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 2177; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */