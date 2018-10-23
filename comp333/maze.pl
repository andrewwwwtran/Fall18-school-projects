#facts
d(enter,b).
d(b,e).
d(b,c).
d(c,d).
d(d,e).
d(e,exit).

start(enter).
finish(exit).

path(X,X,[]).
path(X,Z,[X-Y|Steps]) :- d(X,Y), path(Y,Z,Steps).

solve(L) :- start(X), finish(Y), path(X,Y,L).
