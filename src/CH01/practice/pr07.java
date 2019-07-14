package CH01.practice;
import java.util.Scanner;

/**
 * n이 7이면 '1+2+3+4+5+6+7=28'로 출력하는 프로그램을 작성한다.
 */
public class pr07
{
    public static void main(String[] args)
    {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("1부터 n까지의 합을 구합니다.");
        System.out.print("n의 값");
        int n = stdIn.nextInt();

        if(n == 7)
        {
            int sum = 0;

            for(int i=1; i <= n; i++)
            {
                sum += i;
            }

            System.out.println("1부터 " + n + "까지의 합은 " + sum + " 입니다.");
        }


    }
}
