/* 
  Validation-predicates for different sudoku situations.
*/

:- module(
  sudokuValidation,
  [
    valid_line/1, 
    valid_rows/1, 
    valid_cols/1, 
    valid_blocks/1, 
    valid_blocks/3, 
    valid_sudoku/1
  ]).
      

% Checks for a line of 9 unique elements.
valid_line(Line) :- sort(Line,SortedLine), length(SortedLine,9).

% Validates a list of lists with rows of a sudoku.
valid_sudoku(S) :- 
  valid_rows(S),
  valid_cols(S),
  valid_blocks(S).

% Valiidates the rows of a given sudoku.
valid_rows(S) :-
  length(S, 9),
  valid_rows_recursive(S).

valid_rows_recursive([]).
valid_rows_recursive([H|T]) :-
  valid_line(H),
  valid_rows_recursive(T).
 
% Valiidates the columns of a given sudoku.
valid_cols(S) :-
  transpose(S, T),
  valid_rows(T).

% Validates the blocks of a complete sudoku.  
valid_blocks([As, Bs, Cs, Ds, Es, Fs, Gs, Hs, Is]) :-
  valid_blocks(As, Bs, Cs),
  valid_blocks(Ds, Es, Fs),
  valid_blocks(Gs, Hs, Is).

% Validates the blocks of three lines of a sudoku.  
valid_blocks(
  [X1, X2, X3, X4, X5, X6, X7, X8, X9],
  [Y1, Y2, Y3, Y4, Y5, Y6, Y7, Y8, Y9],
  [Z1, Z2, Z3, Z4, Z5, Z6, Z7, Z8, Z9]) :-
  valid_line([X1, X2, X3, Y1, Y2, Y3, Z1, Z2, Z3]),
  valid_line([X4, X5, X6, Y4, Y5, Y6, Z4, Z5, Z6]),
  valid_line([X7, X8, X9, Y7, Y8, Y9, Z7, Z8, Z9]).
  


% Transpose a matrix.
transpose([], []).
transpose([F|Fs], Ts) :-
    transpose(F, [F|Fs], Ts).

transpose([], _, []).
transpose([_|Rs], Ms, [Ts|Tss]) :-
        lists_firsts_rests(Ms, Ts, Ms1),
        transpose(Rs, Ms1, Tss).

lists_firsts_rests([], [], []).
lists_firsts_rests([[F|Os]|Rest], [F|Fs], [Os|Oss]) :-
        lists_firsts_rests(Rest, Fs, Oss).


  
:- begin_tests(validation).
    
test(valid_sudoku) :-
  valid_sudoku([
      [1,2,3,4,5,6,7,8,9],
      [4,5,6,7,8,9,1,2,3],
      [7,8,9,1,2,3,4,5,6],
      [2,3,4,5,6,7,8,9,1],
      [5,6,7,8,9,1,2,3,4],
      [8,9,1,2,3,4,5,6,7],
      [3,4,5,6,7,8,9,1,2],
      [6,7,8,9,1,2,3,4,5],
      [9,1,2,3,4,5,6,7,8]
    ]).
    

% Fail because of column
test(valid_sudoku, [fail]) :-
  valid_sudoku([
      [1,2,3,4,5,6,7,8,9],
      [1,2,3,4,5,6,7,8,9],
      [1,2,3,4,5,6,7,8,9],
      [1,2,3,4,5,6,7,8,9],
      [1,2,3,4,5,6,7,8,9],
      [1,2,3,4,5,6,7,8,9],
      [1,2,3,4,5,6,7,8,9],
      [1,2,3,4,5,6,7,8,9],
      [1,2,3,4,5,6,7,8,9]
    ]).
    
% Fail because of block
test(valid_sudoku, [fail]) :-
  valid_sudoku([
      [1,2,3,4,5,6,7,8,9],
      [2,3,4,5,6,7,8,9,1],
      [9,1,2,3,4,5,6,7,8],
      [3,4,5,6,7,8,9,1,2],
      [4,5,6,7,8,9,1,2,3],
      [5,6,7,8,9,1,2,3,4],
      [6,7,8,9,1,2,3,4,5],
      [7,8,9,1,2,3,4,5,6],
      [8,9,1,2,3,4,5,6,7]
    ]).

:- end_tests(validation).
