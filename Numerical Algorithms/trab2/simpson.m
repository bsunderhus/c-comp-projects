function Itr = simpson(Y,h)
  Itr = h/3*(Y(1)+4*(sum(Y(2:2:end-1))) +2*(sum(Y(3:2:end-1)))+Y(end));
end
