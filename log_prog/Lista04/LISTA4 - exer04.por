//SERRATEC - 
//DEV: RODRIGO PENNA
//TURMA: 06, PETROPOLIS

//LISTA EXERCICIO 4 - 04
/*4 - Escreva um programa que imprima os 50 primeiros números naturais usando
recursão :
Saída esperada Os números naturais
são : 1 2 3   

*/
programa
{
	
	funcao imprimirNumero(inteiro end, inteiro start){
		
		escreva (start,"\n")

		se (end>start){
			imprimirNumero(end,start+1)
		}
	}
	
	funcao inicio()
	{
		inteiro end = 5
		inteiro start = 1

		//escreva("Digite numero: ")
		//leia (n)
		imprimirNumero(end,start)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 84; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */