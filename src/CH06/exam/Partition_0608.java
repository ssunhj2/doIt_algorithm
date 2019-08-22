package CH06.exam;

import common.CommonUtil;

/**
 * 실습 6-8
 * 퀵정렬 의 바탕이 되는 생각
 * 피벗(기준값)을 기준으로 배열을 분류한다.
 */
public class Partition_0608 
{	
	static void partition(int[] intArr, int num)
	{
		int pl = 0;
		int pr = num-1;
		int pivot = intArr[num/2];
		
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
		
		System.out.println("피벗값은 " + pivot + " 이다.");
		System.out.println();
		
		System.out.println("피벗값 이하의 그룹");
		CommonUtil.arrayAddPrint(intArr, 0, pl);
		System.out.println();
		
		System.out.println("피벗값과 일치하는 그룹");
		CommonUtil.arrayAddPrint(intArr, (pr+1), pl);
		System.out.println();
		
		System.out.println("피벗값 이상의 그룹");
		CommonUtil.arrayAddPrint(intArr, (pr+1), num);
		System.out.println();
		
		
	}
	
	public static void main(String[] args)
	{
		System.out.println("분류");
		
		int[] intArr = {1, 8, 7, 4, 5, 2, 6, 3, 9};
		
		CommonUtil.arrayAddPrint(intArr);
		
		partition(intArr, intArr.length); // 정렬

	}
}
