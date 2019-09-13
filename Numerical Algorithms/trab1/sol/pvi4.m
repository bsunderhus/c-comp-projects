%
%Dado o PVI
%y’= 3x² − 2x,
%y(1) = 3
%Solução analitica:
%y(x) = x^3-x^2+3
%

func.derived = @(x,y)(3*(x^2)-2*x);
func.analytics = @(x)(x.^3-x.^2+3);
y0=3;
x0=1;
xn=5;
h=0.1;

numeric_solutions(func,y0,x0,xn,h);

disp ("PVI: y'= 3x^2 − 2x");
disp ("     y(1) = 3");
disp ("Solucao analitica: y(x) = x^3-x^2+3");
