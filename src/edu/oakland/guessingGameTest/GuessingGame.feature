Feature:  The user plays the guessing game

Scenario:  The system makes the guess

Given the user has chosen a number in their head
Then the system selects the midpoint of the current range as the next guess
And the system displays options to the user on the screen
Then the user selects either "Higher," "Lower," or "Equal"
When the user selects "Higher"
Then the system uses the High-range
And the system makes another guess
When the user selects "Lower"
Then the system uses the Low-Range
And the system makes another guess
When the user selects "Equal"
Then the system tells the user that he or she has lost the game
When the system makes a guess
Then the system displays the current guess
And the system displays the number of guesses made
When the system exceeds the maximum number of guesses
Then the system tells the user that he or she has won the game