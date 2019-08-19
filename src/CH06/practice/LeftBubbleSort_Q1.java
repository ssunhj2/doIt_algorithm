package CH06.practice;

import common.CommonUtil;

/**
 * 문제1
 * Bubble 정렬을 왼쪽부터 비교한다.
 */
public class LeftBubbleSort_Q1 
{	
	// 정렬
	static void bubbleSort(int[] intArr, int num)
	{
		for (int i = num-1; i > 0; i--)
		{
			for (int j = 0; j < i; j++) 
			{
				if(intArr[j] > intArr[j+1]) CommonUtil.swap(intArr, j, (j+1));
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
