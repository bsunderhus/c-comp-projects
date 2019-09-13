
func = @(x,y)x.^2;
X = [0,1,2,3];
Y = func(X);

RANGE = X(1):(X(end)-X(1))/20:X(end);
[S_x,S_y] = splines(X,Y,RANGE);

plot(
  RANGE,func(RANGE),
  RANGE,vandermonde(X,Y,RANGE),
  X,Y,".", "markersize", 10,
  S_x,S_y
  );
xlabel('x');
ylabel('y');
legend('funcao','vandermonde','pontos','splines');
