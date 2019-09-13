function Y = runge_kutta_3rd(f,y0,X)
  Y(1) = y0;
  h = abs(X(2) - X(1));
  for i=1:length(X)-1
    k_1 = f(X(i),Y(i));
    k_2 = f(X(i) + 1/2*h, Y(i) + 1/2*h*k_1);
    k_3 = f(X(i) + h, Y(i) + h*(-1*k_1 + 2*k_2));
    Y(i+1) = Y(i) + h*(1/6*k_1 + 2/3*k_2 +1/6*k_3);
  endfor
end


%Butcher's table of 3rd order
%  0  |  0   0   0
% 1/2 | 1/2  0   0
%  1  | -1   2   0
%------------------
%     | 1/6 2/3 1/6
