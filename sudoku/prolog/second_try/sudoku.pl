/*
  Example by Markus Triska, taken from the SWI-Prolog manual.
  Amazing how elegent this can be solved and how much faster
  this is on problem 2.
  
  Example:
    ?- problem(1, X), sudoku(X), print(X).
*/

:- use_module(library(clpfd)).

sudoku(Rows) :-
        length(Rows, 9), maplist(same_length(Rows), Rows),
        append(Rows, Vs), Vs ins 1..9,
        maplist(all_distinct, Rows),
        transpose(Rows, Columns),
        maplist(all_distinct, Columns),
        Rows = [A,B,C,D,E,F,G,H,I],
        blocks(A, B, C), blocks(D, E, F), blocks(G, H, I).

blocks([], [], []).
blocks([A,B,C|Bs1], [D,E,F|Bs2], [G,H,I|Bs3]) :-
        all_distinct([A,B,C,D,E,F,G,H,I]),
        blocks(Bs1, Bs2, Bs3).

problem(1, [[_,_,_, _,_,_, _,_,_],
            [_,_,_, _,_,3, _,8,5],
            [_,_,1, _,2,_, _,_,_],

            [_,_,_, 5,_,7, _,_,_],
            [_,_,4, _,_,_, 1,_,_],
            [_,9,_, _,_,_, _,_,_],

            [5,_,_, _,_,_, _,7,3],
            [_,_,2, _,1,_, _,_,_],
            [_,_,_, _,4,_, _,_,9]]).

problem(2, [[_,_,_, _,_,_, 8,2,_],
            [1,_,_, 6,7,_, _,9,_],
            [3,_,_, 8,4,_, _,_,_],
            
            [_,4,9, _,3,_, _,_,7],
            [_,_,_, _,6,_, 5,_,_],
            [2,_,_, _,_,_, _,_,3],
            
            [_,7,2, _,_,4, _,_,_],
            [_,_,_, _,_,_, 9,_,8],
            [6,_,_, _,_,_, _,1,_]]).
