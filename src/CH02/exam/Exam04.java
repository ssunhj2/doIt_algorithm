package CH02.exam;

import java.util.Random;

/**
 * 실습 2-4
 * 배열요소의 최댓값을 구한다.
 **/
public class Exam04
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
        System.out.println("사람 수 : "+ personCnt);

        int[] weight = {52, 66, 90, 87, 43};
        
        for(int i=0; i<personCnt; i++)
        {
            System.out.println("weight["+i+"]: " + weight[i]);
        }

        System.out.println("최대값은 " + maxArr(weight) + " 이다.");
    }
}
