package CH02.exam;

/**
 * 실습 2-2
 * 구성 요소의 자료형인 배열 초기화하여 생성한다.
 **/
public class Exam02
{
    public static void main(String[] args)
    {
        int[] intArr = {10, 20, 30, 40, 50, 60};

        for(int i=0; i<intArr.length; i++)
        {
            System.out.println("intArr[" + i + "] = " + intArr[i]);
        }
    }
}
