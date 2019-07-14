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
 *   [규칙]
 */
public class pr17
{
    static void npira(int n)
    {
        
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

        spira(n);
    }
}
