//SERRATEC - 
//DEV: RODRIGO PENNA
//TURMA: 06, PETROPOLIS

//LISTA EXERCICIO 4 - 02
/*2 - Escreva uma função que receba um ano e diga se ele é bissexto ou não e utilize
esta função para verificar :
Exemplo de entrada: 2017
Saída esperada: O ano 2017 não é bissexto 

*/
programa
{
	funcao calc_ano(inteiro ano){

		se (	(ano%400==0) ou
			(ano%4==0 e ano%100!=0)	
		){
			escreva("\nO ano ",ano," é bissexto\n")
		}
		senao {
			escreva ("\nO ano ",ano," não é bissexto\n")
		}
	}

	
	
	funcao inicio()
	{
		inteiro ano
		escreva("Entre com um ano: ")
		leia (ano)

		calc_ano(ano)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 480; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */