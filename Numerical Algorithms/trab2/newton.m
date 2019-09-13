function y = newton(X,Y,x)
  y = [];
  for i = 1:length(x)
    x0 = x(i);
    y(i) = 0;
    for n = 1: length(X)
      x_acc = 1; #(x-x0)(x-x1)...(x-xn-1)
      for j = 1: n-1
        x_acc *= x0-X(j);
      endfor
      y(i) += divided_diff(X(1:n),Y(1:n))*x_acc;
    endfor
  endfor
end

function y = divided_diff(X,Y)
  if length(Y) == 1
    y = Y(1);
    return
  endif
  y = (divided_diff(X(2:end),Y(2:end)) - divided_diff(X(1:end-1),Y(1:end-1)))/(X(end)-X(1));
end
