package CH05.practice;

/**
 * 아래 메소드를 상향식 분석과 하양식 분석을 수행하라.
 */
public class Pr04 
{
	static void recursive(int num) {
		if (num > 0) 
		{
			recursive(num - 2);
			System.out.println(num);
			recursive(num - 1);
		}
	}
	
	public static void main(String[] args) 
	{
		int num = 4;
		recursive(num);
	}

}
