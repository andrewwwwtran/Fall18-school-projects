#facts
door(in,b).
door(b,e).
door(b,c).
door(c,d).
door(d,e).
door(e,f).
door(f,e).
door(c,b).
door(e,out).

path(A,B) :- door(A,C), path(C,B).
