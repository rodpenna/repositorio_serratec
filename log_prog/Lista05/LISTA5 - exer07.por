//SERRATEC - 
//DEV: RODRIGO PENNA
//TURMA: 06, PETROPOLIS

//LISTA EXERCICIO 5 - 07
/*7 - Escreva uma função que multiplica duas matrizes.  

*/

programa{
	//FUNCAO PRINCIPAL
	funcao inicio(){

		//DECLARACAO DE VARIAVEIS

		//Definicao das linhas e colunas da matriz
		// c1 coluna da matrizA, l1 linha da matrizA ; c2 coluna da matrizB, l2 linha da matrizB
		const inteiro l1=2 , c1=2 , l2=2 , c2 = 3
		
		real matrizA[l1][c1],matrizB[l2][c2],matrizResultado[l1][c2],soma=0.0
		

		//ENTRADA DE DADOS

		escreva("Preencha os valores da primeira Matriz\n")
		//Looping para preenchimento da matrizA
		para (inteiro i=0;i<l1;i++){
			para(inteiro j=0;j<c1;j++){
				escreva("Digite o valor do elemento da ",i+1,"º linha e ",j+1,"º coluna: ")
				leia(matrizA[i][j])
			}
		}
		
		limpa()
		escreva("Preencha os valores da segunda Matriz\n")
		//Looping para preenchimento da matrizB
		para (inteiro l=0;l<l2;l++){
			para(inteiro p=0;p<c2;p++){
				escreva("digite o valor do elemento da ",l+1,"º linha e ",p+1,"º coluna","\n")
				leia(matrizB[l][p])
			}
		}
	
	
		//PROCESSAMENTO DE DADOS

		//Looping para calcular o produto de matrizes e atribuir o resultado a matrizResultado
		para (inteiro i=0;i<l1;i++){
			para (inteiro j=0;j<c2;j++){
				
				soma = 0.0
				
				para (inteiro k=0;k<c1;k++){
					soma += (matrizA[i][k] * matrizB[k][j])
				}
				matrizResultado[i][j] = soma
			}
		}

		//SAIDA DE DADOS

		
		limpa()
		escreva("A matriz resultado é: \n")
		//Looping para exibicao da matrizResultado
		para (inteiro i=0;i<l1;i++){
			para (inteiro j=0;j<c2;j++){
					escreva(matrizResultado[i][j]," ")
			}
			escreva("\n")
		}		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1514; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */