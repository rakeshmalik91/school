;GCD OF 2 NUMBERS
;INPUT	: 00A0H, 00A1H
;OUTPUT	: 00BOH
	LXI H, 00A0H
	MOV B, M
	INX H
	MOV C, M
LOOP:	MOV A, B
	CMP C 
	JC ELSE
	SUB C
	MOV B, A
	JMP ENDIF
ELSE:	MOV A, C
	SUB B
	MOV C, A
ENDIF:	MOV A, B
	CMP C
	JNZ LOOP
	STA 00B0H
	HLT