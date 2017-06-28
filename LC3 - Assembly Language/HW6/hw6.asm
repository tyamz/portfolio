.ORIG x3000
AND R0, R0, #0	;Clear R0 to be used as a constant
LD R1, x0FE	;Load bit pattern into R1
AND R5, R5, #1
AND R2, R2, #0
AND R7, R2, #0
ADD R2, R2, #3
ADD R7, R7, #8
ADD R7, R7, #8
NOT R2, R2
ADD R2, R2, #1
ADD R2, R7, R2
AND R4, R4, #0
ADD R1, R1, #0
BRp #1
ADD R4, R0, #1
ADD R1, R1, R1
ADD R1, R1, R4
ADD R5, R5, R5
ADD R5, R5, #1
ADD R2, R2, #-1
BRp #-9
AND R1, R5, R1
HALT
.END