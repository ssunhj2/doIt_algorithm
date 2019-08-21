package CH06.practice;

import common.CommonUtil;

/**
 * 단순선택정렬
 */
public class SelectionSort_Q6 
{	
	// 정렬
	static void selectionSort(int[] intArr, int num)
	{
		for (int i = 0; i < num-1; i++)
		{
			int min = i;
			
			System.out.printf("%"+((2*i)+1)+"s", "*");

			for (int j = i+1; j < num; j++) 
			{
				if(intArr[j] < intArr[min]) 
				{
					min = j;
				}
			}
			
			// index min에 맞춰 2자리씩 찍어준다.
			// +1은 수식으로 공백만큼 띄운 뒤 다음자리에 숫자를 찍어주기 위함이다.
			// 뒤의 숫자를 뺀 이유는 (공백+*)만큼의 앞의 공백을 제거하기 위함이다.
			System.out.printf("%"+(((2*min)+1)-((2*i)+1))+"s", "+"); 
			System.out.println();
			
			for (int k = 0; k < num; k++) 
			{
				System.out.printf("%-2d", intArr[k]);
			}
			System.out.println();
			
			CommonUtil.swap(intArr, i, min);
		}
		
		
	}
	
	public static void main(String[] args)
	{
		System.out.println("단순선택정렬");
		
		int[] intArr = {6, 4, 8, 3, 1, 9, 7};
		
		selectionSort(intArr, intArr.length); // 정렬
		System.out.println();
		CommonUtil.arrayhorizPrint(intArr);
	}
}
