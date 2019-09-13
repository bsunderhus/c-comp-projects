function exemplo1



% Variável lógica que contém a informação, se está no ambiente Octave ou não
is_octave = exist('octave_config_info','builtin'); % Octave ou Matlab


% Função em forma de 'Função Anônima' para verificar, se
% coordenanda está dentro ou fora de círculo com raio um
% Negativo, se ponto (x,y) está dentro do círculo unitário
% Zero, se ponto (x,y) está na circunferência do círculo unitário
% Positivo, se ponto (x,y) está fora do círculo unitário
func = @(x,y) x.^2+y.^2-1;


x=0; y=0;
f = func(x,y);
imprimirResultado(f,x,y);

x=0.5; y=-0.3;
f = func(x,y);
imprimirResultado(f,x,y);

x=-1; y=0;
f = func(x,y);
imprimirResultado(f,x,y);

x=2; y=3;
f = func(x,y);
imprimirResultado(f,x,y);


% Função embutida dentro da função principal
function imprimirResultado(f,x,y)
	fprintf('O ponto (%.1f,%.1f) esta ',x,y);
	if f < 0
		fprintf('dentro ');
	elseif f > 0
		fprintf('fora ');
	else
		fprintf('na circunferencia ');
	end
	fprintf('do circulo com centro em (0,0) e raio um.\n');
end




end
