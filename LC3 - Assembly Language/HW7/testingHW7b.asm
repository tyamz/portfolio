.ORIG x3000
ONE LD R1, A
ADD R0, R1, R0
TWO LD R1, B
ADD R0, R1, R0
THREE LD R1, C
ADD R0, R1, R0
ST R0, SUM
TRAP x25
A .FILL x0001
B .FILL x0002
C .FILL x0003
SUM .FILL x0004 ;(Error: SUM should be D, this will be detected at assembly)
.END