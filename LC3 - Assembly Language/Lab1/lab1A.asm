.ORIG x3000	;Start at x3000
AND R2, R2, #0	;Clear R2
LD R1, x0FE	;Load [x3100] into R1
AND R2, R1, #1	;Put least significant bit of R1 into R2
ST R2, x0FD	;Store R2 in 3101
HALT
.END
