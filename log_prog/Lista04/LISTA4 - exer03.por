//SERRATEC - 
//DEV: RODRIGO PENNA
//TURMA: 06, PETROPOLIS

//LISTA EXERCICIO 4 - 03
/*3 - Utilize a função do exercício 1 para verificar se 5 alunos conseguiram média
acima de 7 para passar no curso de programação. ( crie uma nova função para dizer
se os alunos passaram ou não ) :
Exemplo de entrada: 

Número de alunos : 5 
Digite a nota 1 do aluno 1 : 5 
Digite a nota 2 do aluno 1 : 9 
...
Saída esperada: Aluno 1 passou

Digite a nota 1 do aluno 2 :  

*/

programa
{
	funcao real mediaAluno (real n1, real n2){
		retorne (n1+n2)/2
	}

	funcao verificarNota(real media, inteiro aluno){
		const real mediaMinima = 7.0
		se (media>=mediaMinima) {
			escreva ("\nO Aluno ",aluno, " passou\n\n")
		}
		senao{
			escreva ("\nO Aluno ",aluno, " não passou\n\n")
		}
	}

	funcao inicio(){
		real n1, n2
		const inteiro totalAluno = 5
		
		para (inteiro i=1;i<=totalAluno;i++){
			
			escreva("Digite o primeiro número: ")
			leia (n1)
			escreva("Digite o segundo número: ")
			leia (n2)
			verificarNota(mediaAluno(n1,n2),i)
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 835; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */