#@param X vetor de X para fazer a interpolação
#@param Y vetor de Y para fazer a interpolação
#@param x vetor de x a serem estimados
function y = vandermonde(X,Y,x)
  y = [];
  a = vander(X)\Y';
  y = polyval(a,x);
end
