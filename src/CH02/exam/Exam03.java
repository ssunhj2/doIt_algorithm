package CH02.exam;

/**
 * 실습 2-3
 * 배열을 복제한다.
 **/
public class Exam03
{
    public static void main(String[] args)
    {
        int[] intArr = {10, 20, 30, 40, 50, 60};
        int[] cloneArr = intArr.clone();

        cloneArr[2] = 33;

        System.out.print("intarr = ");
        for(int i=0; i<intArr.length; i++)
        {
            System.out.print(" " + intArr[i]);
        }

        System.out.print("\ncloneArr = ");
        for(int i=0; i<cloneArr.length; i++)
        {
            System.out.print(" " + cloneArr[i]);
        }
    }
}
