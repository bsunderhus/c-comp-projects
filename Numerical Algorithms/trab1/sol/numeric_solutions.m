function numeric_solutions(func,y0,x0,xn,h)

  %Create array X from x0 to xn with equaly spaced with a jump o h
  X = x0:h:xn;

  %calculate every numeric method
  Y.euler = euler(func.derived,y0,X);
  Y.euler_melhorado = euler_melhorado(func.derived,y0,X);
  Y.euler_modificado = euler_modificado(func.derived,y0,X);
  Y.runge_kutta_3rd = runge_kutta_3rd(func.derived,y0,X);
  [Y.runge_kutta_bogacki, Z.runge_kutta_bogacki] = runge_kutta_bogacki(func.derived,y0,X);

  %calculate the analytic solution for every point of X
  Y.analytics = func.analytics(X);

  %plot each method and the analytic solution
  plot(X,Y.analytics,
    X,Y.euler,
    X,Y.euler_melhorado,
    X,Y.euler_modificado,
    X,Y.runge_kutta_3rd,
    X,Y.runge_kutta_bogacki,
    X,Z.runge_kutta_bogacki);
  xlabel('x'); ylabel('y');
  legend('y(x)',
  'euler(x)',
  'euler-melhorado(x)',
  'euler-modificado(x)',
  'runge-kutta^{3rd}(x)',
  'runge-kutta-bogacki-Y',
  'runge-kutta-bogacki-Z');

  %calculate the errors
  error_euler = (Y.analytics - Y.euler);
  error_euler_melhorado = (Y.analytics - Y.euler_melhorado);
  error_euler_modificado = (Y.analytics - Y.euler_modificado);
  error_runge_kutta_3rd = (Y.analytics - Y.runge_kutta_3rd);
  error_runge_kutta_bogacki_Y = (Y.analytics - Y.runge_kutta_bogacki);
  error_runge_kutta_bogacki_Z = (Y.analytics - Z.runge_kutta_bogacki);
  fprintf("%30s\n","primeiros 5 pontos");
  fprintf("%10s|%10s|%10s\n","X","Y","Erros");
  fprintf("%21s|%10s|%10s|%10s|%10s|%10s|%10s\n","",
  "euler","euler mel","euler mod","runge 3rd","bogacki_Y","bogacki_Z");
  for i = 1:5
    fprintf("%10.5f|%10.5f|%10.5f|%10.5f|%10.5f|%10.5f|%10.5f|%10.5f\n",
    X(i),Y.analytics(i),error_euler(i),error_euler_melhorado(i),error_euler_modificado(i),
    error_runge_kutta_3rd(i),error_runge_kutta_bogacki_Y(i),error_runge_kutta_bogacki_Z(i));
  endfor
  fprintf("%30s\n","ultimos 5 pontos");
  fprintf("%10s|%10s|%10s\n","X","Y","Erros");
  fprintf("%21s|%10s|%10s|%10s|%10s|%10s|%10s\n","",
  "euler","euler mel","euler mod","runge 3rd","bogacki_Y","bogacki_Z");
  for i= length(X)-5:length(X)
    fprintf("%10.5f|%10.5f|%10.5f|%10.5f|%10.5f|%10.5f|%10.5f|%10.5f\n",
    X(i),Y.analytics(i),error_euler(i),error_euler_melhorado(i),error_euler_modificado(i),
    error_runge_kutta_3rd(i),error_runge_kutta_bogacki_Y(i),error_runge_kutta_bogacki_Z(i));
  endfor
end
