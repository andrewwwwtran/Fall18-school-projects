change(H, Q, D, N, P) :-
member(H, [0, 1]),
member(Q, [0, 1, 2, 3]),
member(D, [0, 1, 2, 3, 4, 5]),
member(N, [0]),
member(P, [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]),
S is 50 * H + 25 * Q + 10 * D + 5 * N + 1 * P,
S = 100.
