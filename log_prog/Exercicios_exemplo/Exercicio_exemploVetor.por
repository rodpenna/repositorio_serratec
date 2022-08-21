programa
{
	
	funcao inicio()
	{
		//DECLARACAO DE VARIAVEIS
		
		const inteiro tamanhoVetor = 2
				
		real vetorNota1[tamanhoVetor], vetorNota2[tamanhoVetor] , vetorMedia[tamanhoVetor]
		cadeia vetorNome[tamanhoVetor]

		real soma = 0.0 , media



		//ENTRADA DE DADOS


		//Preenchimento de vetor		
		para(inteiro i = 0; i<tamanhoVetor ; i++ ){
			
				escreva("Digite a nota 1 do ",(i+1),"º Aluno")
				leia(vetorNota1[i])
				
				escreva("\nDigite a nota 2 do ",(i+1),"º Aluno")
				leia(vetorNota2[i])

				escreva("\nDigite o nome do ",(i+1),"º Aluno")
				leia(vetorNome[i])

				vetorMedia[i] = vetorNota1[i] + vetorNota2[i] / 2
		}

		
		//PROCESSAMENTO E SAIDA DE DADOS
		
		escreva("\n\n---\n\n")
		para (inteiro i=0;i<tamanhoVetor;i++){
			//VERIFICACAO DE APROVACAO
			se ( vetorMedia[i] >= 7 ){
				escreva("O aluno ",vetorNome[i]," tirou na Nota1 ",vetorNota1[i]," e na Nota2 ",vetorNota2[i]," e ficou com media ",vetorMedia[i]," e foi Aprovado")
				escreva("\n")
			}
			senao {
				se (vetorMedia[i] >= 4 ){
					escreva("O aluno esta em recuperação")
				}
				senao{
					escreva("O aluno ",vetorNome[i]," tirou na Nota1 ",vetorNota1[i]," e na Nota2 ",vetorNota2[i]," e ficou com media ",vetorMedia[i]," e foi Reprovado")
					escreva("\n")
				}
			}
		}
	escreva("\n\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 755; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {vetorNota1, 10, 7, 10};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */