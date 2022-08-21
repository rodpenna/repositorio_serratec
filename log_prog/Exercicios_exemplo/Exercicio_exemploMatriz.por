/*SERRATEC

EXEMPLO 2:

Preencha uma matriz que entre com duas notas de tres alunos e armazene a media e diga se o aluno esta aprovado

REFERENCIA

COLUNA INDICE 0 = CODIGO DO ALUNO
COLUNA INDICE 1 = PRIMEIRA NOTA DO ALUNO
COLUNA INDICE 2 = SEGUNDA NOTA DO ALUNO
COLUNA INDICE 3 = MEDIA FINAL DO ALUNO


INDICES DA LINHA = CODIGO DOS ALUNOS, CADA LINHA REPRESENTA UM ALUNO

*/

programa{
	
	funcao inicio(){

		//	 1 DECLARACAO DE VARIAVEIS
		const inteiro tamanhoColuna = 4
		const inteiro tamanhoLinha = 3

		real matrizTeste[tamanhoLinha][tamanhoColuna]




		//	2 ENTRADA DE DADOS

		//BLOCO DE CODIGO PARA PREENCHIMENTO DE MATRIZES
		//PREENCHENDO PRIMEIRO AS LINHAS
		para (inteiro i=0; i<tamanhoLinha ; i++ ){
			para (inteiro j = 0 ; j<tamanhoColuna ; j++){
				escolha(j){
					caso 0:
						limpa()
						escreva("Digite o codigo do ",i+1,"° aluno: ")
						leia(matrizTeste[i][j])

						pare
						
					caso 1:
						limpa()
						escreva("Digite a primeira nota do ",i+1,"° aluno: ")
						leia(matrizTeste[i][j])
						pare

					caso 2:
						limpa()
						escreva("Digite a segunda nota do ",i+1,"° aluno: ")
						leia(matrizTeste[i][j])
						pare

					caso 3:
						matrizTeste[i][j] = ( matrizTeste[i][j-2] + matrizTeste[i][j-1] ) / 2
						pare						
				}
			}
		}


		//	3 PROCESSAMENTO DE DADOS E SAIDA	
		//Preenchimento para saida de dados
		limpa()
		para (inteiro i=0; i<tamanhoLinha ; i++ ){
			
				se (matrizTeste[i][3] >= 5){
					escreva("\nO aluno de codigo ",matrizTeste[i][0]," foi aprovado")
				}
				senao{
					escreva("\nO aluno de codigo ",matrizTeste[i][0]," reprovado")
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
 * @POSICAO-CURSOR = 1354; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {matrizTeste, 27, 7, 11};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */