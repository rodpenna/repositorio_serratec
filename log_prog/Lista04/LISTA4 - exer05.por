//SERRATEC - 
//DEV: RODRIGO PENNA
//TURMA: 06, PETROPOLIS

//LISTA EXERCICIO 4 - 05
/*5 - Escreva um programa que calcule o número de dígitos de um dado número usando
recursão:
Exemplo de entrada: 100
Saída esperada: O número de dígitos do número é : 2 

*/
programa{
	
	funcao contadorDigito (inteiro numero){
		
		inteiro cont = 0

		faca{
		cont++
		numero = numero/10
			
		}enquanto(numero!=0)

		escreva("A soma total é: ",cont)
	}
	

	funcao contadorDigito2 (inteiro numero, inteiro cont){
		

		se (numero!=0){
		cont++ 
		contadorDigito2(numero/10,cont)
		}
		senao{
		escreva("\nA soma total dos digitos é: ",cont,"\n")
		}
	}
	
	funcao inicio()
	{
		inteiro numero
		inteiro iniciar = 0

		escreva("Escreva o numero: ")
		leia(numero)

		contadorDigito2(numero,iniciar)
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 640; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */