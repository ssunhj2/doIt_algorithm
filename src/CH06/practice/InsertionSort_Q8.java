package CH06.practice;

import common.CommonUtil;

/**
 * 단순 삽입 정렬에 이진탐색 기법을 사용하여 성능을 향상한다.
 */
public class InsertionSort_Q8 
{	
	// 이진 탐색으로 위치를 찾는다.
	static int binarySearch(int[] intArr, int left, int right, int searchNum)
	{
		while(left <= right)
		{
			int mid = (left+right)/2;
			
			if(searchNum == intArr[mid])
			{
				return mid;
			}
			else if(searchNum > intArr[mid]) // 오른쪽에서 검색
			{
				return binarySearch(intArr, (mid+1), right, searchNum);
			}
			else if(searchNum < intArr[mid]) // 왼쪽에서 검색
			{
				return binarySearch(intArr, left, (mid-1), searchNum);
			}
		}
		
		return left; // 위치를 못찾은 경우 제일 앞에 삽입한다.
	}
	
	// 정렬
	static void insertionSort(int[] intArr, int num)
	{
		for (int i = 1; i < num; i++)
		{
			int j;
			int temp = intArr[i];

			int target = binarySearch(intArr, 0, i, intArr[i]);
			
			for (j = i ; j > target ; j--) 
			{
				intArr[j] = intArr[j-1];
			}
			System.out.println("target:"+ target);
			intArr[target] = temp;

		}
	}
	
	public static void main(String[] args)
	{
		System.out.println("단순 삽입 정렬");
		
		int[] intArr = {22, 5, 11, 32, 120, 68, 70};

		CommonUtil.arrayAddPrint(intArr);
		
		insertionSort(intArr, intArr.length); // 정렬
		
		System.out.println("오름차순으로 정렬한다.");
		
		CommonUtil.arrayAddPrint(intArr);
	}
}
