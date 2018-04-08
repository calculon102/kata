/*
  Prolog-solution for riddle "Knights, Knaves & Spies":

  On the fabled Island of Knights and Knaves, we meet three people, A, B, and
  C, one of whom is a knight, one a knave, and one a spy. The knight always
  tells the truth, the knave always lies, and the spy can either lie or tell
  the truth.

  A says: "C is a knave."
  B says: "A is a knight."
  C says: "I am the spy."

  Who is the knight, who the knave, and who the spy?

  Source:
  https://en.wikibooks.org/wiki/Puzzles/Logic_puzzles/Knights,_Knaves_%26_Spies
  
  Usage:    
  ?- solve(A, B, C).
*/

says(knight, Truth, Truth).
says(knave, Actual, Lie) :- Actual \= Lie.
says(spy, _, _).

unique(A, B, C) :- A \= B, A \= C, B \= C.

solve(A, B, C) :- 
  says(A, C, knave),
  says(B, A, knight),
  says(C, C, spy),
  unique(A, B, C), !.


/*
  Second part:
  https://en.wikibooks.org/wiki/Puzzles/Logic_puzzles/Knights,_Knaves_%26_Spies_II
  
  The spy C looks for an answer, which would give a permutation that does not
  blame him as a actual spy. The term below does that. 
  
  Usage:    
  ?- solve(A, B, C).
*/

denies(knave, Truth, Truth).
denies(knight, Actual, IsNot) :- Actual \= IsNot.
denies(spy, _, _).

solve2(A,B,C) :-
  denies(A, A, spy),
  says(B, B, spy),
  denies(C, C, spy),
  C \= spy,
  unique(A, B, C).


  
