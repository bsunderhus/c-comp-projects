%
%Dado o PVI
%2y’  + 4y = 3 --> y'=(3-4y)/2
%y(1) = -4
%Solução analitica:
%y(x) = 3/4 - 19/4*e^(2-2*x)
%

func.derived = @(x,y)(3-4*y)/2;
func.analytics = @(x)(3/4 - 19/4.*e.^(2-2.*x));
y0=-4;
x0=1;
xn=5;
h=0.1;

numeric_solutions(func,y0,x0,xn,h);

disp ("PVI: y'=(3-4y)/2");
disp ("     y(1) = -4");
disp ("Solucao analitica: y(x) = 3/4 - 19/4*e^(2-2*x)");
