public class Lc3
{
	static int MEMORY_MAX = 1 << 16;
	static int[] memory = new int[MEMORY_MAX];
	static int[] reg = new int[R.COUNT];
	static int[] program = {
		0x0003,
		0x5230,
		0x0502,
		0xd000
	};

	static void load_image(int[] image, int[] mem)
	{
		int pc_start = image[0];
		int i = 1;
		while (i < image.length)
		{
			mem[pc_start++] = image[i++];
		}
	}


	public static void main(String[] args)
	{
		load_image(program, memory);
		reg[R.PC] = 0x0003;
		boolean running = true;

		System.out.println("PC started!");
		while(running)
		{
			int instr = memory[reg[R.PC]++];
			int opcode = instr >> 12;

			switch(opcode)
			{
				case Opcode.BR:
					Instr.br(instr, reg);
					break;
				case Opcode.ADD:
				  break;
				case Opcode.LD:
				  break;
				case Opcode.ST:
				  break;
				case Opcode.JSR:
				  break;
				case Opcode.AND:
					Instr.and(instr, reg);
				  break;
				case Opcode.LDR:
					break;
				case Opcode.STR:
					break;
				case Opcode.RTI:
					break;
				case Opcode.NOT:
				  break;
				case Opcode.LDI:
				  break;
				case Opcode.STI:
				  break;
				case Opcode.RES:
					System.out.println("illegal opcode!");
					System.exit(0);
				  break;
				case Opcode.LEA:
				  break;
				case Opcode.TRAP:
				  break;
			}
		}
	}
}
