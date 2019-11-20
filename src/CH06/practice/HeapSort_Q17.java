package CH06.practice;

import common.CommonUtil;

/**
 * 힙정렬을 수행한다.
 * 힙의 트리를 출력한다.
 */
public class HeapSort_Q17 
{
	// 트리를 출력한다.
	static void printHeapTree(int[] a)
	{
		for (int i = (a.length-1); i >= 0 ; i--) 
		{
			int root = (i-1)/2; // 루트
			int left = i*2 +1;
			int right = left+1;
			
			System.out.println("  "+root);
			
			System.out.print("/");
			System.out.print("  ");
			System.out.println("\\");
			
			System.out.print(left);
			System.out.print("  ");
			System.out.print(right);
			
			System.out.println();
		}
	}
	
	static void downHeap(int[] a, int left, int right)
	{
		int temp = a[left]; // 루트
		int child; // 큰값을 가진 노드
		int parent; // 부모노드

		for(parent = left; parent < (right+1)/2; parent = child)
		{
			int cl = parent*2 +1; // 왼쪽
			int cr = cl+1; // 오른쪽
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
			printHeapTree(a);
			downHeap(a, i, n-1);
		}
		
		for(int i = n-1; i > 0; i--)
		{
			printHeapTree(a);
			CommonUtil.swap(a, 0, i);
			downHeap(a, 0, i-1);
		}
	}
	
	public static void main(String[] args)
	{
		int[] a = {10, 9, 5, 6, 3, 2, 4, 6, 7, 1};
		
		CommonUtil.arrayAddPrint(a);
		System.out.println();
		
		System.out.println("병합정렬을 오름차순으로 수행한다.");
		System.out.println();
		
		heapSort(a, a.length);

	}

}
