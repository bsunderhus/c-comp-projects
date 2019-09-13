%
%
F = @(x)(x.^6)/6 + (x.^5)/5 + (x.^4)/4;
f = @(x)x.^5 + x.^4 + x.^3;

X = 0:3;
Y = f(X);
n = 10;

numeric_solutions(f,F,X,Y,n,"f(x) = x^5 + x^4 + x^3");
