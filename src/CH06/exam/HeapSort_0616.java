package CH06.exam;

import common.CommonUtil;

/**
 * 실습 6-16
 * 힙정렬을 수행한다.
 *
 */
public class HeapSort_0616 
{
	static void downHeap(int[] a, int left, int right)
	{
		int temp = a[left];
		int child;
		int parent;
		
		for(parent = left; parent < (right+1)/2; parent = child)
		{
			int cl = parent*2 +1; // 왼쪽
			int cr = cl+1;
			child = (cr <= right && a[cr] > a[cl]) ? cr : cl;
			
			if(temp >= a[child])
			{
				break;
			}
			
			a[parent] = a[child];
		}
		
		a[parent] = temp;
	}
	
	static void heapSort(int[] a, int n)
	{
		for(int i=(n-1)/2; i >= 0; i--)
		{
			downHeap(a, i, n-1);
		}
		
		for(int i = n-1; i > 0; i--)
		{
			CommonUtil.swap(a, 0, i);
			downHeap(a, 0, i-1);
		}
	}
	
	public static void main(String[] args)
	{
		int[] a = {7, 22, 5, 11, 32, 120, 68, 70};
		
		CommonUtil.arrayAddPrint(a);
		System.out.println();
		
		System.out.println("병합정렬을 오름차순으로 수행한다.");
		System.out.println();
		
		heapSort(a, a.length);
		
		CommonUtil.arrayAddPrint(a);
	}

}
