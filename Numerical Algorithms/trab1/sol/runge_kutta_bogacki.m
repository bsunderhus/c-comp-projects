function [Y,Z] = runge_kutta_bogacki(f,y0,X)
  Y(1) = y0;
  Z(1) = y0;
  h = abs(X(2) - X(1));
  for i=1:length(X)-1
    k_1 = f(X(i),Y(i));
    k_2 = f(X(i) + 1/2*h, Y(i) + 1/2*h*k_1);
    k_3 = f(X(i) + h, Y(i) + h*(3/4*k_1 + 3/4*k_2));
    Y(i+1) = Y(i) + h*(2/9*k_1 + 1/3*k_2 +4/9*k_3);
    k_4 = f(X(i)+h,Y(i+1));
    Z(i+1) = Y(i) + h*(7/24*k_1 + 1/4*k_2 +1/3*k_3 + 1/8*k_4);
  endfor
end

%Butcher's table of bogacki
%  0  |  0   0   0
% 1/2 | 1/2  0   0
% 3/4 |  0  3/4  0
%  1  | 2/9 1/3 4/9
%------------------
% 2/9 | 1/3 4/9  0
% 7/24| 1/4 1/3 1/8
