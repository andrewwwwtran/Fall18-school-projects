#enter through b
d(enter, b).
d(c, b).
d(b, c).
d(c, d).
d(d, c).
d(b, e).
d(e, b).
d(d, e).
d(e, d).
d(f, e).
d(e, f).
d(exit, e).
d(X, Y) :- d(X, Z), d(Z, Y).
