package CH02.exam;

/**
 * 실습 2-10
 * 1,000 이하의 소수를 나열한다.
 */
public class Exam11
{
	public static void main(String[] args)
	{
		int cnt = 0;
		int ptrCnt = 0;
		int[] prime = new int[500];

		prime[ptrCnt++] = 2;

		for (int i = 3; i <= 1000 ; i += 2)
		{
			int j;
			for (j = 1; j < ptrCnt; j++)
			{
				cnt++;
				if(i % prime[j] == 0) break;
			}

			if(ptrCnt == j) prime[ptrCnt++] = i;
		}

		for (int i = 0; i < ptrCnt; i++)
		{
			System.out.println(prime[i]);
		}

		System.out.println("나눗셈을 수행한 횟수: " + cnt);
	}
}
