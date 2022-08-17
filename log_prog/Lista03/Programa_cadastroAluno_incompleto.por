//SERRATEC - 
//DEV: RODRIGO PENNA
//TURMA: 06, PETROPOLIS

//Exercicio  ROD
/*Entre com o nome dos alunos e suas notas, de a media e diga se esta aprovado ou nao  */


programa{
	

	funcao cadeia cadastrarAluno(inteiro totalAluno){

		cadeia vetorNomeAluno[999]
		cadeia nomeAluno
		


		para (inteiro i=0;i<totalAluno;i++){
			escreva("Digite o nome do ",i+1 ,"° Aluno: ")
			leia (nomeAluno)
			vetorNomeAluno[i] = nomeAluno
		}
		
		retorne vetorNomeAluno[totalAluno]
		}

	funcao cadastrarNotas(inteiro totalAluno, real mediaMin){

		real matrizNotas[999][4]
		real nota
		
		para (inteiro i=0;i<totalAluno;i++){
			limpa()
			real soma=0.0
			
			para (inteiro ii=0;i<2;i++){
				escreva("Digite a ",ii+1 ,"° nota do ",i+1 ,"° Aluno: ")
				leia (nota)
				matrizNotas[i][ii] = nota
				soma +=nota
			
			}
			matrizNotas[i][2] = soma/2

			se ((soma/2)>=mediaMin){
				matrizNotas[i][3] = 1.0
			}
			senao{
				matrizNotas[i][3] = 0.0
			}
		}
		
		//retorne matrizNotas
		}
	
	funcao inicio(){
	
		caracter perg
		caracter perg2
		
		cadeia vetorNomeAluno[999999]
		real matrizNotas[999999][4]
		cadeia situacao
		
		inteiro totalAlunos = 0
		real mediaMin
		
		escreva("['C'adastrar Nome / 'L'ançar Nota / 'V'isualizar notas / 'S'air]")
		escreva ("Oque deseja fazer?")
		leia (perg)
		
		faca{

			escolha(perg){
				
				caso 'C':
					se (totalAlunos==0){

						escreva("Digite o total de Alunos: ")
						leia(totalAlunos)
					}
					senao{
						escreva("Deseja mudar o total de Alunos?: [y/n]")
						leia (perg2)

						se (perg2=='y'){
							escreva("Digite o total de Alunos: ")
							leia(totalAlunos)
						}	
					}
					
					vetorNomeAluno[totalAlunos] = cadastrarAluno(totalAlunos)//VARIAVEL PARA RECEBER VETOR NOME
					
					
					pare

				caso 'L':

					se (totalAlunos==0){
						escreva("Precisa cadastrar o nome dos alunos primeiro")
					
					}
					senao {
						escreva("Digite o valor da Media Minima para aprovação: ")
						leia(mediaMin)

						cadastrarNotas(totalAlunos,mediaMin)//VARIAVEL PARA RECEBER MATRIZ NOTAS
					}

					pare

				caso 'V':

					se (totalAlunos!=0){
						
						para (inteiro i=0;i<totalAlunos;i++){
							se ( matrizNotas[i][3]==1){
								situacao = "Aprovado"
							}
							senao{
								situacao ="Reprovado"
							}
							escreva("A media do ",vetorNomeAluno[i], " é ", matrizNotas[i][2]," e o aluno está: ",situacao," ! ")
						}
					
					}
				
			}




		escreva("\n\n------------------\n")
		escreva("['C'adastrar Nome / 'L'ançar Nota / 'V'isualizar notas / 'S'air]")
		escreva ("Oque deseja fazer?")
		leia (perg)
		}enquanto(perg!='S')
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 2436; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */