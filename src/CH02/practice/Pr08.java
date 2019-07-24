package CH02.practice;

/**
 * 특정 해의 경과 일수를 구한다.
 * 단, 경과 일수를 구할때 while문을 사용한다.
 */
public class Pr08
{
	static int[][] monthDays =
	{
		{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, // 평년
		{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, // 윤년
	};
	
	static int isLeap(int year)
	{
		return ((year % 4 == 0) && (year % 100 != 0 || year % 400 == 0)) ? 1 : 0; // 1: 윤년 , 0: 평년 
	}
	
	static int passDays(int year, int month, int day)
	{
		while(--month > 0)
		{
			day += monthDays[isLeap(year)][month-1];
		}

		return day;
	}
	
	public static void main(String[] args)
	{
		int year = 2019;
		int month = 7;
		int day = 24;
		System.out.println(year +"년 " +month + "월 " + day + "일 의 경과 일수를 구한다.");

		System.out.printf(year +"년의 %d일째 이다.\n", passDays(year, month, day));
	}
}
