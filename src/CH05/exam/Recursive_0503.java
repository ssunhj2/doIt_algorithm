package CH05.exam;

/**
 * 예제 5-3
 * 재귀함수 예제
 */
public class Recursive_0503 
{
	static void recursive(int num) {
		if (num > 0) 
		{
			recursive(num - 1);
			System.out.println(num);
			recursive(num - 2);
		}
	}
	
	public static void main(String[] args) 
	{
		int num = 4;
		recursive(num);
	}

}
