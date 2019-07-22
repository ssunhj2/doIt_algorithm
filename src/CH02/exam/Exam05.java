package CH02.exam;

import java.util.Random;

/**
 * 실습 2-5
 * 난수를 사용해 배열 요소값 설정한다.
 **/
public class Exam05
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

        int personCnt = 5;

        System.out.println("몸무게의 최대값을 구한다.");
        System.out.print("사람 수 : ");

        int num = personCnt;

        int[] weight = new int[num];

        System.out.println("몸무게는 아래와 같다.");

        for(int i=0; i<num; i++)
        {
            weight[i] = 50 + random.nextInt(50);
            System.out.println("weight["+i+"]: " + weight[i]);
        }

        System.out.println("최대값은 " + maxArr(weight) + " 이다.");
    }
}
