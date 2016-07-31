/*
***************************************
* Programa escrito para a linguagem X *             
* Autor Isaías Santana.               *  
*                                     *
************************************* *
*/

//Variáveis
var bool booleano := true or false;
var int[10] vetor := [10,100,-1,4,67,98,43,1,9,10];

/* menor valor de um array*/
procedure menorValorVetor(var int[] vetor, int tamVetor, var int menorValor)
{
   var int menor := vetor[0];
   var int contador := 0;

   while(contador < tamVetor)
   {
     if(menor < vetor[contador]) menor := vetor[contador]; else {}
     contador :=  contador + 1;
   }
   menorValor := menor;  
}

// Acho que deve somar dois números.
function int soma( int a, int b) a + b; 

/**
* 
* Main
*
**/
procedure main()
{
   var int menor := 0;
   menorValorVetor(vetor,10,menor);
}