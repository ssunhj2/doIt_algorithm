package CH02.exam;

/**
 * 실습 2c-1
 * 배열의 모든요소의 합을 구한다.
 */
public class Exam15
{
	public static void main(String[] args)
	{
		double[] dblArr = {5.0, 4.0, 3.0, 2.0, 1.0};

		for (int i = 0; i < dblArr.length; i++)
		{
			System.out.println("dblArr["+i+"] = " + dblArr[i]);
		}

		double sum = 0;

		for(double ele:dblArr)
		{
			sum+= ele;
		}

		System.out.println("dblArr의 모든 요소의 합은 "+ sum + "이다.");
	}
}
