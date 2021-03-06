package CH02.practice;

/**
 * 서기 년월일을 필드로 갖는 클래스를 정의한다.
 */
public class Pr11
{
	int year;
	int month;
	int day;

	public Pr11(){}

	public Pr11(int year, int month, int day)
	{
		this.year = year;
		this.month = month;
		this.day = day;
	}

	static int[][] monthDays =
	{
		{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, // 평년
		{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, // 윤년
	};

	static int isLeap(int year)
	{
		return ((year % 4 == 0) && (year % 100 != 0 || year % 400 == 0)) ? 1 : 0; // 1: 윤년 , 0: 평년
	}

	// n일 뒤의 날짜를 반환한다.
	Pr11 afterDate(int n)
	{
		Pr11 ymd = new Pr11(this.year, this.month, this.day);
		
		int afterDay = ymd.month + n;
		int lastDay = monthDays[isLeap(year)][ymd.month-1]; // 이번달의 마지막 day
		
		if(afterDay > lastDay)
		{
			ymd.month++;
			ymd.day = afterDay - lastDay;
		}
		else
		{
			ymd.day += n;
		}

		return ymd;
	}

	// n일 전의 날짜를 반환한다.
	Pr11 beforeYmd(int n)
	{
		Pr11 ymd = new Pr11(this.year, this.month, this.day);
		
		int beforeDay = ymd.month - n;
		
		if(beforeDay <= 0)
		{
			ymd.month--;
			int lastDay = monthDays[isLeap(year)][ymd.month-1]; // 지난달의 마지막 day
			
			ymd.day += beforeDay; // beforeDay는 음수
		}
		else
		{
			ymd.day -= n;
		}
		
		return ymd;
	}

	public static void main(String[] args)
	{
		
		/*System.out.print(ymd.year +"년 " +ymd.month + "월 " + ymd.day + "일의 " + beforDay + "일전 날짜는 ");
		Pr11 beforeYmd = beforeYmd(beforDay);
		System.out.println(beforeYmd.year +"년 " +beforeYmd.month + "월 " + beforeYmd.day + "이다.");

		System.out.println();

		System.out.println(ymd.year +"년 " +ymd.month + "월 " + ymd.day + "일의 " + afterDay + "일후 날짜는 ");
		Pr11 afterYmd = afterDate(afterDay);
		System.out.println(afterYmd.year +"년 " +afterYmd.month + "월 " + afterYmd.day + "이다.");*/
	}
}
