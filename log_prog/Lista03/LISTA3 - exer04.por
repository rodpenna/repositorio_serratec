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
	
	funcao inicio()
	{
		inteiro x , z , resp

		
		escreva("Digite um numero inteiro de para n: ")
		leia(x)

	
		escreva("Digite o modo de visualização: [ 1 | 2 | 3 | 4 Mudar n | 0 - sair ] ")
		leia(resp)

		faca{
		
			escolha(resp){
	
				caso 1:
					limpa()
		
					para (inteiro i=0;i<x;i++){
						para(inteiro j=x;j>i;j--){
							escreva(" ")			
						}
						para (inteiro j = 0; j<= i; j++){
							escreva("*")
						}
						para (inteiro j=0;j<i;j++){
							escreva("*")
						}
						escreva("\n")		
					}
					
					pare
		
		
				caso 2:	
					limpa()	
					z=1	
					enquanto (z<=x){
						para (inteiro ii = x - 1 ; ii>=1 ; ii-- ){
							escreva(" ")
						}
						para (inteiro ii=1;ii<=z;ii++){
							escreva("*")
						}
						escreva("\n")
						z += 1
					}
					pare
	
				caso 3:
					limpa()
					z=1
					enquanto (z<=x){
						
						para (inteiro ii=1;ii<=z;ii++){
							escreva("*")
						}
						escreva("\n")
						z += 1
					}
					
					
					pare
				caso 4:
					limpa()
					escreva("Digite um numero inteiro de para n: ")
					leia(x)
					limpa()
					pare

					
				caso contrario:
					limpa()
					escreva("Erro de preenchimento")
					pare
	
			}
		escreva("\n\n----------------------\n")
		escreva("Digite o modo de visualização: [ 1 | 2 | 3 | 4 Mudar n | 0 - sair ] ")
		leia(resp)
		}enquanto(resp!=0)
	}

}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1351; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */