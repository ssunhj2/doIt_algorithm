package CH08.practice;

/**
 * 문제4
 * Boyer-Moore법으로 문자열을 검색하는 프로그램을 작성한다.
 */
public class BmMatch_Q4 
{
	static int bmMatch(String text, String pat)
	{
		int pt;
		int pp;
		int textLeng = text.length();
		int patLeng = pat.length();
		int[] skip = new int[Character.MAX_VALUE + 1]; // 건너뛰기 표
		
		// 건너뛰기 표 만들기
		for(pt=0; pt <= Character.MAX_VALUE; pt++)
		{
			skip[pt] = patLeng;
		}
		
		for(pt=0; pt <= patLeng-1; pt++)
		{
			skip[pat.charAt(pt)] = patLeng - pt - 1;
		}
		
		while(pt < textLeng)
		{
			pp = patLeng - 1; // 끝 요소 검색
			
			while(text.charAt(pt) == pat.charAt(pp))
			{
				if(pp == 0) return pt;
				
				pp--;
				pt--;
			}
			
			pt += (skip[text.charAt(pt)] > patLeng - pp) ? skip[text.charAt(pt)] : patLeng - pp;
		}
		return -1;
	}
	
	public static void main(String[] args) 
	{
		String s1 = "ABCDEFGHIJABC";
		String s2 = "EFG";
		
		System.out.println("텍스트: " + s1);
		System.out.println("패턴:" +s2);
		
		int index = bmMatch(s1, s2);
		
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
