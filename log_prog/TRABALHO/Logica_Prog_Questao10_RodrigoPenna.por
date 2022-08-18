/*
SERRATEC - 
DEV: RODRIGO PENNA
TURMA: 06, PETROPOLIS
GRUPO 03

TRABALHO - Questao 10
10. Desenvolva um programa que some duas matrizes modelo Amxn + Amxn = Amxn. Solicite que o
usuário escolha os números de entrada de ambas as matrizes e apresente como resultado as duas
matrizes de entrada e a matriz resultado, pode ser uma em baixo da outra. Identifique cada matriz
ao apresentar o resultado. 


*/
programa{
	//FUNCAO PRINCIPAL
	funcao inicio(){
		//DECLARACAO DE VARIAVEIS
		
		const inteiro MAX = 10										//MUDAR CASO QUEIRA AUMENTAR O TAMANHO DAS MATRIZES
		logico primeiro = verdadeiro

		caracter resp
		inteiro m=0,n=0

		real matrizA[MAX][MAX],matrizB[MAX][MAX],matrizC[MAX][MAX]


		escreva("Esta e uma calculadora de soma de matrizes")
		escreva("\n-\nOque deseja fazer?\n")
		escreva("['C'alcular | 'V'isualizar | 'T'amanho | 'S'air ]: ")
		leia(resp)
			
		faca{
			escolha(resp){
				caso 'C':
					limpa()
												
					se( (m!=0 e n!=0) e
						(m<=MAX e n<=MAX)						
					){

						//ENTRADA DE DADOS
						escreva("Digite os elementos da primeira matriz\n")
						//Looping para criacao da primeira matriz
						para(inteiro i=0;i<m;i++){
							para(inteiro j=0;j<n;j++){
											
								escreva("Digite o valor do elemento da ",i+1,"º linha e da ",j+1,"° coluna:  ")
								leia(matrizA[i][j])
											 
							}
						}

					
						limpa()
						escreva("Digite os elementos da segunda matriz\n")
						//Looping para criacao da seguinda matriz
						para(inteiro i=0;i<m;i++){
							para(inteiro j=0;j<n;j++){
								
								escreva("Digite o valor do elemento da ",i+1,"º linha e da ",j+1,"° coluna:  ")
								leia(matrizB[i][j])									 
							}
						}
					
						//PROCESSAMENTO DE DADOS
					
						//Calculo da matriz de soma
						para(inteiro i=0;i<m;i++){
							para(inteiro j=0;j<n;j++){
								matrizC[i][j] = matrizA[i][j] + matrizB[i][j]
							}
						}
							
						limpa()
						escreva("Matrizes adicionadas")
						primeiro = falso
					}
					senao{
						limpa()
						escreva("Primeira defina uma ordem para as matrizes em 'T'amanho ou  ")
						escreva("\ndentro dos parâmetros máximos possíveis")
					
					}
							
					pare


				caso 'V':
					limpa()
					se(primeiro==verdadeiro){
						escreva("Não foi adicionado ainda valores na matriz, por isso os valores zeros ou vazios\n\n")
					}
					se (n==0 ou m==0){
						escreva("Defina a ordem da matriz em 'T'amanho\n\n")
					}
						
					escreva("\nPrimeira matriz\n")
					//Looping para exibicao da matriz
					para(inteiro i=0;i<m;i++){
						para(inteiro j=0;j<n;j++){
							escreva(matrizA[i][j],"    ")
						}
						escreva("\n")
					}
			
					escreva("\n\nSegunda matriz\n")
					//Looping para exibicao da matriz
					para(inteiro i=0;i<m;i++){
						para(inteiro j=0;j<n;j++){
							escreva(matrizB[i][j],"    ")
						}
						escreva("\n")
					}
					
					
					escreva("\n\nMatriz resultado\n")
					//Looping para exibicao da matriz
					para(inteiro i=0;i<m;i++){
						para(inteiro j=0;j<n;j++){
							escreva(matrizC[i][j], "    ")
						}
						escreva("\n")
					}
					
					pare

				caso 'S':
					pare

				caso 'T':
					limpa()
					escreva("As matrizes envolvidas na adição devem ser da mesma ordem.\nPortanto uma definição mudará a ordem de ambas")
					escreva("\nDigite o valor da linha da matriz: (max: ",MAX,"):  ")
					leia(m)
					escreva("\nDigite o valor da coluna matriz: (max: ",MAX,"):  ")
					leia(n)
					limpa()
					escreva("Valores de linha e coluna alterados com sucesso")

					pare

				caso contrario:
					limpa()
					escreva("Entrada inválida, tente novamente")
					pare
				
				
			}

		//saida
		se(resp!='S'){
			escreva("\n\n-----------------------------\n")
			escreva("Oque deseja fazer?\n")
			escreva("['C'alcular | 'V'isualizar | 'T'amanho | 'S'air ]: ")
			leia(resp)
		}	
		}enquanto(resp!='S')
		limpa()
		escreva("Fim do programa, finalizado pelo usuário \n\n")		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 3086; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */