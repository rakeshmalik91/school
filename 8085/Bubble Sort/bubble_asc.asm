	LXI H,00A0H
	MOV C,M
	DCR C
LOOP1:	MOV B,C
	LXI H,00A1H
LOOP2:	MOV A,M
	INX H
	MOV D,M
	CMP D
	JNC SWAP
	DCX H
	JMP ENDIF
SWAP:	MOV M,A
	DCX H
	MOV M,D
ENDIF:	INX H
	DCR B
	JNZ LOOP2
	DCR C
	JNZ LOOP1
	HLT