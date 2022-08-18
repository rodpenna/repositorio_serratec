/*
SERRATEC - 
DEV: RODRIGO PENNA
TURMA: 06, PETROPOLIS

TRABALHO - Questao 08
8. Elabora um programa que peça ao usuário que entre com 10 números. Após solicite que o usuário
escolha se quer que sejam impressos os números em ordem crescente ou decrescente e conforme
a escolha do usuário e faça a impressão da série.


*/
programa{
	
	funcao inicio(){
		
		//DECLARACAO DE VARIAVEIS
		//Definindo o tamanho do vetor
		const inteiro tamanhoVetor = 50

		inteiro tamanhoUsuario=0
		real vetorEntrada[tamanhoVetor],aux
		caracter resp,resp2
		logico primeiro = verdadeiro

		//ENTRADA DE DADOS
		escreva("Programa Organizador de Vetores\n")
		escreva("Oque deseja fazer com o vetor?\n")
		escreva("\n[ 'T'amanho | 'E'ntrar valor | 'V'isualizar | 'S'air ]:  ") 
		leia(resp2)

		faca{
			escolha(resp2){
				caso 'T':
					limpa()
					escreva("Defina o tamanho do vetor [max:  ",tamanhoVetor,"]:  ")
					leia(tamanhoUsuario)
					escreva("\n")

					limpa()
					escreva("Tamanho do vetor alterado com sucesso")
					pare
				caso 'E':
					limpa()
					se (tamanhoUsuario!=0){
						para(inteiro i=0;i<tamanhoUsuario;i++){
							escreva("Entre com o ",i+1,"º número : ")
							leia(vetorEntrada[i])
							escreva("\n")
						}
						limpa()
						escreva("Os valores foram adicionados ao vetor com sucesso")
						primeiro = falso
					}
					senao{
						escreva("Primeiro defina um 'T'amanho para o vetor")
					}

				
					pare
				caso 'V':
					limpa()
					//DAQUI PRA BAIXO 
					se ((tamanhoUsuario!=0 ou primeiro!=verdadeiro)){

							//Menu para selecionar a opcao de visualizacao
							limpa()
							escreva("Qual ordem deseja visualizar o vetor digitado?")
							escreva("\n[ 'C'rescente | 'D'ecrescente ]: ")
							leia(resp)
					
						
							escolha(resp){
								caso 'C':
									//Looping para organizar o vetor de forma crescente
									para (inteiro i=0;i<tamanhoUsuario;i++){
										para(inteiro j=i;j<tamanhoUsuario;j++){
											se (vetorEntrada[i]>vetorEntrada[j]){
												aux = vetorEntrada[i]
												vetorEntrada[i] = vetorEntrada[j]
												vetorEntrada[j] = aux
											}
										}	
									}
					
									limpa()
									escreva("O vetor escrito de forma crescente e o seguinte: \n\n")
									//Looping para exbir o vetor organizado
									para(inteiro i=0;i<tamanhoUsuario;i++){
											escreva(vetorEntrada[i],"  ")
									}
									pare
					
								caso 'D':
									//Looping para organizar o vetor de forma decrescente
									para (inteiro i=0;i<tamanhoUsuario;i++){
										para(inteiro j=i;j<tamanhoUsuario;j++){
											se (vetorEntrada[i]<vetorEntrada[j]){
												aux = vetorEntrada[i]
												vetorEntrada[i] = vetorEntrada[j]
												vetorEntrada[j] = aux
											}
										}	
									}
									
									limpa()
									escreva("O vetor escrito de forma decrescente e o seguinte: \n\n")
									//Looping para exbir o vetor organizado
									para(inteiro i=0;i<tamanhoUsuario;i++){			
										escreva(vetorEntrada[i],"  ")
									}
									pare
					
								caso contrario:
									limpa()
									escreva("Opção de visualização inválida\n")
									
									pare		
							}
						
						}
						senao{
							escreva("Primeiro defina o 'T'amanho do vetor e/ou 'E'ntre com os valores do vetor")
						}
						
					pare




					//DAQUI PRACIMA
				caso 'S':
					pare


					
				caso contrario:
					limpa()
					escreva("Entrada inválida, tente novamente")
					pare
			}


		escreva("\n\n---------\n")
		escreva("Oque deseja fazer com o vetor?")
		escreva("\n[ 'T'amanho | 'E'ntrar valor | 'V'isualizar | 'S'air ]: ") 
		leia(resp2)
		}enquanto(resp2!='S')

		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 455; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */