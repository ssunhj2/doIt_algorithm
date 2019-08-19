package CH06.exam;

import common.CommonUtil;

/**
 * 실습 6-3
 * Bubble Sort (응용3)
 */
public class BubbleSort_0603 
{	
	// 정렬
	static void bubbleSort(int[] intArr, int num)
	{
		int k = 0;
		while(k < num-1)
		{
			int last = num-1;
			for (int j = num-1; j > k; j--) 
			{
				if(intArr[j-1] > intArr[j]) 
				{
					CommonUtil.swap(intArr, (j-1), j);
					last = j;
				}
				k = last;
			}
		}
		for (int i = 0; i < num-1; i++)
		{
			int exchg = 0;
			for (int j = num-1; j > i; j--) 
			{
				if(intArr[j-1] > intArr[j]) 
				{
					CommonUtil.swap(intArr, (j-1), j);
					exchg++;
				}
			}
			if(exchg == 0) break;
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
