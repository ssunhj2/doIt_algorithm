package CH06.exam;

import common.CommonUtil;

/**
 * 실습 6-9
 * 퀵정렬
 */
public class QuickSort_0609 
{	
	static void quickSort(int[] intArr, int left, int right)
	{
		int pl = left;
		int pr = right;
		int pivot = intArr[(pl+pr)/2];
		
		do
		{
			while(intArr[pl] < pivot) pl++;
			while(intArr[pr] > pivot) pr--;
			
			if(pl <= pr)
			{
				CommonUtil.swap(intArr, pl++, pr--);
			}
		}
		while(pl <= pr);
		
		if(left < pr) quickSort(intArr, left, pr);
		if(pl < right) quickSort(intArr, pl, right);
	}
	
	public static void main(String[] args)
	{
		System.out.println("분류");
		
		int[] intArr = {1, 8, 7, 4, 5, 2, 6, 3, 9};
		
		CommonUtil.arrayAddPrint(intArr);
		
		quickSort(intArr, 0, intArr.length-1); // 정렬
		
		System.out.println("퀵정렬한다.");

		CommonUtil.arrayAddPrint(intArr);
	}
}
