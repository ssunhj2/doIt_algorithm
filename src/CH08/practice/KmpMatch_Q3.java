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
		
		skip[pt] = 0;
		
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
		pt = pp = 0;
		
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
			else if (pp == 0)
			{
				pt++;
				result++;
			}
			else
			{
				pp = skip[pp];
				result++;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) 
	{
		String s1 = "ABABCDEFGHA";
		String s2 = "ABC";
		
		System.out.println("텍스트: " + s1);
		System.out.println("패턴:" +s2);
		
		int result = kmpMatch(s1, s2);
		
		System.out.println("비교는 " + result + "회 이다.");
	}

}
