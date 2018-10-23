edge(a,b).
edge(b,c).
edge(c,d).
edge(d,e).
edge(b,e).
edge(d,f).
edge(c,f).
path(X,Y) :- edge(Z,Y), path(X,Z).
path(X,X).
