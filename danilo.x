/*
***************************************
* Programa escrito para a linguagem X *             
* Autor Danilo Ramos.                 *
*                                     *  
************************************* *
*/
//função para calcular fatoriais na linguagem X
var int k := 0;
procedure fatorial(int n){
	if (0 < n) then{
		k := n - 1; 
		n := n * fatorial(k);
	}
	else{
		n:= n * 1;
	}
}

var int hexa := 0xF2;
var real quebrado := 1.22;