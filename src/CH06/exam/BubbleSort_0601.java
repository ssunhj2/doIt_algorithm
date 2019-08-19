package CH06.exam;

import common.CommonUtil;

/**
 * 실습 6-1
 * 기본 Bubble Sort
 */
public class BubbleSort_0601 
{	
	// 정렬
	static void bubbleSort(int[] intArr, int num)
	{
		for (int i = 0; i < num-1; i++)
		{
			for (int j = num-1; j > i; j--) 
			{
				if(intArr[j-1] > intArr[j]) CommonUtil.swap(intArr, (j-1), j);
			}
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println("기본 Bubble Sort");
		
		int[] intArr = {55, 43, 10, 3, 77, 35};

		CommonUtil.arrayAddPrint(intArr);
		
		bubbleSort(intArr, intArr.length); // 정렬
		
		System.out.println("오름차순으로 정렬한다.");
		
		CommonUtil.arrayAddPrint(intArr);
	}
}
