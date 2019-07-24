package CH02.practice;

/**
 * 사람들의 시력의 분포를 구한다.
 */
public class Pr10
{
	static final int VMAX = 21;
	String name;
	double vision;

	public Pr10(String name, double vision)
	{
		this.name = name;
		this.vision = vision;
	}


	// 시력 분포를 구한다.
	static void aveVision(Pr10[] personData, int[] dist)
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
		Pr10[] personInfo = {
			new Pr10("kang nana", 2.0),
			new Pr10("lee gaga", 0.3),
			new Pr10("ryu dada", 0.9),
			new Pr10("kim lala", 1.0),
			new Pr10("beak mama", 1.2),
			new Pr10("sun baba",0.4),
			new Pr10("sin sasa",0.3),
			new Pr10("choi kaka",0.3),
		};

		int[] vDist = new int[VMAX];

		System.out.println("+ 신체검사 목록 +");
		System.out.println("이름        시력");
		System.out.println("----------------");

		for (int i = 0; i < personInfo.length; i++)
		{
			System.out.printf("%-10s%5.1f\n", personInfo[i].name, personInfo[i].vision);
		}

		aveVision(personInfo, vDist);

		System.out.println("\n시력분포");
		for (int i = 0; i < VMAX; i++)
		{
			System.out.printf("%3.1f~ : ", i/10.0);

			if(vDist[i] > 0)
			{
				for (int j = 0; j < vDist[i]; j++)
				{
					System.out.printf("%2s", "*");
				}
				System.out.print("\n");
			}
			else
			{
				System.out.print("\n");
			}

		}
	}
}
