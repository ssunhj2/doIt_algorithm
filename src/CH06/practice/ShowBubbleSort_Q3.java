package CH06.practice;

import common.CommonUtil;

/**
 * 문제3
 * Bubble Sort(응용2) 과정을  출력한다.
 */
public class ShowBubbleSort_Q3 
{	
	// 정렬
	static void bubbleSort(int[] intArr, int num)
	{
		int compCnt = 0; // 비교
		int chngCnt = 0; // 교환
		
		for (int i = 0; i < num-1; i++)
		{
			System.out.println("패스"+ (i+1) + ":");
			int exchg = 0;
			for (int j = num-1; j > i; j--) 
			{
				for (int k = 0; k < num; k++) 
				{
					if(j != k)
					{
						System.out.print("  ");
					}
					else if(intArr[j-1] > intArr[j])
					{
						System.out.print(" +");
					}
					else
					{
						System.out.print(" -");
					}
					
					System.out.print(intArr[k]);
					
				}
				System.out.println();
				
				compCnt++;
				
				if(intArr[j-1] > intArr[j])
				{
					CommonUtil.swap(intArr, (j-1), j);
					chngCnt++;
					exchg++;
				}

				
			}
			for (int k = 0; k < num; k++) 
			{
				System.out.print("  "+ intArr[k]);
			}
			System.out.print("\n\n");
			
			if(exchg == 0) break;
		}
		
		System.out.println("비교:" + compCnt + "회 , 교환:" + chngCnt +"회");
	}
	
	public static void main(String[] args)
	{
		int[] intArr = {6, 4, 3, 7, 1, 9, 8};

		bubbleSort(intArr, intArr.length); // 정렬
	}
}
