package CH06.exam;

import common.CommonUtil;

/**
 * 실습 6C-1
 * 퀵 정렬 분할과정 출력한다.
 */
public class QuickSort_6C01 
{	
	static void quickSort(int[] intArr, int left, int right)
	{
		int pl = left;
		int pr = right;
		int pivot = intArr[(pl+pr)/2];
		
		System.out.printf("intArr[%d] ~ intArr[%d] : {", left, right);
		
		for (int i = left; i < right; i++) 
		{
			System.out.printf("%d ,", intArr[i]);
		}
		System.out.printf("%d}\n", intArr[right]);
		
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
		
		int[] intArr = {5,8,4,2,6,1,3,9,7};
		
		CommonUtil.arrayAddPrint(intArr);
		
		quickSort(intArr, 0, intArr.length-1); // 정렬
		
		System.out.println("퀵정렬한다.");

		CommonUtil.arrayAddPrint(intArr);
	}
}
