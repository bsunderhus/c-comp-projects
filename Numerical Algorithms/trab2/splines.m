function [x,y] = splines(X,Y,RANGE)
  x = [];
  y = [];
  splines.x = spline(X);
  splines.y = spline(Y);
  for r = RANGE(1:end-1)
    for i = 1:length(Y)-1
      if r >= X(i) && r < X(i+1)
        y(end+1) = polyval(splines.y(i,:),r-X(i));
        x(end+1) = polyval(splines.x(i,:),r-X(i));
        break;
      endif
    endfor
  endfor
  y(end+1) = polyval(splines.y(end,:),1);
  x(end+1) = polyval(splines.x(end,:),1);
end

function S_i = spline(V)
  n = length(V);
  M = sparse_matrix(n);
  S = b(V,n);
  D = M\S;
  S_i = [];
  for i = 1:length(D)-1
    a = V(i);
    b = D(i);
    c = 3*(V(i+1)-V(i)) -2*D(i)-D(i+1);
    d = 2*(V(i)-V(i+1))+D(i)+D(i+1);
    S_i(i,:) = [d,c,b,a];
  endfor
end


function M = sparse_matrix(n)
  M = gallery("tridiag",n,1,4,1);
  M(1,1) = 2;
  M(n,n) = 2;
end

function M = b(V,n)
  threes = ones(n,1)*3;
  M(1) = V(2)-V(1);
  M(n) = V(n) - V(n-1);
  for i = 2:n-1
    M(i) = V(i+1)-V(i-1);
  endfor
  M = threes.*M';
end
