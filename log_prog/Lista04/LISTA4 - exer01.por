//SERRATEC - 
//DEV: RODRIGO PENNA
//TURMA: 06, PETROPOLIS

//LISTA EXERCICIO 4 - 01
/*1 - Escreva uma função que recebe 2 números e calcule a média entre eles :
Exemplo de entrada: 
Digite o primeiro número: 2 
Digite o segundo número : 6
Saída esperada:
A média é : 4 

*/

programa
{
	funcao real media (real n1, real n2){

		retorne (n1+n2)/2
	}

	funcao inicio()
	{
		real n1, n2

		escreva("Digite o primeiro número: ")
		leia (n1)
		escreva("Digite o segundo número: ")
		leia (n2)

		escreva("\nA média entre os números é: ", media(n1,n2),"\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 288; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */