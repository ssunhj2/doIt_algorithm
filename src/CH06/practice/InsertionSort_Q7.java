package CH06.practice;

import common.CommonUtil;

/**
 * 단순 삽입 정렬
 * 보초법을 사용한다.
 * 두번 비교하는것을 줄일 수 있다.
 */
public class InsertionSort_Q7 
{	
	// 정렬
	static void insertionSort(int[] intArr, int num)
	{
		for (int i = 2; i < num; i++)
		{
			intArr[0] = intArr[i];
			int j;
			int temp = intArr[i];
			
			for (j = i; intArr[j-1] > temp; j--) 
			{
				intArr[j] = intArr[j-1];
			}
			
			if(j > 0) intArr[j] = temp;

		}
	}
	
	public static void main(String[] args)
	{
		System.out.println("단순 삽입 정렬");
		
		int[] baseArr = {22, 5, 11, 32, 120, 68, 70};
		int baseLeng = baseArr.length; 
		int[] intArr = new int[baseLeng+1];
		for (int i = 0; i < baseLeng; i++) 
		{
			intArr[i+1] = baseArr[i];
		}

		CommonUtil.arrayAddPrint(intArr);
		
		insertionSort(intArr, intArr.length); // 정렬
		
		System.out.println("단순 삽입 정렬한다.");
		
		CommonUtil.arrayAddPrint(intArr, 1, baseLeng+1);
	}
}
