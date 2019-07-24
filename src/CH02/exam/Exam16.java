package CH02.exam;

import sun.misc.VM;

/**
 * 실습 2-14
 * 신체검사 데이터용 클래스 배열에서 평균 키와 시력의 분포를 구한다.
 */
public class Exam16
{
	static final int VMAX = 21;
	String name;
	int age;
	double height;
	double vision;

	public Exam16(String name, int age, double height, double vision)
	{
		this.name = name;
		this.age = age;
		this.height = height;
		this.vision = vision;
	}

	// 키의 평균을 구한다.
	static double aveHeight(Exam16[] personData)
	{
		double sum = 0;

		for (int i = 0; i < personData.length; i++)
		{
			sum+= personData[i].height;
		}

		return sum / personData.length;
	}

	// 시력 분포를 구한다.
	static void aveVision(Exam16[] personData, int[] dist)
	{
		int i = 0;

		for (i = 0; i < personData.length; i++)
		{
			if(personData[i].vision >= 0.0 && personData[i].vision <= VMAX / 10.0)
			{
				dist[(int)(personData[i].vision*10)]++;
			}
		}
	}

	public static void main(String[] args)
	{
		Exam16[] personInfo = {
			new Exam16("kang nana", 17, 160, 2.0),
			new Exam16("lee gaga", 29, 173, 0.3),
			new Exam16("ryu dada", 11, 130, 0.9),
			new Exam16("kim lala", 67, 180, 1.0),
			new Exam16("beak mama", 27, 153, 1.2),
			new Exam16("sun baba", 40, 185, 0.4),
		};

		int[] vDist = new int[VMAX];

		System.out.println("+ 신체검사 목록 +");
		System.out.println("이름       나이   키      시력");
		System.out.println("----------------------------");

		for (int i = 0; i < personInfo.length; i++)
		{
			System.out.printf("%-10s%4d %4f%5.1f\n", personInfo[i].name, personInfo[i].age, personInfo[i].height, personInfo[i].vision);
		}
		System.out.printf("평균키: %5.1fcm\n", aveHeight(personInfo));

		aveVision(personInfo, vDist);

		System.out.println("\n시력분포");
		for (int i = 0; i < VMAX; i++)
		{
			System.out.printf("%3.1f~ : %2d명\n", i/10.0, vDist[i]);
		}
	}
}
