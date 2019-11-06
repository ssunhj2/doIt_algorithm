package CH08.practice;

/**
 * 문제3
 * KMP법으로 문자열을 검색하는 과정을 출력하는 프로그램을 작성한다.
 *
 */
public class KmpMatch_Q3 
{
	static int kmpMatch(String text, String pat)
	{
		int pt = 1; // text 위치
		int pp = 0; // pattern 위치
		int[] skip = new int[pat.length()+1];
		int result = 0;
		int k = -1;
		
		System.out.println("skip 테이블 만들기");
		skip[pt] = 0;
		while (pt != pat.length()) {
			if (k == pt - pp)
				System.out.print("    ");
			else {
				System.out.printf("%2d  ", pt - pp);
				k = pt - pp;
			}
			for (int i = 0; i < text.length(); i++)
				System.out.print(text.charAt(i) + " ");
			System.out.println();

			for (int i = 0; i < pt * 2 + 4; i++)
				System.out.print(" ");
			System.out.print(text.charAt(pt) == pat.charAt(pp) ? '+' : '|');
			System.out.println();

			for (int i = 0; i < (pt - pp) * 2 + 4; i++)
				System.out.print(" ");

			for (int i = 0; i < pat.length(); i++)
				System.out.print(pat.charAt(i) + " ");
			System.out.println();
			System.out.println();
			result++;
			if (pat.charAt(pt) == pat.charAt(pp))
				skip[++pt] = ++pp;
			else if (pp == 0)
				skip[++pt] = pp;
			else
				pp = skip[pp];
		}
		
		while(pt != pat.length())
		{
			if(pat.charAt(pt) == pat.charAt(pp))
			{
				skip[++pt] = ++pp;
				result++;
			}
			else if(pp == 0)
			{
				skip[++pt] = pp;
				result++;
			}
			else
			{
				pp = skip[pp];
				result++;
			}
		}
		
		// 검색
				System.out.println("검색");
				pt = pp = 0;
				while (pt != text.length() && pp != pat.length()) {
					if (k == pt - pp)
						System.out.print("    ");
					else {
						System.out.printf("%2d  ", pt - pp);
						k = pt - pp;
					}
					for (int i = 0; i < text.length(); i++)
						System.out.print(text.charAt(i) + " ");
					System.out.println();

					for (int i = 0; i < pt * 2 + 4; i++)
						System.out.print(" ");
					System.out.print(text.charAt(pt) == pat.charAt(pp) ? '+' : '|');
					System.out.println();

					for (int i = 0; i < (pt - pp) * 2 + 4; i++)
						System.out.print(" ");

					for (int i = 0; i < pat.length(); i++)
						System.out.print(pat.charAt(i) + " ");
					System.out.println();
					System.out.println();
					result++;
					if (text.charAt(pt) == pat.charAt(pp)) {
						pt++;
						pp++;
					} else if (pp == 0)
						pt++;
					else
						pp = skip[pp];
				}

				System.out.printf("비교는 %d회입니다.\n", result);
				if (pp == pat.length()) // 패턴의 모든 문자를 조사
					return pt - pp;
				return -1; // 검색실패
	}
	
	public static void main(String[] args) 
	{
		String s1 = "BCBCBCE";
		String s2 = "BCBCBCA";
		
		System.out.println("텍스트: " + s1);
		System.out.println("패턴:" +s2);
		
		int result = kmpMatch(s1, s2);
		
		System.out.println("비교는 " + result + "회 이다.");
	}

}
