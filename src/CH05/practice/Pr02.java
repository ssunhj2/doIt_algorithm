package CH05.practice;

/**
 * 재귀 메소드를 사용하지 않고 최대공약수를 구한다.
 */
public class Pr02 
{
	static int gcd(int numA, int numB)
	{
		// numA: 작은값, numB: 큰값
		if(numA > numB)
		{
			int temp = numA;
			numA = numB;
			numB = temp;
		}
		
		int na = numA;// 나누는수(작은수)
		int t = numB;// 나눠지는수(큰수)
		
		int gcdNum = 0;
		
		while(true)
		{
			int result = (t % na); // 나머지
			if(result == 0)
			{
				gcdNum = na;
				return gcdNum;
			}
			else
			{
				t = na;
				na = result;
			}
		}
		
	}
	public static void main(String[] args) 
	{
		int numA = 8;
		int numB = 3;
		
		System.out.println("두 정수의 최대공약수를 구한다.");
		
		
		System.out.println("두 정수 " + numA +" 와 "+ numB +"의 최대공약수는 " + gcd(numA, numB) + " 이다.");
	}

}
