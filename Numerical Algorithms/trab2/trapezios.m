function Itr = trapezios(Y,h)
  Itr = h/2*(Y(1)+2*(sum(Y(2:end-1)))+Y(end));
end
