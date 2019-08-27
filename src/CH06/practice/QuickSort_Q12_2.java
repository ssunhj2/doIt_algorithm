package CH06.practice;

import common.CommonUtil;
import common.stack.PubIntStack;

/**
 * 퀵 정렬 (비재귀)
 * 요소의 개수가 적은 그룹을 먼저 나눈다.
 */
public class QuickSort_Q12_2 
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
			
			// 요소의 개수가 많은 그룹을 먼저 푸시한다.
			// 요소의 개수가 pr, left보다 pl, right가 더 많으면 서로 교환해준다.
			if(pr-left < right- pl)
			{
				int temp = left;
				left = pl;
				pl = temp;
				temp = pr;
				pr = right;
				right = temp;
			}
				
			// 먼저 푸시 됨 (요소의 개수가 많은 그룹)
			if(left < pr)
			{
				leftStack.push(left);
				rightStack.push(pr);
				System.out.println("LStack:"+left + " , RStack:" + pr + " 푸시");
				printLRStack(leftStack, rightStack);
			}
			
			// 나중에 푸시됨(요소의 개수가 적은 그룹)
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
