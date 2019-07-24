package CH02.exam;

/**
 * 실습 2-11
 * 1,000 이하의 소수를 나열한다. (소수는 제곱근 이하의 소수들로 나누어떨어지지 않는 수이다.)
 */
public class Exam12
{
	public static void main(String[] args)
	{
		int cnt = 0;
		int ptrCnt = 0;
		int[] prime = new int[500];

		prime[ptrCnt++] = 2;
		prime[ptrCnt++] = 3;

		for (int i = 5; i <= 1000 ; i += 2)
		{
			boolean flag = false;
			for (int j = 1; prime[j]*prime[j] <= i; j++)
			{
				cnt += 2;
				
				if(i % prime[j] == 0) 
				{
					flag = true;
					break;
				}
			}

			if(!flag)
			{
				prime[ptrCnt++] = i;
				cnt++;
			}
		}

		for (int i = 0; i < ptrCnt; i++)
		{
			System.out.println(prime[i]);
		}

		System.out.println("곱셈과 나눗셈은 " + cnt + "번 수행됐다");
	}
}
