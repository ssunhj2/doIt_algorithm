package CH06.practice;

import common.CommonUtil;

/**
 * 퀵정렬
 * quickSort 매소드를 작성한다.
 */
public class QuickSort_Q10 
{	
	static void quickSort(int[] intArr, int n)
	{
		int pl = 0;
		int pr = n;
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
		
		if(0 < pr) quickSort(intArr, pr);
		if(pl < n) quickSort(intArr, (n-pl));
	}
	
	public static void main(String[] args)
	{	
		int[] intArr = {1, 8, 7, 4, 5, 2, 6, 3, 9};
		
		CommonUtil.arrayAddPrint(intArr);
		
		quickSort(intArr, intArr.length-1); // 정렬
		
		System.out.println("퀵정렬한다.");

		CommonUtil.arrayAddPrint(intArr);
	}
}
