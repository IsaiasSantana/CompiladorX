/* int real bool true false if then else while procedure function cons var 
intint realreal boolbool truetrue falsefalse ifif thenthen elseelse whilewhile procedureprocedure functionfunction conscons varvar

 coment�rio


// coment�rio linha
:= / + - * % < = and or ! |
[] {} () ; ,
12 -12 1.1 -1.1 1e2 1e-2 1E2 1E-2 1.1e2 1.1e-2 1.1E-2 1.1E+2 0xabcdef */

/*
***************************************
* Programa escrito para a linguagem X *             
* Autor Isaias Santana.               *  
*                                     *
************************************* *
*/

//Vari�veis
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

// Acho que deve somar dois n�meros.
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