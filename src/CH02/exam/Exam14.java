package CH02.exam;

/**
 * 실습 2-13
 * 그 해의 경과 일수를 구한다.
 */
public class Exam14
{
	static int[][] mdays = 
	{
		{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, // 평년
		{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, // 윤년
	};
	
	static int isLeap(int year)
	{
		return ((year % 4 == 0) && (year % 100 != 0 || year % 400 == 0)) ? 1 : 0; // 1: 윤년 , 0: 평년 
	}
	
	static int passDay(int y, int m, int d)
	{
		int days = d;
		
		for (int i = 1; i < m ; i++) {
			days += mdays[isLeap(y)][i-1];
		}
		return days;
	}
	
	public static void main(String[] args)
	{
		
	}
}
