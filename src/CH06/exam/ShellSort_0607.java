package CH06.exam;

import common.CommonUtil;

/**
 * 실습 6-7
 * 셸 정렬 (증분값)
 */
public class ShellSort_0607 
{	
	// 셸 정렬
	static void shellSort(int[] intArr, int num)
	{
		int h;
		
		for (h = 1; h < num/9; h = h*3+1);
		
		for (; h > 0; h/=2) 
		{
			for (int i = h; i < num; i++)
			{
				int j;
				int temp = intArr[i];
				for (j = i-h; j >= 0 && intArr[j] > temp; j-=h) 
				{
					intArr[j+h] = intArr[j];
				}
				intArr[j+h] = temp; // 이전의(루프안의 가장 마지막의) j-1자리가 j의 자리가 된다.

			}
		}
		
	}
	
	public static void main(String[] args)
	{
		System.out.println("셸 정렬");
		
		int[] intArr = {22, 5, 11, 32, 120, 68, 70};

		CommonUtil.arrayAddPrint(intArr);
		
		shellSort(intArr, intArr.length); // 정렬
		
		System.out.println("셸 정렬한다.");
		
		CommonUtil.arrayAddPrint(intArr);
	}
}
