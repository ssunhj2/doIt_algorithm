package CH06.exam;

import common.CommonUtil;
import common.stack.PubIntStack;

/**
 * 실습 6-10
 * 퀵정렬
 */
public class QuickSort_0610 
{	
	static void quickSort(int[] intArr, int left, int right)
	{
		PubIntStack leftStack = new PubIntStack(right - left +1);
		PubIntStack rightStack = new PubIntStack(right - left +1);
		
		leftStack.push(left);
		rightStack.push(right);

		while(!leftStack.isEmpty())
		{
			int pl = left = leftStack.pop();
			int pr = right = rightStack.pop();
			
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
			
			if(left < pr)
			{
				leftStack.push(left);
				rightStack.push(pr);
			}
			
			if(pl < right)
			{
				leftStack.push(pl);
				rightStack.push(right);
			}
		}

	}
	
	public static void main(String[] args)
	{		
		int[] intArr = {1, 8, 7, 4, 5, 2, 6, 3, 9};
		
		CommonUtil.arrayAddPrint(intArr);
		
		quickSort(intArr, 0, intArr.length-1); // 정렬
		
		System.out.println("퀵정렬한다.");

		CommonUtil.arrayAddPrint(intArr);
	}
}
