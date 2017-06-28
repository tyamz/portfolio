.ORIG x3000
AND R0, R0, #0	;Clear R0 to be used as a constant
LD R1, x0FE	;Load bit pattern into R1
LD R2, x0FE	;Load n (number of times to shift/rotate)
LD R3, x0FE	;Load the switch (will decide whether to Shift/Rotate; if 0, it will shift, if not 0, it will rotate)
ADD R3, R3, #0	;Flag setup
BRnp #4
AND R4, R4, #0
ADD R1, R1, #0
BRp #1
ADD R4, R0, #1
ADD R1, R1, R1
ADD R3, R3, #0
BRnp #1
ADD R1, R1, R4
ADD R2, R2, #-1
BRp #-12
ST R1, x0F1
HALT
.END