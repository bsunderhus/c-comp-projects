function numeric_solutions(f,F,X,Y,n,text)
  h = (X(end)-X(1))/n;
  RANGE = X(1):h:X(end);
  [S_x,S_y] = splines(X,Y,RANGE);

  analitica = f(RANGE);
  van = vandermonde(X,Y,RANGE);

  plot(
    RANGE,analitica,
    RANGE,van,
    S_x,S_y,
    X,Y,".", "markersize", 10,"color","red"
    );
  xlabel('x');
  ylabel('y');
  legend(text,'vandermonde','splines');

  f
  F
  fprintf("%32s\n","primeiros 5 pontos");
  fprintf("|%21s|%21s|%21s|\n","analitica","vandermonde","splines");
  fprintf("|%10s|%10s|%10s|%10s|%10s|%10s|\n","X","Y","X","Y","X","Y");
  for i = 1:5
    fprintf("|%10.5f|%10.5f|%10.5f|%10.5f|%10.5f|%10.5f|\n",
      analitica(i),RANGE(i),van(i),RANGE(i),S_y(i),S_x(i));
  endfor

  fprintf("%32s\n","ultimos 5 pontos");
  fprintf("|%21s|%21s|%21s|\n","analitica","vandermonde","splines");
  fprintf("|%10s|%10s|%10s|%10s|%10s|%10s|\n","X","Y","X","Y","X","Y");

  for i = length(RANGE)-5:length(RANGE)
    fprintf("|%10.5f|%10.5f|%10.5f|%10.5f|%10.5f|%10.5f|\n",
      analitica(i),RANGE(i),van(i),RANGE(i),S_y(i),S_x(i));
  endfor

  I = F(X(end))-F(X(1)); %Integral

  trapezios_vandermonde = trapezios(van,h);
  trapezios_splines = trapezios(S_y,h);
  simpson_vandermonde = simpson(van,h);
  simpson_splines = simpson(S_y,h);

  erros.vandermonde.trapezios = abs(I - trapezios_vandermonde);
  erros.splines.trapezios = abs(I - trapezios_splines);
  erros.vandermonde.simpson = abs(I - simpson_vandermonde);
  erros.splines.simpson = abs(I - simpson_splines);

  fprintf("\n%32s\n","Integral");
  fprintf("|%21s|%21s|%11s|\n","Trapezios","Simpson 1/3","F(B) - F(A)");
  fprintf("|%10s|%10s|%10s|%10s|%11.5f|\n","global","local","global","local",I);
  fprintf("|%10.5f|%10.5f|%10.5f|%10.5f|\n",trapezios_vandermonde,trapezios_splines,simpson_vandermonde,simpson_splines);

  fprintf("\n%32s\n","Erro da Integral");
  fprintf("|%21s|%21s|\n","Trapezios","Simpson 1/3");
  fprintf("|%10s|%10s|%10s|%10s|\n","global","local","global","local");
  fprintf("|%10.5f|%10.5f|%10.5f|%10.5f|\n",erros.vandermonde.trapezios,erros.splines.trapezios,erros.vandermonde.simpson,erros.splines.simpson);
end
