package CH01.practice;
import java.util.Scanner;

/**
 * 숫자로 n단의 피라미드를 출력하는 메서드를 작성한다.
 * ex) 4단은 아래와 같다
 *      1
 *     222
 *    33333
 *   4444444
 *
 *  각 수의 자리수를 입력받은 숫자 n의 자리수와 맞춘다.
 */
public class pr17
{
    static void npira(int n)
    {
        int nLength = Integer.toString(n).length();

        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=(2*n)-1; j++)
            {
                if(n-(i-1) <= j)
                {
                    if(j <= n+(i-1)) System.out.printf("%"+nLength+"d", i);
                    else System.out.printf("%"+ nLength+ "s", "");
                }
                else System.out.printf("%"+ nLength+ "s", "");
            }
            System.out.println();
        }
    }


    public static void main(String[] args)
    {
        Scanner stdIn = new Scanner(System.in);
        int n;

        System.out.println("n단의 피라미드를 출력한다.");

        do
        {
            System.out.print("몇 단 피라미드 입니까? :");
            n = stdIn.nextInt();
        } while(n <= 0);

        npira(n);
    }
}
