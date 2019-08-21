package CH06.practice;

import common.CommonUtil;

/**
 * 문제4
 * 홀수번째 패스에는 가장 작은 요소를 맨 앞으로,
 * 짝수번재 패스에는 가장 큰 요소를 맨 뒤로 옮기는 
 * Bubble Sort을 진행한다.
 */
public class BothBubbleSort_Q5 
{	
	// 정렬
		static void bothBbubbleSort(int[] intArr, int num)
		{
			int left = 0;
			int right = num -1;
			
			int last = num-1;
			
			while(left < right)
			{
				// 가장 큰 요소를 맨 뒤로
				for (int i = left; i < right; i++) 
				{
					if(intArr[i] > intArr[i+1]) 
					{
						CommonUtil.swap(intArr, i, (i+1));
						last = i;
					}
				}

				right = last;
				
				// 가장 작은 요소를 맨 앞으로
				for (int i = right; i > left; i--) 
				{
					if(intArr[i-1] > intArr[i]) 
					{
						CommonUtil.swap(intArr, i, (i+1));
						last = i;
					}
				}
				
				left = last;
				
			}

		}
		
		public static void main(String[] args)
		{
			System.out.println("양방향 Bubble Sort");
			
			int[] intArr = {9, 1, 3, 4, 6, 7, 8};

			CommonUtil.arrayAddPrint(intArr);
			
			bothBbubbleSort(intArr, intArr.length); // 정렬
			
			System.out.println("정렬한다.");
			
			CommonUtil.arrayAddPrint(intArr);
		}
}
