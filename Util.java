public class Util
{
	public static int FL_POS = 1 << 0;
	public static int FL_ZRO = 1 << 1;
	public static int FL_NEG = 1 << 2;

	public static int FIVE_BIT = 0x5;
	public static int NINE_BIT = 0x9;

	public static int sign_extend(int n, int bit_count)
	{
		if ((n >> (bit_count - 1) & 0x1) != 0)
		{
			n &= ~(1 << (bit_count - 1));
			return ~n + 1;
		}
		return n;
	}

	public static void setc(int dst, int[] reg)
	{
		if (dst < 0)
		{
			reg[R.COND] = FL_NEG;
		}
		else if (dst == 0)
		{
			reg[R.COND] = FL_ZRO;
		}
		else
		{
			reg[R.COND] = FL_POS;
		}
	}
}
