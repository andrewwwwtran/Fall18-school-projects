d(enter,b).
d(b,e).
d(e,b).

d(b,c).
d(c,b).

d(c,d).
d(d,c).

d(d,e).
d(e,d).

d(e,exit).
cheese(c).

path(A, B):-
          d(A, W),d(W, B);
          d(A, W),d(W,X),d(X,B);
          d(A,W),d(W,X),d(X,Y),d(Y,B),(cheese(W);cheese(X);cheese(Y));
          d(A,W),d(W,X),d(X,Y),path(Y,B),(cheese(W);cheese(X);cheese(Y)).
