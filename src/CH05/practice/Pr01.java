package CH05.practice;

/**
 * 재귀함수 호출없이 팩토리얼을 구한다.
 */
public class Pr01 
{
	static int factorial(int num)
	{
		int result = num;
		while(num > 1)
		{
			result *= (--num);
		}
		return result;
	}
	public static void main(String[] args) 
	{
		int factNum = 3;
		
		System.out.println(factNum +"의 factorial은 " + factorial(factNum) + " 이다.");

	}

}
