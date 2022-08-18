/*
SERRATEC - 
DEV: RODRIGO PENNA
TURMA: 06, PETROPOLIS

TRABALHO - Questao 03
3. Escreva um programa que leia 10 nomes de alunos e duas notas de avaliações para cada aluno.
Calcule e escreva a média de cada aluno, seguido da informação se foi aprovado ou reprovado.
Considere como média para aprovação 6. Dica: Utilize quantos vetores precisar. 
Ex. Saída: Fulano de tal P1= 8.0, P2=6.0, Media=7.0, aprovado!


*/
programa{
	//FUNCAO PRINCIPAL
	funcao inicio()
	{

		//DECLARAÇAO DE VARIAVEL

		//Definicao do numero de alunos
		const inteiro tamantoVetor = 10
		//Definicao da media minima para aprovacao
		const real mediaMin = 6.0
		
		caracter perg='C'

		cadeia nomeAluno,vetorAluno[tamantoVetor],vetorSituacao[tamantoVetor]
		real n1,n2,vetorNota1[tamantoVetor],vetorNota2[tamantoVetor]

		 
		//ENTRADA DE DADOS		 

		faca{


			escolha(perg){

				caso 'C':
					limpa()			
					//Looping para preenchimento de nome e nota de alunos								
					para(inteiro i=0;i<tamantoVetor;i++){
						limpa()
						escreva("Digite o nome do ",i+1,"° aluno: ")
						leia(nomeAluno)
						limpa()
						escreva("Digite a primeira nota do ",i+1,"° aluno: ")
						leia(n1)

						//Validacao da nota enviada
						enquanto (n1>10){
							limpa()
							escreva("Erro de preenchimento na nota\n")
							escreva("Digite uma nota de no máximo 10 para a primeira nota do aluno: ")
							leia(n1)
						}

						limpa()
						escreva("Digite a segunda nota do ",i+1,"° aluno: ")
						leia(n2)
						//Validacao da nota enviada
						enquanto (n2>10){
							limpa()
							escreva("Erro de preenchimento na nota\n")
							escreva("Digite uma nota de no máximo 10 para a segunda nota do aluno: ")
							leia(n2)
						}

						//Implementando valores nos vetores de nota
						vetorNota1[i]=n1
						vetorNota2[i]=n2

						//Implementando valor no vetor nome
						vetorAluno[i]=nomeAluno

						//Verificacao de aprovacao ou nao e preenchimento do vetor
						se (((n1+n2)/2)>=mediaMin){
							vetorSituacao[i] = "Aprovado"
						}
						senao{
							vetorSituacao[i] = "Reprovado"
						}
					}
					limpa()
					escreva("Notas de todos os alunos cadastrados com sucesso\n")
					pare

				//Visualizar a situacao dos alunos
				caso 'V':
					limpa()
					para (inteiro i =0;i<tamantoVetor;i++){	
							escreva(vetorAluno[i],"   Nota 1: ",vetorNota1[i],"   Nota2: ",vetorNota2[i],"   Média: ", (vetorNota1[i]+vetorNota2[i])/2," foi   ",vetorSituacao[i],"\n")
					}										
					pare
			}
			
			escreva("\n-----------")
			escreva("\nOque deseja fazer? \n['C'adastrar | 'V'isualizar | 'S'air ]: ")
			leia(perg)
		}enquanto(perg!='S')
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 2226; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */