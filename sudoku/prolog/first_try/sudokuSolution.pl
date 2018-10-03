/*
  Implementation of sudoku-solution.
  Brute-Force implementation, tries to fail as early as possible.
  Still very slow. Especially on the hard-test.
*/

:- module(
  sudokuSolving,
  [
    solve_line/2, 
    solve_sudoku/2
  ]).

:- use_module(sudokuValidation).

permutate_line(L) :- permutation(L, [1,2,3,4,5,6,7,8,9]).

solve_line(X, Y) :- X = Y, permutate_line(Y).

solve_lines([As, Bs, Cs, Ds, Es, Fs, Gs, Hs, Is], [SAs, SBs, SCs, SDs, SEs, SFs, SGs, SHs, SIs]) :-
  solve_line(As, SAs),
  valid_blocks(SAs, Bs, Cs),
  solve_line(Bs, SBs),
  valid_blocks(SAs, SBs, Cs), 
  solve_line(Cs, SCs),
  valid_blocks(SAs, SBs, SCs),
  
  solve_line(Ds, SDs),
  valid_blocks(SDs, Es, Fs),
  valid_cols([SAs, SBs, SCs, SDs, Es, Fs, Gs, Hs, Is]),
  solve_line(Es, SEs),
  valid_blocks(SDs, SEs, Fs),
  valid_cols([SAs, SBs, SCs, SDs, SEs, Fs, Gs, Hs, Is]),
  solve_line(Fs, SFs),
  valid_blocks(SDs, SEs, SFs),
  valid_cols([SAs, SBs, SCs, SDs, SEs, SFs, Gs, Hs, Is]),
  
  solve_line(Gs, SGs),
  valid_blocks(SGs, Hs, Is),
  valid_cols([SAs, SBs, SCs, SDs, SEs, SFs, SGs, Hs, Is]),
  solve_line(Hs, SHs),
  valid_blocks(SGs, SHs, Is),
  valid_cols([SAs, SBs, SCs, SDs, SEs, SFs, SGs, SHs, Is]), 
  solve_line(Is, SIs),
  valid_blocks(SGs, SHs, SIs),
  valid_cols([SAs, SBs, SCs, SDs, SEs, SFs, SGs, SHs, SIs]).
  

solve_blocks([Xs, Ys, Zs], [SXs, SYs, SZs]) :-  
  solve_line(Xs, SXs),
  valid_blocks(SXs, Ys, Zs),
  solve_line(Ys, SYs),
  valid_blocks(SXs, SYs, Zs), 
  solve_line(Zs, SZs),
  valid_blocks(SXs, SYs, SZs).

solve_sudoku(S, X) :- 
  solve_lines(S, X),
  valid_sudoku(X).


% TESTING

:- begin_tests(solving).
    
test(smoketest) :-
  findall(X, solve_sudoku([
      [_,2,3,4,5,6,7,8,9],
      [4,5,6,7,8,9,1,2,3],
      [7,8,9,1,2,3,4,5,6],
      [2,3,4,5,6,7,8,9,1],
      [5,6,7,8,9,1,2,3,4],
      [8,9,1,2,3,4,5,6,7],
      [3,4,5,6,7,8,9,1,2],
      [6,7,8,9,1,2,3,4,5],
      [9,1,2,3,4,5,6,7,8]
    ], X), Xs),
  Xs == [[
      [1,2,3,4,5,6,7,8,9],
      [4,5,6,7,8,9,1,2,3],
      [7,8,9,1,2,3,4,5,6],
      [2,3,4,5,6,7,8,9,1],
      [5,6,7,8,9,1,2,3,4],
      [8,9,1,2,3,4,5,6,7],
      [3,4,5,6,7,8,9,1,2],
      [6,7,8,9,1,2,3,4,5],
      [9,1,2,3,4,5,6,7,8]
    ]].
    
test(simple_test) :-
  findall(X, solve_sudoku([
      [_,2,3,4,5,6,7,8,9],
      [4,5,6,7,8,9,1,2,3],
      [7,8,9,1,2,3,4,5,6],
      [2,3,4,5,6,7,8,9,1],
      [5,6,7,8,9,1,2,3,4],
      [8,9,1,2,3,4,5,6,7],
      [3,4,5,6,7,8,9,1,2],
      [6,7,8,9,1,2,3,4,5],
      [9,1,2,3,4,5,6,7,_]
    ], X), Xs),
  Xs == [[
      [1,2,3,4,5,6,7,8,9],
      [4,5,6,7,8,9,1,2,3],
      [7,8,9,1,2,3,4,5,6],
      [2,3,4,5,6,7,8,9,1],
      [5,6,7,8,9,1,2,3,4],
      [8,9,1,2,3,4,5,6,7],
      [3,4,5,6,7,8,9,1,2],
      [6,7,8,9,1,2,3,4,5],
      [9,1,2,3,4,5,6,7,8]
    ]].    
    
test(corner_test) :-
  findall(X, solve_sudoku([
      [_,2,3,4,_,6,7,8,_],
      [4,5,6,7,8,9,1,2,3],
      [7,8,9,1,2,3,4,5,6],
      [2,3,4,5,6,7,8,9,1],
      [_,6,7,8,_,1,2,3,_],
      [8,9,1,2,3,4,5,6,7],
      [3,4,5,6,7,8,9,1,2],
      [6,7,8,9,1,2,3,4,5],
      [_,1,2,3,_,5,6,7,_]
    ], X), Xs),
  Xs == [[
      [1,2,3,4,5,6,7,8,9],
      [4,5,6,7,8,9,1,2,3],
      [7,8,9,1,2,3,4,5,6],
      [2,3,4,5,6,7,8,9,1],
      [5,6,7,8,9,1,2,3,4],
      [8,9,1,2,3,4,5,6,7],
      [3,4,5,6,7,8,9,1,2],
      [6,7,8,9,1,2,3,4,5],
      [9,1,2,3,4,5,6,7,8]
    ]].


% Block-tests result are multiple, but getting one expected result is sufficent now.
test(easy_sudoku_blocks1) :-
  solve_blocks(
    [
      [_,_,_,2,6,_,7,_,1],
      [6,8,_,_,7,_,_,9,_],
      [1,9,_,_,_,4,5,_,_]
    ],
    [
      [4,3,5,2,6,9,7,8,1],
      [6,8,2,5,7,1,4,9,3],
      [1,9,7,8,3,4,5,6,2]
    ]), !.


test(easy_sudoku_blocks2) :-
  solve_blocks(
    [
      [_,_,_,2,6,_,7,_,1],
      [6,8,_,_,7,_,_,9,_],
      [1,9,_,_,_,4,5,_,_]
    ],
    [
      [4,3,5,2,6,9,7,8,1],
      [6,8,2,5,7,1,4,9,3],
      [1,9,7,8,3,4,5,6,2]
    ]), !.

test(easy_sudoku_blocks3) :-
  solve_blocks(
    [
      [_,_,9,3,_,_,_,7,4],
      [_,4,_,_,5,_,_,3,6],
      [7,_,3,_,1,8,_,_,_]
    ],
    [
      [5,1,9,3,2,6,8,7,4],
      [2,4,8,9,5,7,1,3,6],
      [7,6,3,4,1,8,2,5,9]
    ]), !.

        
test(easy_sudoku) :-
  findall(X, solve_sudoku([
      [_,_,_,2,6,_,7,_,1],
      [6,8,_,_,7,_,_,9,_],
      [1,9,_,_,_,4,5,_,_],
      [8,2,_,1,_,_,_,4,_],
      [_,_,4,6,_,2,9,_,_],
      [_,5,_,_,_,3,_,2,8],
      [_,_,9,3,_,_,_,7,4],
      [_,4,_,_,5,_,_,3,6],
      [7,_,3,_,1,8,_,_,_]
    ], X), Xs),
  Xs == [[
      [4,3,5,2,6,9,7,8,1],
      [6,8,2,5,7,1,4,9,3],
      [1,9,7,8,3,4,5,6,2],
      [8,2,6,1,9,5,3,4,7],
      [3,7,4,6,8,2,9,1,5],
      [9,5,1,7,4,3,6,2,8],
      [5,1,9,3,2,6,8,7,4],
      [2,4,8,9,5,7,1,3,6],
      [7,6,3,4,1,8,2,5,9]
    ]].
        
test(hard_sudoku) :-
  findall(X, solve_sudoku([
      [_,_,_,_,_,_,8,2,_],
      [1,_,_,6,7,_,_,9,_],
      [3,_,_,8,4,_,_,_,_],
      [_,4,9,_,3,_,_,_,7],
      [_,_,_,_,6,_,5,_,_],
      [2,_,_,_,_,_,_,_,3],
      [_,7,2,_,_,4,_,_,_],
      [_,_,_,_,_,_,9,_,8],
      [6,_,_,_,_,_,_,1,_]
    ], X), Xs),
  Xs == [[
      [4,5,7,9,1,3,8,2,6],
      [1,2,8,6,7,5,3,9,4],
      [3,9,6,8,4,2,7,5,1],
      [8,4,9,5,3,1,2,6,7],
      [7,3,1,2,6,8,5,4,9],
      [2,6,5,4,9,7,1,8,3],
      [9,7,2,1,8,4,6,3,5],
      [5,1,4,3,2,6,9,7,8],
      [6,8,3,7,5,9,4,1,2]
    ]].
    
:- end_tests(solving).
