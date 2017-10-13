% FizzBuzz-Kata made in Prolog. Just for fun.


% Basic rules.
fizz(X) :- X mod 3 =:= 0.
buzz(X) :- X mod 5 =:= 0.


% Ordered testing of business-rules with output.
fizzbuzz_element(X) :- fizz(X), buzz(X), write('FizzBuzz').
fizzbuzz_element(X) :- fizz(X), write('Fizz').
fizzbuzz_element(X) :- buzz(X), write('Buzz').
fizzbuzz_element(X) :- write(X).


% Solution giving a list as single parameter.
%
% Example:
% ?- fizzbuzz_list([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]).
%
fizzbuzz_list([]).
fizzbuzz_list([H|T]) :-
  fizzbuzz_element(H), 
  write('\n'),
  fizzbuzz_list(T).


% Solution giving a range from X to Y
%
% Example:
% ?- fizzbuzz_range(1,100).
%
fizzbuzz_range(X, Y) :- X > Y.
fizzbuzz_range(X, Y) :- 
  fizzbuzz_element(X),
  write('\n'),
  X1 is X+1, 
  fizzbuzz_range(X1, Y).

