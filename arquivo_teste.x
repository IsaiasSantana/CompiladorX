function int soma ( int a, int b ){
	-(a+b)
}

procedure testando(){
	if ( a < b)then{
		if (j = k) then{
		}else{
			if (k < p) then{
			}else if( y = j) then{
				j := 1 + 1;
			}
		}
	}
}


// triangulos

// perimetro
function real perimetro(real[] lados){
	lados[0] + lados[1]+lados[2]
}

// area
function real area(real base, real altura){
	1.5
}

// equilatero
function bool equilatero(real[] lados){
	if (lados[0] = lados[1] and lados[1] = lados[2]) then true else false
}

// isoceles
function bool isoceles(real[] lados){
	if ((lados[0] = lados[1] and lados[0] < lados[2]) or (lados[0] = lados[2] and lados[0] < lados[1]) or (lados[1] = lados[2] and lados[1] < lados[0]) ) then true else false
}

// escaleno
function bool escaleno(real[] lados){
	if (lados[0] < lados[1] and lados[1] < lados[2] and lados[0] < lados[2]) then true else false
}

procedure main(){	
	var real[3] tri := [3.3,3.3,3.3];
	print(perimetro(tri));
	print(equilatero(tri));
	print(escaleno(tri));
	print(isoceles(tri));
	print(area(3.3,3.3));
}