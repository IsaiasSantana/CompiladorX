//função para calcular fatoriais na linguagem X
function int fatorial(int n){
	if (0 < n){
		n * fatorial(n-1);
	}
	else{
		1;
	}
}