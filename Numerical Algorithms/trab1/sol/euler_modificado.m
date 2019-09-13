function [Y] = euler_modificado(f,y0,X)
	Y(1) = y0;
	h = abs(X(2) - X(1));
  for i=1:length(X)-1
		Y(i+1) = Y(i) + h*f(X(i)+(h/2),Y(i) + (h/2)*f(X(i),Y(i)));
  endfor
endfunction
