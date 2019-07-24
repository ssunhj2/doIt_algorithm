package CH02.practice;

/**
 * 특정 해의 남은 일수를 구한다.
 */
public class Pr09
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
	
	static int leftDays(int year, int month, int day)
	{
		int days = (monthDays[isLeap(year)][month-1] - day); // 달의 일수 - day

		int lastMonth = 12;

		while(lastMonth-- > month)
		{
			days += monthDays[isLeap(year)][lastMonth];
		}

		return days;
	}
	
	public static void main(String[] args)
	{
		int year = 2019;
		int month = 12;
		int day = 30;
		System.out.println(year +"년 " +month + "월 " + day + "일 의 남은 일수를 구한다.");

		System.out.printf(year +"년의 남은 일수는 %d일 이다.\n", leftDays(year, month, day));
	}
}
