/* FizzBuzz-Kata made in Prolog. Just for fun. */

% Basic rules.
is_fizz(X) :- X mod 3 =:= 0.
is_buzz(X) :- X mod 5 =:= 0.
is_fizzbuzz(X) :- is_fizz(X), is_buzz(X).

% FizzBuzz-relations.
fizzbuzz(X, 'FizzBuzz') :- is_fizzbuzz(X), !.
fizzbuzz(X, 'Fizz') :- is_fizz(X), !.
fizzbuzz(X, 'Buzz') :- is_buzz(X), !.
fizzbuzz(X, X).

% Apply FizzBuzz on a list.
fizzbuzz_list([],[]).
fizzbuzz_list([I|Is], [O|Os]) :- fizzbuzz(I, O), fizzbuzz_list(Is, Os).

% Example-Usage: 
% ?- findall(I, between(1, 100, I), Is), fizzbuzz_list(Is, Os), print(Os).

