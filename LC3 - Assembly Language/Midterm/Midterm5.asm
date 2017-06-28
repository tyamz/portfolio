.ORIG x3000
AND R0, R0, #0	;Clear R0 to be used as a constant
LD R1, x0FE	;Load bit pattern into R1
LD R2, x0FE	;Load n (number of times to shift/rotate)
LD R3, A
NOT R2, R2
ADD R2, R2, #1
ADD R3, R3, R2
LOOP AND R4, R4, #0
ADD R1, R1, #0
BRp NEXT
ADD R4, R0, #1
NEXT ADD R1, R1, R1
ADD R1, R1, R4
ADD R3, R3, #-1
BRp LOOP
ST R1, x0F5
HALT
A .FILL #16
.END