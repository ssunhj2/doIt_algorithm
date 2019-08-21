package CH06.exam;

import common.CommonUtil;

/**
 * 실습 6-5
 * 단순 삽입 정렬
 */
public class InsertionSort_0605 
{	
	// 정렬
	static void insertionSort(int[] intArr, int num)
	{
		for (int i = 1; i < num; i++)
		{
			int j;
			int temp = intArr[i];
			for (j = i; j > 0 && intArr[j-1] > temp; j--) 
			{
				intArr[j] = intArr[j-1];
			}
			intArr[j] = temp; // 이전의(루프안의 가장 마지막의) j-1자리가 j의 자리가 된다.

		}
	}
	
	public static void main(String[] args)
	{
		System.out.println("단순 삽입 정렬");
		
		int[] intArr = {22, 5, 11, 32, 120, 68, 70};

		CommonUtil.arrayAddPrint(intArr);
		
		insertionSort(intArr, intArr.length); // 정렬
		
		System.out.println("오름차순으로 정렬한다.");
		
		CommonUtil.arrayAddPrint(intArr);
	}
}
