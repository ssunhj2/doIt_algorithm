package CH01.practice;

/**
 * 이중루프를 사용하여 곱셈표를 출력한다. (위쪽과 왼쪽에 곱하는 수가 표시되도록 한다.)
 */
public class pr12
{
    public static void main(String[] args)
    {
        for(int i=1; i<=9; i++)
        {
            System.out.print(i+ "|");

            for(int j=1; j<=9; j++)
            {
                System.out.printf("%3d", i*j); // 3자리 출력
            }
            System.out.println();
        }
    }
}
