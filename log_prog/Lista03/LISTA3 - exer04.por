//SERRATEC - 
//DEV: RODRIGO PENNA
//TURMA: 06, PETROPOLIS

//LISTA EXERCICIO 3 - 04
/*4 - Escreva um programa que imprima o padrão de uma pirâmide de asteriscos dado
um número n.
Exemplo de entrada:
4 Saída esperada:
* * * *
* * * *
* *    */

programa{
	funcao inicio(){
		//DECLARACAO DE VARIAVEL
		inteiro numero
		inteiro i = 1
				
		//ENTRADA DE DADOS
		escreva("Digite um valor para n: ")
		leia(numero)

		//PROCESSAMENTO E SAIDA DE DADOS
		se (numero>=0){
			enquanto (i<=numero){
				para (inteiro ii = numero - 1 ; ii>=1 ; ii-- ){
					escreva(" ")
				}
				para (inteiro ii=1;ii<=i;ii++){
					escreva("*")
				}
				escreva("\n")
				i += 1
			}
		}
		senao{
				escreva("\nErro de preenchimento\n")	
		}
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