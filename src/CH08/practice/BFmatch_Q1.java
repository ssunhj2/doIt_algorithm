package CH08.practice;

/**
 * 문제2
 * 브루트  - 포스법으로 문자열을 검색하는 프로그램의 과정을 출력하도록 작성한다.
 */
public class BFmatch_Q1 
{
	static int bfMatch(String text, String pat)
	{
		int pt = 0; // text 위치
		int pp = 0; // pattern 위치
		
		int result = 0;
		int patP = 0;
		int txtP = 0;
		while(pt != text.length() && pp != pat.length())
		{
			if(pp == 0)
			{
				System.out.printf("%-2s", pt);
				patP = pt;
			}
			else
			{
				System.out.print("  ");
			}
			
			System.out.println(text);
			
			System.out.print("  ");
			for (int i = 0; i < (pp+patP); i++) 
			{
				System.out.print(" ");
			}
			System.out.println(text.charAt(pt) == pat.charAt(pp) ? "+" : "|");
			
			System.out.print("  ");
			for (int i = 0; i < patP; i++) 
			{
				System.out.print(" ");
			}
			System.out.println(pat + "\n");
			
			if(text.charAt(pt) == pat.charAt(pp))
			{
				pt++;
				pp++;
				result++;
			}
			else
			{
				pt = pt - pp + 1;
				pp = 0;
				result++;
			}
			
		}
		return result;
	}
	
	public static void main(String[] args) 
	{
		String s1 = "ABABCDEFGHA";
		String s2 = "ABC";
		
		int result = bfMatch(s1, s2);
		
		System.out.println("비교는 " + result + "회 이다.");
	}

}
