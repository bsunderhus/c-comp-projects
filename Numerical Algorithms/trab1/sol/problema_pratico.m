1;

function y = Q1(t)
  if(t>=0 && t<20)
    y = 110;
  elseif(t>=20 && t<40)
    y = 100;
  elseif(t>=40 && t<80)
    y = 95;
  elseif(t>=80 && t<=100)
    y = 110;
  endif
endfunction

function y = Q2(t)
  if(t>=0 && t<30)
    y = 100;
  elseif(t>=30 && t<40)
    y = 95;
  elseif(t>=40 && t<70)
    y = 105;
  elseif(t>=70 && t<=100)
    y = 85;
  endif
endfunction

function y = theta(t)
  if(t>=0)
    y=0;
  else
    y=t;
  endif
endfunction

function y = epsilon()
  y = (rand*6)-3;
endfunction

vazamento = @(t)(10 - (10 - 0)*exp(0.05*theta(50-t)));
EDO = @(t)(Q1(t)-Q2(t)-vazamento(t));


V0 = 500;
t0 = 0;
h = 1;
tn = 100;
X = t0:h:tn;

ruido = arrayfun(@epsilon,X);
deltaV = euler_modificado(EDO,V0,X) .- V0;

plot(X,arrayfun(@Q1,X),
     X,arrayfun(@Q2,X),
     X,arrayfun(vazamento,X),
     X,arrayfun(EDO,X) .+ ruido,
     X,ruido,
     X,deltaV);

xlabel('x'); ylabel('y');
legend('afluente', 'efluente', 'vazamento','Q','ruido', 'V-V0');
