package CH05.exam;

/**
 * 예제 5-1
 * 팩토리얼을 구한다.
 */
public class Factorial_0501 
{
	static int factorial(int num)
	{
		if(num > 0)
		{
			return num * factorial(num-1);
		}
		else
		{
			return 1;
		}
	}
	public static void main(String[] args) 
	{
		int factNum = 3;
		
		System.out.println(factNum +"의 factorial은 " + factorial(factNum) + " 이다.");

	}

}
