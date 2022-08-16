//SERRATEC - 
//DEV: RODRIGO PENNA
//TURMA: 06, PETROPOLIS

//LISTA EXERCICIO 4 - 05
/*6 - Escreva um programa que armazene elementos em um vetor e imprima-os
Exemplo de entrada: 
Armazene 5 elementos em um vetor : 
Elemento - 0 : 1 
Elemento - 1 : 4 
Elemento - 2 : 3 
Elemento - 3 : 6 
Elemento - 4 : 8 

*/
programa{
	
	funcao inicio(){

		//DECLARACAO DE VARIAVEIS
		//
		//Declaracao do vetor utilizado
		real vetor[999]

		//Valor do elemento no vetor
		real valorElemento

		//Tamanho inicial do vetor
		inteiro tamanho = 0

		//Variaveis para pegar a posicao do maior e menor valor
		inteiro posMaior = 0
		inteiro posMenor = 0

		//Variavel para inicialicao 
		logico primeiro = verdadeiro

		//Variaveis de controle 
		//Menu principal
		caracter perg
		//menu de visualizacao
		caracter perg2


		//PROCESSAMENTO E ENTRADA DE DADOS: 

		//Menu Principal
		//Primeira pergunta
		escreva("[home]\n\n")
		escreva("['A'rmazenar / 'V'isualizar / 'T'amanho / 'S'air ]")
		escreva("\nOque deseja fazer?: ")
		leia(perg)

			
		//Menu seletor - MENU PRINCIPAL
		enquanto(perg!='S'){
			//Enquanto nao colocar SAIR o programa irá rodar
			//Execucao da opcao desejada - MENU PRINCIPAL
			escolha(perg){
				
				//Armazenar um valor no elemento
				 caso ('A'):
					limpa()
					//Definindo um tamanho para o vetor
				 	se (tamanho==0){
				 		escreva("[home/tamanho_vetor]\n\n")
					 	escreva("\nDigite o tamanho do vetor: ")
						leia (tamanho)
						limpa()
				 	}
				 	//Repeticao para adicionar o valor no elemento do vetor
				 	escreva("[home/add_valor]\n\n")
					para (inteiro i=0;i<tamanho;i++){
						escreva("Escreva o valor do ",i+1,"° elemento: ")
						leia(valorElemento)
						vetor[i] = valorElemento
					}
					//Mudando o valor da condicao de primeira rodada
					primeiro = falso
					limpa()
					escreva("Valores adicionados com sucesso")
					pare
					
				//Visualizar os valores do vetor
				caso 'V':
					limpa()
					//Verificacao se o vetor possui valor
					se (primeiro==falso){
						escreva("[home/visualizar]\n\n")
						//Novo menu para definir qual tipo de visualização sera usada
						escreva("['V'alor elemento / 'M'ax e min]: ")
						leia(perg2)
						escolha(perg2){
							//Visualização do valor dos elementos
							caso 'V':
								limpa()
								escreva("Os valores do vetor sao:\n")
								//Repeticao para visualizar o valor dos vetores
								para (inteiro i=0;i<tamanho;i++){	
									escreva("\nPosição ",i, " Valor: ",vetor[i])
								
								}
								pare

							caso 'M':
								real maiorValor =0.0
								real menorValor=999999.0
								//Repeticao para pegar o valor e a posicao do maior e menor elemento do vetor
								para (inteiro i=0;i<tamanho;i++){	
									se (vetor[i]>maiorValor){
										maiorValor = vetor[i]
										posMaior = i
									}
									se(vetor[i]<menorValor){
										menorValor = vetor[i]
										posMenor = i
									}
								}
								//Saida do menor e maior valor junto da sua posicao
								limpa()
								escreva("O maior e menor valor do vetor é:\n")
								escreva("\nO maior valor é: ",maiorValor, " na posição ",posMaior)
								escreva("\nO menor valor é: ",menorValor, " na posição ",posMenor)
								pare
						}
					}
					pare
					
				//Mudar tamanho do vetor
				caso 'T':
					limpa()
					//Modifica o tamanho do vetor sem apagar os valores antigos
					escreva("Digite o novo tamanho: ")
					leia(tamanho)
				pare
	
			}//fim escolha
			escreva("\n\n--------------------------------\n")
			//Pergunta para permanecer no programa
			escreva("[home]\n\n")
			escreva("\n['A'rmazenar / 'V'isualizar / 'T'amanho / 'S'air ]")
			escreva("\nOque deseja fazer?: ")
			leia(perg)
		}//fim enquanto
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1871; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */