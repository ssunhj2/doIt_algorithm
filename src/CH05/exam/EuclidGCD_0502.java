package CH05.exam;

/**
 * 예제 5-2
 * 유클리드 호제법을 사용해 최대공약수를 구한다.
 */
public class EuclidGCD_0502 
{
	static int gcd(int numA, int numB)
	{
		if(numB == 0)
		{
			return numA;
		}
		else
		{
			return gcd(numB, (numA % numB));
		}
	}
	public static void main(String[] args) 
	{
		int numA = 3;
		int numB = 8;
		
		System.out.println("두 정수의 최대공약수를 구한다.");
		
		
		System.out.println("두 정수 " + numA +" 와 "+ numB +"의 최대공약수는 " + gcd(numA, numB) + " 이다.");
	}

}
