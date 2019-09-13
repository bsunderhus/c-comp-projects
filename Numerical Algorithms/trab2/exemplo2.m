%%
f = @(x)e.^(-x);
F = @(x)-e.^(-x);

X = 0:3;
Y = f(X);
n = 10;

numeric_solutions(f,F,X,Y,n,"f(x) = e^-^x");
