package CH06.exam;

import common.CommonUtil;

/**
 * 실습 6-4
 * 단순선택정렬
 */
public class SelectionSort_0604 
{	
	// 정렬
	static void selectionSort(int[] intArr, int num)
	{
		for (int i = 0; i < num-1; i++)
		{
			int min = i;
			for (int j = i+1; j < num; j++) 
			{
				if(intArr[j] < intArr[min]) 
				{
					min = j;
				}
			}
			CommonUtil.swap(intArr, i, min);
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println("단순선택정렬");
		
		int[] intArr = {22, 5, 11, 32, 120, 68, 70};

		CommonUtil.arrayAddPrint(intArr);
		
		selectionSort(intArr, intArr.length); // 정렬
		
		System.out.println("오름차순으로 정렬한다.");
		
		CommonUtil.arrayAddPrint(intArr);
	}
}
