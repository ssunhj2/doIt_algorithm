package CH02.exam;

/**
 * 실습 2-8[B]
 *
 */
public class Exam09
{
	static int convertRev(int x, int y, char[] cArr)
	{
		int digits = 0;

		String dStr = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

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
		int no = 59;
		int cd = 2;
		int dno;
		char[] charNo = new char[32];

		System.out.println("10진수를 기수 변환한다.");

		dno = convertRev(no, cd, charNo);

		System.out.print(cd +" 진수로는 ");

		for (int i = dno-1; i >= 0; i--)
		{
			System.out.print(charNo[i]);
		}
		System.out.println(" 이다.");
	}
}
