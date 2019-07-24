package CH02.practice;

/**
 * 배열의 앞쪽에 윗자리를 저장하는 코드를 작성한다.
 */
public class Pr06
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

		// 요소를 교환한다.
		for (char i = 0; i < digits /2; i++)
		{
			char temp = cArr[i];
			cArr[i] = cArr[digits-1-i];
			cArr[digits-1-i] = temp;
		}
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

		for (int i = 0; i < dno; i++)
		{
			System.out.print(charNo[i]);
		}
		System.out.println(" 이다.");
	}

}
