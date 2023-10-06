public class Instr
{
	public static void br(int instr, int[] reg)
	{
		int cond = instr >> 0x9;
		int offset = instr & 0x1ff;
		if (cond == reg[R.COND])
		{
			reg[R.PC] += Util.sign_extend(offset, Util.NINE_BIT);
		}
	}

	public static void and(int instr, int[] reg)
	{
		int imm5 = (instr >> 0x5) & 0x1;
		int dst = (instr >> 0x8) & 0x7;
		int sr1 = (instr >> 6) & 0x7;
		if (imm5 != 0)
		{
			int operand = instr & 0xf;
			reg[dst] = reg[sr1] & Util.sign_extend(operand, Util.FIVE_BIT);
		}
		else
		{
			int sr2 = instr & 0x7;
			reg[dst] = reg[sr1] & reg[sr2];
		}
		Util.setc(reg[dst], reg);
	}
}
