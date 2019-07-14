package CH01.practice;
import java.util.Scanner;

/**
 * 입력한 수를 한변으로 하는 정사각형을 * 기호로 출력한다.
 */
public class pr14
{
    public static void main(String[] args)
    {
        Scanner stdIn = new Scanner(System.in);
        int n;

        System.out.println("사각형을 출력합니다.");

        do
        {
            System.out.print("단수: ");
            n  = stdIn.nextInt();

            if(n <= 0)  System.out.println("양의 정수값을 입력해주세요");
        } while(n <= 0);

        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n; j++)
            {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}
