%%
f = @(x)sin(x)+cos(x);
F = @(x)sin(x)-cos(x);

X = 0:2*pi;
Y = f(X);
n = 20;

numeric_solutions(f,F,X,Y,n,"f(x) = sin(x)+cos(x)");
