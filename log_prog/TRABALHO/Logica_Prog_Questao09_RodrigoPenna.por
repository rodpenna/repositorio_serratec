/*
SERRATEC - 
DEV: RODRIGO PENNA
TURMA: 06, PETROPOLIS

TRABALHO - Questao 09
9. Elabore um programa que calcule uma equação do 2° Grau modelo ax2+bx+c. Solicite a entrada das
variáveis a, b, c e calcule as raízes. Apresente no final do cálculo a equação composta pelas
variáveis lidas e o resultado. Ex. Entrada a=1, b=-5, c=6. 


Saída 1x^2 -5x –6 =0 -> X1=3 X2=2


*/
programa{

	//Incluindo a biblioteca MATEMATICA para poder fazer o calculo da raiz quadrada
	inclua biblioteca Matematica --> mat

	//FUNCAO PRINCIPAL
	funcao inicio(){

		//DECLARACAO DE VARIAVEIS
		
		real A,B,C,delta,x1,x2

		//ENTRADA DE DADOS
		
		escreva("Escreva o primeiro coeficiente: ['a'x²]: ")
		leia(A)
		escreva("Escreva o segundo coeficiente:  ['b'x]: ")
		leia(B)
		escreva("Escreva o terceiro coeficiente: ['c']: ")
		leia(C)

		//Calculo do delta
		delta = (B*B -4*A*C)

		//Validacao do delta
		se (delta>=0){

			//Calculo das raizes
			x1 =	(-B + mat.raiz(delta,2.0))/(2*A)

			x2 =	(-B - mat.raiz(delta,2.0))/(2*A)

			//SAIDA DE DADOS
			
			limpa()
			//Exibicao da equacao completa
			escreva("A equação é: ",A,"x² ",B,"x ",C," = 0")
			//Exibicao das raizes
			escreva("\n\nAs raizes são: X1= ",x1,"  e  X2= ",x2,"\n")	
		}
		senao{
			limpa()
			//Resposta negativa, caso delta <0
			escreva("\nNão existem raizes reais")	
		}		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 78; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */