%
%Dado o PVI
%y’ = (x-2)³,
%y(2) = 1.
%Solução analitica:
%y(x) = (x^4)/4 - 2*x^3 + 6*x^2 -8*x + 5
%

func.derived = @(x,y)(x-2)^3;
func.analytics = @(x)((x.^4)./4 - 2.*x.^3 + 6.*x.^2 -8.*x + 5);
y0=1;
x0=2;
xn=5;
h=0.1;

numeric_solutions(func,y0,x0,xn,h);

disp ("PVI: y' = (x-2)^3");
disp ("     y(2) = 1");
disp ("Solucao analitica: y(x) = (x^4)/4 - 2*x^3 + 6*x^2 -8*x + 5");
