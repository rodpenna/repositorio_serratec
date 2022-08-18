/*
SERRATEC - 
DEV: RODRIGO PENNA
TURMA: 06, PETROPOLIS

LISTA 5 - Questao 06
6 - Escreva uma função que calcula a soma dos valores da diagonal de uma
matriz. 

*/
programa{
	//FUNCAO PRINCIPAL
	funcao inicio(){

		//DECLARACAO DE VARIAVEIS

		//Definicao do tamanho do vetor
		const inteiro tamanhoMatrizLinha = 2, tamanhoMatrizColuna = 2
		real matriz[tamanhoMatrizLinha][tamanhoMatrizColuna], soma = 0.0


		//PROCESSAMENTO DE DADOS

		//Verificacao de matriz quadrada
		se (tamanhoMatrizLinha==tamanhoMatrizColuna){
			//Looping para preenchimento da matriz
			para (inteiro i=0;i<tamanhoMatrizLinha;i++){
				para (inteiro j=0;j<tamanhoMatrizColuna;j++){
					escreva("digite o valor da ",i+1,"º linha e ",j+1,"º coluna :")
					leia(matriz[i][j])
					escreva("\n")
				}
			}
			//Looping para soma da diagonal da matriz
			para (inteiro i=0;i<tamanhoMatrizLinha;i++){
				para (inteiro j=0;j<tamanhoMatrizColuna;j++){
	
					se (i==j){
						soma += matriz[i][j]
					}
				}
			}

			//SAIDA DE DADOS

			//Escrevendo o resultado da soma da diagonal
			limpa()
			escreva("A soma da diagonal é: ",soma,"\n")		
		}
		senao{
			//Escrevendo que a matriz nao e quadrada e portanto nao e possivel calcular a diagonal
			limpa()
			escreva("A matriz informada não é quadrada")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1221; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */