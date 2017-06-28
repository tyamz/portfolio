.ORIG x3000
AND R3, R3, #0	;Count Down from 9 (Limited to 9 Guesses)
ADD R3, R3, #9
AND R5, R5, #0	;Counter for number of guesses
BACK IN		;Accept Input
ADD R3, R3, #-1
ADD R5, R5, #1
LD R4, ASCII	;Used to Convert from ASCII to Integer
NOT R4, R4
ADD R4, R4, #1
AND R1, R1, #0
AND R2, R1, #0
ADD R1, R1, R0	;Put R0 into R1 just in case we need R0 later (which we won't, but just in case)
ADD R1, R4, R1	;Convert from ASCII to Integer
ADD R2, R2, #6
NOT R2, R2
ADD R2, R2, #1
ADD R1, R1, R2	;Check if Integer is 6 or not
BRz JUMP1	;If it is 6, it will become 0 when subtracted by 6.
BRn JUMP2	;If it is less than 6, it will become negative when subtracted by 6.
BRp JUMP3	;If it is greater than 6, it will stay positive when subtracted by 6.

;Correct Answer
JUMP1 LEA R0, RIGHT	;If it is 6, that is correct.
PUTS
AND R0, R0, #0
ADD R0, R5, R0
LD R4, ASCII
ADD R0, R4, R0
OUT
LEA R0, RIGHT1
PUTS
HALT

;Wrong Answer #1: Too small.
JUMP2 LEA R0, SMALL	;If it's less than 6.
PUTS
ADD R3, R3, #0	;Flag for Countdown
BRnp BACK	;This is to make sure that all 9 guess are NOT yet used up.
ADD R3, R3, #0	;Flag for Countdown
BRz DONE	;This is if all 9 guesses are used up.

;Wrong Answer #2: Too big.
JUMP3 LEA R0, BIG	;If it's greater than 6.
PUTS
ADD R3, R3, #0	;Flag for Counter
BRnp BACK	;This is to make sure that all 9 guess are NOT yet used up.
ADD R3, R3, #0	;Flag for Counter
BRz DONE	;This is if all 9 guesses are used up.

;Game Over: Too many guesses.
DONE LEA R0, GAME	;When all 9 guesses are used up, the game is over and the answer is given.
PUTS
HALT
RIGHT .STRINGZ "Correct! You took "
RIGHT1 .STRINGZ " guesses!"
SMALL .STRINGZ "Too small."
BIG .STRINGZ "Too big."
GAME .STRINGZ "Game Over. Correct answer is 6!"
ASCII .FILL x30
.END