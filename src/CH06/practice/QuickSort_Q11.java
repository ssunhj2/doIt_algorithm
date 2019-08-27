package CH06.practice;

import common.CommonUtil;
import common.stack.PubIntStack;

/**
 * 퀵 정렬의 푸시, 팝, 분할과정을 출력한다.
 */
public class QuickSort_Q11 
{	
	static void quickSort(int[] intArr, int left, int right)
	{
		PubIntStack leftStack = new PubIntStack(right - left +1);
		PubIntStack rightStack = new PubIntStack(right - left +1);

		leftStack.push(left);
		rightStack.push(right);
		
		System.out.println("LStack:"+left + " , RStack:" + right + " 푸시");
		printLRStack(leftStack, rightStack);
		
		while(!leftStack.isEmpty())
		{
			int pl = left = leftStack.pop();
			int pr = right = rightStack.pop();
			
			System.out.println("LStack:"+left + " , RStack:" + right + " 팝");
			printLRStack(leftStack, rightStack);
			
			int pivot = intArr[(pl+pr)/2];
			
			System.out.printf("intArr[%d] ~ intArr[%d] : {", left, right);
			
			for (int i = left; i < right; i++) 
			{
				System.out.printf("%d ,", intArr[i]);
			}
			System.out.printf("%d}\n", intArr[right]);
			System.out.print("\n\n");
			
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
				System.out.println("LStack:"+left + " , RStack:" + pr + " 푸시");
				printLRStack(leftStack, rightStack);
			}
			
			if(pl < right)
			{
				leftStack.push(pl);
				rightStack.push(right);
				System.out.println("LStack:"+pl + " , RStack:" + right + " 푸시");
				printLRStack(leftStack, rightStack);
			}
		}

	}
	
	private static void printLRStack(PubIntStack leftStack, PubIntStack rightStack)
	{
		System.out.print("LStack: ");
		leftStack.dump();
		System.out.print("RStack: ");
		rightStack.dump();
		System.out.println();
	}
	
	public static void main(String[] args)
	{		
		int[] intArr = {1, 8, 7, 4, 5, 2, 6, 3, 9};
		
		System.out.print("배열 초기값: {");
		CommonUtil.arrayhorizPrint(intArr);
		System.out.println("}\n");

		quickSort(intArr, 0, intArr.length-1); // 정렬
		
		System.out.print("\n정렬완료:{");
		CommonUtil.arrayhorizPrint(intArr);
		System.out.println("}");
	}
}
