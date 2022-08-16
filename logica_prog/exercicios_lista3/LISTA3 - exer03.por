//SERRATEC - 
//DEV: RODRIGO PENNA
//TURMA: 06, PETROPOLIS

//LISTA EXERCICIO 3 - 03
/*3 - Escreva um programa que imprima o seguinte padrão de número em formato de
triângulo dado um número n.
Exemplo de entrada: 4 
Saída esperada:
1 12 123 1234    */

programa{
	funcao inicio(){
		//DECLARACAO DE VARIAVEL
		real numero
		inteiro i = 1
				
		//ENTRADA DE DADOS
		escreva("Digite o número para criar o triângulo: ")
		leia(numero)

		//PROCESSAMENTO E SAIDA DE DADOS
		se (numero>=0)
		{
			enquanto (i<=numero)
			{
				para (inteiro ii=1 ; ii<=i ;	ii++ )
				{
					escreva(ii)
				}
				escreva("\n")
				i += 1 // MESMA COISA QUE: i = i + 1
			}
		}
		senao
		{
				escreva("\nErro de preenchimento\n")	
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 605; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */