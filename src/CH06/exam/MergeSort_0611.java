package CH06.exam;

import common.CommonUtil;

/**
 * 실습 6-11
 * 병합정렬
 */
public class MergeSort_0611 
{	
	static void mergeSort(int[] a, int aleng, int[] b, int bleng, int[] c)
	{
		int posa = 0;
		int posb = 0;
		int posc = 0;

		// 작은값을 비교해 병합한다.
		while(posa < aleng && posb < bleng)
		{
			c[posc++] = (a[posa] <= b[posb]) ? a[posa++] : b[posb++];
		}
		
		// 배열 a에 남아있는 요소를 복사한다.
		while(posa < aleng)
		{
			c[posc++] = a[posa++];
		}
		
		// 배열 b에 남아있는 요소를 복사한다.
		while(posb < bleng)
		{
			c[posc++] = b[posb++];
		}
		
	}
	
	public static void main(String[] args)
	{		
		int[] a = {2, 4, 6, 8, 11, 13};
		int[] b = {1, 2, 3, 4, 9, 16, 21};
		int aleng = a.length;
		int bleng = b.length;
		int[] c = new int[aleng + bleng];
		
		System.out.println("배열 a");
		CommonUtil.arrayAddPrint(a);
		System.out.println();
		
		System.out.println("배열 b");
		CommonUtil.arrayAddPrint(b);
		System.out.println();

		System.out.println("두 배열을 병합한다.");
		System.out.println();
		
		mergeSort(a, aleng, b, bleng, c); // 정렬

		CommonUtil.arrayAddPrint(c);
	}
}
