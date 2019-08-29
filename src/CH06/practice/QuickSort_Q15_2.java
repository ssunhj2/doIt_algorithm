package CH06.practice;

import java.util.Arrays;

import common.CommonUtil;
import common.stack.PubIntStack;

/**
 * 퀵 정렬 (비재귀)
 * 요소의 개수가 적은 그룹을 먼저 나눈다.
 * 배열 요소 중 처음, 가운데, 끝 요소를 선택하고 정렬한 뒤, 끝요소와 끝에서 두번째 요소를 교환한다.
 * 끝에서 두번째 요소를 피벗으로 선택하여 앞에서 두번째 요소부터 피벗의 앞 요소까지 정렬을 수행한다. 
 */
public class QuickSort_Q15_2 
{	
	// 퀵 정렬
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
			
			System.out.println("<Quick>");
			System.out.printf("intArr[%d] ~ intArr[%d] : {", left, right);
			
			for (int i = left; i < right; i++) 
			{
				System.out.printf("%d ,", intArr[i]);
			}
			System.out.printf("%d}\n", intArr[right]);
			System.out.println();
			
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
			
			// 요소의 개수
			int arrCnt1 = (pr-left)+1;
			int arrCnt2 = (right- pl)+1;
			
			if(arrCnt1 > 9 && arrCnt2 > 9)
			{
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
				}
				
				// 나중에 푸시됨(요소의 개수가 적은 그룹)
				if(pl < right)
				{
					leftStack.push(pl);
					rightStack.push(right);
				}
			}
			else if(arrCnt1 <= 9)
			{
				if(left < pr) insertionSort(intArr, left, pr);
				if(pl < right)
				{
					leftStack.push(pl);
					rightStack.push(right);
				}
			}
			else if(arrCnt2 <= 9)
			{
				if(left < pr)
				{
					leftStack.push(left);
					rightStack.push(pr);
				}
				
				if(pl < right) insertionSort(intArr, pl, right);
			}
			else
			{
				if(left < pr) insertionSort(intArr, left, pr);
				if(pl < right) insertionSort(intArr, pl, right);
			}
		}

	}
	
	// 단순삽입정렬
	static void insertionSort(int[] intArr, int start, int end)
	{
		System.out.println("<Insertion>");
		for (int i = start+1; i < end+1; i++)
		{
			int j;

			int temp = intArr[i];
			for (j = i; j > 0 && intArr[j-1] > temp; j--) 
			{
				intArr[j] = intArr[j-1];
			}
			intArr[j] = temp; // 이전의(루프안의 가장 마지막의) j-1자리가 j의 자리가 된다.
			
			
			System.out.printf("intArr[%d] ~ intArr[%d] : {", start, end);
			for (j = start; j < end; j++) 
			{
				System.out.printf("%d ,", intArr[j]);
			}
			System.out.printf("%d}\n", intArr[end]);
		}
		System.out.println();
	}
		
	// 정렬하기전 작업을 수행한다.
	// 배열 요소 중 처음, 가운데, 끝 요소를 선택하고 정렬한 뒤, 끝요소와 끝에서 두번째 요소를 교환한다.
	// 끝에서 두번째 요소를 피벗으로 선택하여 앞에서 두번째 요소부터 피벗의 앞 요소까지 정렬을 수행한다.
	static void beforeSort(int[] intArr)
	{
		int endInx = intArr.length -1;
		
		// 첫요소, 가운데요소, 끝요소를 배열에 저장
		int[] pivotArr = {intArr[0], intArr[endInx/2] ,intArr[endInx]};
		// 세 요소를 정렬한다.
		Arrays.sort(pivotArr);
		// 정렬한 세 요소를 배열에 넣어준다.
		intArr[0] = pivotArr[0];
		intArr[endInx/2] = pivotArr[1];
		intArr[endInx] = pivotArr[2];
		// 가운데 요소와 끝에서 두버째 요소를 교환한다.
		int temp = intArr[endInx/2];
		intArr[endInx/2] = intArr[endInx-1];
		intArr[endInx-1] = temp;
				
	}
		
	public static void main(String[] args)
	{		
		int[] intArr = {5, 8, 4, 2, 6, 1, 3, 9, 7};
		
		System.out.print("배열 초기값: {");
		CommonUtil.arrayhorizPrint(intArr);
		System.out.println("}\n");

		beforeSort(intArr);
		System.out.print("정렬 전 작업수행: {");
		CommonUtil.arrayhorizPrint(intArr);
		System.out.println("}\n");
		
		quickSort(intArr, 0, intArr.length-1); // 정렬
		
		System.out.print("\n정렬완료:{");
		CommonUtil.arrayhorizPrint(intArr);
		System.out.println("}");
	}
}
