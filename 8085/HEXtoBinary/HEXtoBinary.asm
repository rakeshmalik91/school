	LDA 00A0H
	MOV B, A
	MVI C, 08H
	LXI H, 00B0H
LOOP:	ANI 01H
	MOV M, A
	INX H
	MOV A, B
	RAR
	MOV B, A
	DCR C
	JNZ LOOP
	HLT