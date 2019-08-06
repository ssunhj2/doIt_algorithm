package CH02.practice;

/**
 * 기수변환 과정을 나타내어 프로그램을 작성한다.
 */
public class Pr07
{
	static int convertRev(int x, int y, char[] cArr)
	{
		int digits = 0;

		String dStr = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		System.out.printf(y+"|%7d\n", x);
		System.out.print(" + ------\n");
		do
		{
			int quo = (x / y); // 몫
			char remain = dStr.charAt(x % y); // 나머지

			if(quo != 0) System.out.printf(y+"|%7d...%c\n + ------\n",quo, remain);
			else System.out.printf("%9d...%c\n",quo, remain);
			cArr[digits++] = remain;

			x /= y;
		}
		while(x != 0);

		return digits;
	}

	public static void main(String[] args)
	{
		int no = 5;
		int cd = 2;
		int dno;
		char[] charNo = new char[32];

		System.out.println("10진수를 기수 변환한다.");
		System.out.println("변환하는 음이 아닌 정수: " + no);
		System.out.println(cd+ " 진수로 변환한다.\n");

		dno = convertRev(no, cd, charNo);

		System.out.print(cd +" 진수로는 ");

		for (int i = dno-1; i >= 0; i--)
		{
			System.out.print(charNo[i]);
		}
		System.out.println(" 이다.");
	}

}
