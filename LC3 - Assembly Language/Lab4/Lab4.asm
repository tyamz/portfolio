.ORIG x3000
;Input String and Save to Memory
LEA R1, MEMORYSPACE	; saves the address of the storage memory block
LOOP4 GETC	; input character -> r0
ADD R2, R0, #0
ADD R3, R2, #0
JSR CheckEnter
LD R5, RC
JSR Rotate
ADD R3, R3, #0
BRz JUMPI
GETC
ADD R3, R0, #0
JSR CheckEnter
ADD R2, R0, R2
JSR Encrypt
JUMPI STR R2, R1, #0	; r0 -> ( memory address stored in r1 + 0 )
ADD R1, R1, #1	; increments the memory pointer so that it always points at the next available block
ADD R3, R3, #0
BRnp LOOP4
LEA R0, MEMORYSPACE
PUTS
HALT

Rotate:
AND R6, R6, #0
RLOOP AND R4, R4, #0
ADD R2, R2, #0
BRp JUMPR
ADD R4, R6, #1
JUMPR ADD R2, R2, R2
ADD R2, R2, R4
ADD R5, R5, #-1
BRp RLOOP
RET

CheckEnter:
LD R4, ENTER
NOT R4, R4
ADD R4, R4, #1
ADD R3, R4, R3
BRnp JUMPC
LD R4, EOT
NOT R4, R4
ADD R2, R4, R2
JUMPC RET

Encrypt:
LD R4, K
ADD R2, R4, R2
ADD R0, R2, #0
LD R4, MASK1
AND R2, R4, R0
LD R5, EC1
ST R7, RETURN
JSR Rotate
ST R2, Reg8
LD R4, MASK2
AND R2, R4, R0
LD R5, EC2
JSR Rotate
ST R2, Reg9
LD R4, MASK3
AND R2, R4, R0
LD R4, Reg9
ADD R2, R4, R2
LD R4, Reg8
ADD R2, R4, R2
LD R7, RETURN
RET

RC .FILL x08
EC1 .FILL x04
EC2 .FILL x0C
K .FILL x07
ENTER .FILL x0A
EOT .FILL x05
MASK1 .FILL xF000
MASK2 .FILL x000F
MASK3 .FILL x0FF0
MEMORYSPACE .BLKW 10 ; declares empty space to store the string
Reg8 .BLKW 1
Reg9 .BLKW 1
RETURN .BLKW 1
.END