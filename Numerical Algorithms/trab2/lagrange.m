function y = lagrange(X,Y,x)
  y = [];
  for j = 1:length(x)
    x0 = x(j);
    L = getL(X,x0);
    y(j) = 0;
    for i = 0:length(X)-1
      y(j) += L(i+1)*Y(i+1);
    endfor
  endfor
end

function L = getL(X,x)
  L = [];
  for i = 0:length(X)-1
    L(i+1) = L_i(X,x,i);
  endfor
end

function l_i = L_i(X,x,i)
  l_i = 1;
  for j=0:length(X)-1
    if j != i
      l_i *= (x-X(j+1))/(X(i+1)-X(j+1));
    endif
  endfor
end
