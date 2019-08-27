package CH06.practice;

import common.CommonUtil;
import common.stack.PubIntStack;

/**
 * 퀵 정렬 (재귀)
 * 요소의 개수가 적은 그룹을 먼저 나눈다.
 */
public class QuickSort_Q12_1 
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
		
		// 요소의 개수가 적은 그룹을 먼저 분할한다.
		// 요소의 개수가 pr, left보다 pl, right가 더 많으면 서로 교환해준다.
		if(pr-left > right- pl)
		{
			int temp = left;
			left = pl;
			pl = temp;
			temp = pr;
			pr = right;
			right = temp;
		}
		// 먼저 분할
		if(left < pr) quickSort(intArr, left, pr);
		if(pl < right) quickSort(intArr, pl, right);
	}
	

	
	public static void main(String[] args)
	{
		int[] intArr = {6, 5, 4, 2, 7, 3, 1, 8};
		
		System.out.print("배열 초기값: {");
		CommonUtil.arrayhorizPrint(intArr);
		System.out.println("}\n");

		quickSort(intArr, 0, intArr.length-1); // 정렬
		
		System.out.print("\n정렬완료:{");
		CommonUtil.arrayhorizPrint(intArr);
		System.out.println("}");
	}
}
