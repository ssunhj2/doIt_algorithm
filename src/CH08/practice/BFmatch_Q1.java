package CH08.practice;

/**
 * 문제1
 * 브루트  - 포스법으로 문자열을 검색하는 프로그램의 과정을 출력하도록 작성한다.
 */
public class BFmatch_Q1 
{
	static int bfMatch(String text, String pat)
	{
		int pt = 0; // text 위치
		int pp = 0; // pattern 위치
		
		int result = 0;
		
		while(pt != text.length() && pp != pat.length())
		{
			for (int i = 0; i < pat.length(); i++) 
			{
				if(i == 0) System.out.printf("%-2s%"+(text.length())+"s\n", pt, text);
				else System.out.printf("%-2s%"+(text.length())+"s\n"," ",text);
				
				String sign = text.charAt(pt) == pat.charAt(pp) ? "+" : "|";
				
				System.out.printf("%-"+(2+pp+pt)+"s%s\n", " ", sign);
				System.out.printf("%-"+(2+pt)+"s%s\n\n"," ", pat);
			}
			
			if(text.charAt(pt) == pat.charAt(pp))
			{
				pt++;
				pp++;
			}
			else
			{
				pt = pt - pp + 1;
				pp = 0;
				
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
