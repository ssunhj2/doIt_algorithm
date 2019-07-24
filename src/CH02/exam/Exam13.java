package CH02.exam;

/**
 * 실습 2-12
 * 2차원 배열 - 3행 4열
 * ㅁ ㅁ ㅁ ㅁ
 * ㅁ ㅁ ㅁ ㅁ
 * ㅁ ㅁ ㅁ ㅁ
 */
public class Exam13
{
	public static void main(String[] args)
	{
		int[][] intArr = new int[3][4];
		
		intArr[0][1] = 33;
		intArr[0][3] = 87;
		intArr[1][1] = 64;
				
		for (int i = 0; i < 3; i++) 
		{
			for (int j = 0; j < 4; j++) 
			{
				System.out.println("intArr["+i+"]["+j+"] = " + intArr[i][j]);
			}
		}
		
	}
}
