package CH02.exam;

/**
 * 실습 2-8[A]
 * 기수변환을 수행한다.
 */
public class Exam08
{
	static int convertRev(int x, int y, char[] cArr)
	{
		int digits = 0;

		String dStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		do
		{
			cArr[digits++] = dStr.charAt(x % y);
			x /= y;
		}
		while(x != 0);
		return digits;
	}

	public static void main(String[] args)
	{

	}
}
