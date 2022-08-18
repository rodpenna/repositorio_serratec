//SERRATEC - 
//DEV: RODRIGO PENNA
//TURMA: 06, PETROPOLIS

//TRABALHO - Questao 01
/*1. Leia dois valores e efetue a divisão do primeiro pelo segundo. O segundo valor não pode ser ZERO
ou negativo, caso isso ocorra você deve informar ao usuário que o segundo número deve ser maior
do que ZERO e solicitar um novo valor. Deverá imprimir o resultado. Ao final deve perguntar se
deseja calcular outra divisão e caso sua resposta seja positiva limpe a tela e solicite novos valores 	


*/

programa{

	
	//FUNCAO PRINCIPAL
	funcao inicio(){

		//DECLARACAO DE VARIAVEIS
		
		real n1,n2
		caracter perg='C'


		faca{
			//ENTRADA DE DADOS
			//Entrando com o primeiro e segundo valor
			se (perg=='C'){
				limpa()
				escreva("Digite o valor do primeiro número: ")
				leia (n1)
					
				escreva("Digite o valor do segundo número: ")
				leia(n2)
				
				
				//Verificacao da condicao pedida no exercicio. n2 > 0 e looping ate obter o valor valido					
				enquanto(n2<=0){
					limpa()
					escreva("Valor inválido informado para o segundo número\n")
					escreva("\n\nInforme um novo valor para o segundo número maior que zero: ")
					leia(n2)
				}

				//PROCESSAMENTO E SAIDA DE DADOS
				
				limpa()
				//Exibindo o valor da divisao dos numero inseridos
				escreva("O resultado da divisão de ",n1," por ",n2," é: ",n1/n2,"\n")
			}
			senao{
				limpa()
				escreva("Entrada inválida, digite novamente oque deseja fazer\n")
			}
		escreva("\n\n['C'ontinuar | 'S'air]: ")
		leia(perg)
		}enquanto(perg!='S')				
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 612; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */