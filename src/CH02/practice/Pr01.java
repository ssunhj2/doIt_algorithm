package CH02.practice;

import java.util.Random;

/**
 * 사람의 수와 몸무게를 난수로 받아 최대값을 구한다.
 **/
public class Pr01
{
	static int maxArr(int[] intArr)
    {
        int max = intArr[0];

        for(int i=1; i<intArr.length; i++)
        {
            if(intArr[i] > max)
            {
                max = intArr[i];
            }
        }

        return max;
    }

    public static void main(String[] args)
    {
        Random random = new Random();

        int personCnt = 1 + random.nextInt(10);

        System.out.println("몸무게의 최대값을 구한다.");
        System.out.println("사람 수 : "+ personCnt);

        int[] weight = new int[personCnt];

        System.out.println("몸무게는 아래와 같다.");

        for(int i=0; i<personCnt; i++)
        {
            weight[i] = 50 + random.nextInt(50);
            System.out.println("weight["+i+"]: " + weight[i]);
        }

        System.out.println("최대값은 " + maxArr(weight) + " 이다.");
    }
}
