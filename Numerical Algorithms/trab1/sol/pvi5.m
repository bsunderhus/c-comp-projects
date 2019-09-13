%
%Dado o PVI
%y' = 1/3x² − y
%y(1) = 3
%Solução analitica:
%y(x) = (1/3)*e^(-x)*(e^(x)*(x^2 -2*x + 2)+8*e)
%

func.derived = @(x,y)(1/3*x^2-y);
func.analytics = @(x)((1/3)*e.^(-x).*(e.^(x).*(x.^2 -2.*x+2)+8*e));
y0=3;
x0=1;
xn=5;
h=0.1;

numeric_solutions(func,y0,x0,xn,h);

disp ("PVI: y' = 1/3x²−y");
disp ("     y(1) = 3");
disp ("Solucao analitica: y(x) = (1/3)*e^(-x)*(e^(x)*(x^2 -2*x + 2)+8*e)");
