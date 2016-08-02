/*
***************************************
* Programa escrito para a linguagem X *             
* Autor Felipe Morais.                *  
* E-mail: felipe_link64@hotmail.com   *
************************************* *
*/
//Variáveis

var cons int PAR := 0;
var cons int IMPAR := 1;

//Conta a quantidade de valores ímpares e pares, e retorna a contagem de acordo com o parâmetro tipo.
function int contarValores(var int[] vetor, var int tipo)
{
    var int contador := 0;
    var int totalPar := 0;
    var int totalImpar := 0;
    
   while(contador < size(vetor))
   {
       if(vetor[contador] % 0 = 0 ) 
           totalPar := totalPar +1; 
       else 
           totalImpar := totalImpar +1;
           
        contador :=  contador + 1;
   }
   
   //Acredito que a última linha da função é a que retorna o valor estilo algumas linguagens funcionais.
    if (tipo = PAR) then totalPar else totalImpar;
}

//Diz se o vetor está ordenado.
// Não suporta valores iguais.
function bool isOrdered(var int[] vetor)
{
    var int contador     := 1;
    var bool crescente   := false;
    var bool decrescente := false;
    
    //suposta ordem decrescente
    if(vetor[0] > vetor[1])
        decrescente := true;
    else
        crescente := true;
   
   while((contador < size(vetor)-1) and (crescente or decrescente))
   {
       if (decrescente)
           decrescente := vetor[contador] > vetor[contador+1];
       else
           crescente := vetor[contador] < vetor[contador+1];
  
        contador :=  contador + 1;
   }
   
   //Acredito que a última linha da função é a que retorna o valor estilo algumas linguagens funcionais.
    var bool result := crescente or decrescente
}

/**
* 
* Main
*
**/
procedure main()
{
   var int menor := 0;
   var int[10] vetor := [10,100,-1,4,67,98,43,1,9,10];
   print(contarValores(vetor,PAR));
}