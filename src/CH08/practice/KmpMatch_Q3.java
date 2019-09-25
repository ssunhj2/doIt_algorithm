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
		
		skip[pt] = 0;
		
		while(pt != pat.length())
		{
			if(pat.charAt(pt) == pat.charAt(pp))
			{
				skip[++pt] = ++pp;
			}
			else if(pp == 0)
			{
				skip[++pt] = pp;
			}
			else
			{
				pp = skip[pp];
			}
		}
		
		// 검색
		pt = pp = 0;
		
		while(pt != text.length() && pp != pat.length())
		{
			if(text.charAt(pt) == pat.charAt(pp))
			{
				pt++;
				pp++;
			}
			else if (pp == 0)
			{
				pt++;
			}
			else
			{
				pp = skip[pp];
			}
		}
		
		if(pp == pat.length())
		{
			return pt-pp;
		}
		return -1;
	}
	
	public static void main(String[] args) 
	{
		String s1 = "ABCDEFGHIJABC";
		String s2 = "EFG";
		
		System.out.println("텍스트: " + s1);
		System.out.println("패턴:" +s2);
		
		int index = kmpMatch(s1, s2);
		
		if(index == -1)
		{
			System.out.println("패턴을 찾을 수 없다.");
		}
		else
		{
			// 일치하는 문자 바로 앞까지의 길이를 구한다.
			int leng = 0;
			
			for (int i = 0; i < index; i++) 
			{
				leng += s1.substring(i, i+1).getBytes().length;
			}
			leng += s2.length();
			
			System.out.println((index+1)+"번째 문자부터 일치한다.");
			System.out.println("텍스트: " + s1);
			System.out.printf(String.format("패턴:%%%ds\n", leng), s2);
			
		}
	}

}
