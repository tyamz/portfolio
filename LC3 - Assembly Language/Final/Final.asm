.ORIG x3000
TRAP X23
AND R3, R3, #0
ADD R3, R3, #9

LD R4, NASCIID
LD R5, NHEXDIF
LD R1, NCONSD
ADD R1, R1, R0
BRz GETNUMS
LD R1, NCONSX
ADD R1, R1, R0
BRnp FAIL
ADD R3, R3, #6
GETNUMS TRAP X23
ST R0, CHAR1
TRAP X23
ST R0, CHAR2
LEA R6, CHAR1
AND R2, R2, #0
ADD R2, R2, #2

ADD R0, R0, #0
LOOP ADD R1, R3, #0
ADD R7, R0, #0
LPCUR ADD R0, R0, R7
ADD R1, R1, #-1
BRnp LPCUR
LDR R1, R6, #0
ADD R1, R1, R4
ADD R0, R0, R1
ADD R1, R1, R5
BRn DONECUR
ADD R0, R0, #-7
DONECUR ADD R6, R6, #1
ADD R2, R2, #-1
BRp LOOP

AND R2, R2, #0
ADD R2, R2, #8
LEA R3, RESEND
LD R4, ASCNUM
AND R5, R5, #0
ADD R5, R5, #1
STLP AND R1, R0, R5
BRp ONENUM
ADD R1, R4, #0
BRnzp STORCH
ONENUM ADD R1, R4, #1
STORCH ADD R5, R5, R5
STR R1, R3, #-1
ADD R3, R3, #-1
ADD R2, R2, #-1
BRp STLP
LD R0, RES
TRAP X22
FAIL HALT
CHAR1 .FILL x0
CHAR2 .FILL x0
ASCNUM .FILL x30
NHEXDIF .FILL xFFEF
NASCIID .FILL xFFD0
NCONSX .FILL xFF88
NCONSD .FILL xFFDD
RES .BLKW 8
RESEND .FILL x0
.END
