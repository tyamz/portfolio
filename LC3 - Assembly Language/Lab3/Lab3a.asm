.ORIG x3000
AND R0, R0, #0 ;Z
LDI R1, A
ADD R1, R1, #0
BRnz FAIL
LDI R2, B
ADD R2, R2, #0
BRnz FAIL
NOT R2, R2
ADD R2, R2, #1
LOOP ADD R0, R0, #1
ADD R1, R1, R2
ADD R3, R1, R2
BRzp LOOP
STI R0, Z
STI R1, R
FAIL HALT

A .FILL x3100
B .FILL x3101
Z .FILL x3103
R .FILL x3104
.END