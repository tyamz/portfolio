.ORIG x3000	;Start Program at x3000
LEA R1, x0FF	;Load x3100 into R1
AND R2, R2, #0	;Clear R2
AND R5, R2, #0	;Clear R5
LDR R4, R1, #0	;Load the value from the address listed in R1
ADD R4, R4, #0	;Add 0 to R4 and store in R4 to check if it is 0
BRz #05		;Check if R4 is 0 yet
ADD R2, R2, #1	;Increment the counter
ADD R5, R4, #-1	;Store R4 - 1 in R5
AND R4, R4, R5	;Hamming Weight
BRnzp #-6	;Keep going back to (ADD R4, R4, #0) until R4 = 0

ST R2, x0F7	;Store R2 (Counter) in x3102
HALT

.END