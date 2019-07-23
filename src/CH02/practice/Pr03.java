package CH02.practice;

/**
 * 배열의 모든 요소의 합계를 구하여 반환하는 프로그램을 작성한다.
 */
public class Pr03
{
	static int arrSum(int[] iArr)
	{
		int result = 0;

		for (int i=0; i < iArr.length; i++)
		{
			result += iArr[i];
		}

		return result;
	}

	public static void main(String[] args) 
	{
		int[] iArr = {14, -20, 5, 95, 7, 43};

		System.out.print("배열: ");
		for (int i=0; i < iArr.length; i++)
		{
			System.out.print(iArr[i]+" ");
		}
		System.out.print("\n");

		System.out.println("배열요소들의 총합 = "+arrSum(iArr));
	}

}
