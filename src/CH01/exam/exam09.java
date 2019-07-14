package CH01.exam;

/**
 * 실습 1-7
 * 이중루프를 사용하여 곱셈표를 출력한다.
 */
public class exam09
{
    public static void main(String[] args)
    {
        System.out.println("---------- 곱셈표 ----------");

        for(int i=1; i<=9; i++)
        {
            for(int j=1; j<=9; j++)
            {
                System.out.printf("%3d", i*j); // 3자리 출력
            }
            System.out.println();
        }
    }
}
