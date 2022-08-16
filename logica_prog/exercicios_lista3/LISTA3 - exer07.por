//SERRATEC - 
//DEV: RODRIGO PENNA
//TURMA: 06, PETROPOLIS

//LISTA EXERCICIO 3 - 07
/*7 - Escreva uma função que insere um nome em uma mensagem automática :
Exemplo de entrada: Digite um nome : Fulano
Saída esperada:
Bom dia Fulano! 

*/
programa{
	funcao inicio(){
		cadeia palavra
		caracter perg = 'y'

		enquanto ((perg=='y' ou perg=='y')){

		escreva ("Digite a palavra desejada: ")
		leia (palavra)

		texto(palavra)

		escreva("\n----------\n")
		escreva("Deseja continuar? [y/n]")
		leia(perg)
		limpa()
		}
		escreva ("\nPrograma Finalizado\n")
	}
	funcao texto(cadeia palavra){
		escreva ("\nBom dia ", palavra, "!\n")
	}	
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 345; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */