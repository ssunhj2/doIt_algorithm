package CH06.exam;

import common.CommonUtil;

/**
 * 실습 6-12
 * 병합정렬(재귀적)
 */
public class MergeSort_0612 
{	
	static int[] buff;
	
	static void performMergeSort(int[] a, int left, int right)
	{
		if(left < right)
		{
			int i;
			int center = (left+right)/2;
			int p = 0;
			int j = 0;
			int k = left;
			
			performMergeSort(a, left, center);
			performMergeSort(a, center+1, right);
			
			for (i = left; i <= center; i++) 
			{
				buff[p++] = a[i];
			}
			

			while(i <= right && j < p)
			{
				a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];
			}
			

			while(j < p)
			{
				a[k++] = buff[j++];
			}
			
		}

	}
	
	
	static void mergeSort(int a[], int n)
	{
		buff = new int[n];
		
		performMergeSort(a, 0, n-1);
		
		buff = null;
	}
	
	public static void main(String[] args)
	{		
		int[] a = {1, 13, 12, 6, 4, 11, 8, 7 ,3, 2 ,6, 5};

		CommonUtil.arrayAddPrint(a);
		System.out.println();
		
		System.out.println("병합정렬을 오름차순으로 수행한다.");
		System.out.println();
		
		mergeSort(a, a.length); // 정렬

		CommonUtil.arrayAddPrint(a);
	}
}
