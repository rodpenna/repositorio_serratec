/*
SERRATEC - 
DEV: RODRIGO PENNA
TURMA: 06, PETROPOLIS

TRABALHO - Questao 05
5. Desenvolva um programa no qual o usuário informa 10 números e programa responde qual é o
menor, o maior e a média dos valores.

*/
programa{
	//FUNCAO PRINCIPAL
	funcao inicio(){

		//DECLARACAO DE VARIAVEL
		//Definicao do tamanho do vetor
		const inteiro tamanhoVetor = 10
		
		real maior=0.0,menor=99999.9,media,soma=0.0,vetor[tamanhoVetor]


		//ENTRADA DE VALOR
		
		//Looping para preenchimento do vetor e analises de maior, menor e soma dos valores
		para (inteiro i = 0;i<tamanhoVetor;i++){
			escreva("Digite o valor do ",i+1,"° elemento do vetor: ")
			leia(vetor[i])	
			escreva("\n")	
			se (vetor[i]>=maior){
				maior = vetor[i]
			}
			se (vetor[i]<=menor){
				menor = vetor[i]
			}
			soma += vetor[i]
		}
		//Calculo da media do vetor
		media = soma/tamanhoVetor

		//SAIDA DE DADOS
		limpa()
		escreva("A media do vetor é: ",media)
		escreva("\nO maior valor é: ",maior)
		escreva("\nO menor valor é: ",menor,"\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 864; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */