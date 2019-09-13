%
%Dado o PVI
%y'= sen(x) + cos(x),
%y(pi)=1
%Solução analitica:
%y(x) = sen(x) - cos(x)
%

func.derived = @(x,y)sin(x)+cos(x);
func.analytics = @(x)sin(x)-cos(x);
y0=1;
x0=pi;
xn=20;
h=0.1;

numeric_solutions(func,y0,x0,xn,h);

disp ("PVI: y'= sen(x) + cos(x)");
disp ("     y(pi)=1");
disp ("Solucao analitica: y(x) = sen(x) - cos(x)");
