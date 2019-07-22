package CH02.exam;

/**
 * 실습 2-1
 * 구성 요소의 자료형이 int 형인 배열을 생성한다.
**/
 public class Exam01
{
    public static void main(String[] args)
    {
        int[] intArr = new int[4];

        intArr[0] = 40;
        intArr[1] = 66;
        intArr[3] = intArr[0] * 3;

        for(int i=0; i<intArr.length; i++)
        {
            System.out.println("intArr[" + i + "] = " + intArr[i]);
        }
    }
}
