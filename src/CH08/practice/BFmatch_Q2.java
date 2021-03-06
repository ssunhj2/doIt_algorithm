package CH08.practice;

/**
 * 문제2
 * 브루트  - 포스법으로 뒤부터 문자열을 검색하는 프로그램을 작성한다.
 *
 */
public class BFmatch_Q2 
{
	static int bfMatchLast(String text, String pat)
	{
		int pt = text.length()-1; // text 위치
		int pp = pat.length()-1; // pattern 위치
		
		while(pt >= 0 && pp >= 0)
		{
			if(text.charAt(pt) == pat.charAt(pp))
			{
				pt--;
				pp--;
			}
			else
			{
				pt = pt + (pat.length() - pp) - 2;
				pp = pat.length()-1;
			}
		}
		
		if(pp < 0)
		{
			return pt - pp;
		}
		return -1;
	}
	
	public static void main(String[] args) 
	{
		String s1 = "ABCDEFGHIJABC";
		String s2 = "EFG";
		
		System.out.println("텍스트: " + s1);
		System.out.println("패턴:" +s2);
		
		int index = bfMatchLast(s1, s2);
		
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
