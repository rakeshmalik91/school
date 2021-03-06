;COUNT NUMBER ZEROS, POSITIVES, NEGATIVES
;INPUT	: 00A0H
;OUTPUT	: 00B0H <- NUMBER OF ZEROS
;	  00B1H <- NUMBER OF POSITIVE
;	  00B2H <- NUMBER OF NEGATIVE
	LXI H, 00A0H
	MOV C, M		;C <- NUMBER OF DATA
	INX H
	MVI B, 00H		;B <- NUMBER OF ZEROS
	MVI D, 00H		;D <- NUMBER OF POSITIVES
	MVI E, 00H		;E <- NUMBER OF NEGATIVES
L1:	MOV A, M
	ADI 00H
	JZ ZERO
	RLC
	JC NEG
	INR D
	JMP L1_END
NEG:	INR E
	JMP L1_END
ZERO:	INR B
L1_END:	INX H
	DCR C
	JNZ L1
	MOV A, B
	STA 00B0H
	MOV A, D
	STA 00B1H
	MOV A, E
	STA 00B2H
	HLT