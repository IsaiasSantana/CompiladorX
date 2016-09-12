/*
***************************************
* Programa escrito para a linguagem X *             
* Autor Felipe Morais.                *  
* E-mail: felipe_link64@hotmail.com   *
************************************* *
*/
//Variáveis

var int totalPar := 0;
var int totalImpar := 1;
var int contador := 0;

//Conta a quantidade de valores ímpares e pares, e retorna a contagem de acordo com o parâmetro tipo.
procedure contarValores(var int[] vetor)
{    
   while(contador < size(vetor))
   {
       if(vetor[contador] % 2 = 0 ) 
           totalPar := totalPar +1; 
       else 
           totalImpar := totalImpar +1;
           
        contador :=  contador + 1;
   }
}

function bool isEven( int a) a % 2 = 0
/**
* 
* Main
*
**/
procedure main()
{
   var int menor := 0;
   var int[10] vetor := [10,100,-1,4,67,98,43,1,9,10];
   contarValores(vetor)
   print(totalPar);
}