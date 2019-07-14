package CH01.practice;
import java.util.Scanner;

/**
 * 가우스 덧셈을 이용해 1부터 n까지의 정수 합을 구한다.
 */
public class pr08
{
    static int gauss(int n)
    {
        int sum = 0;

        if(n%2 == 0)
        {
            sum = ((1+n)*((1+n)/2));
        }
        else if(n%2 == 1)
        {
            sum = ((1+n)*((1+n)/2)) - ((1+n)/2);
        }

        return sum;
    }

    public static void main(String[] args)
    {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("1부터 n까지의 합을 구합니다.");
        System.out.print("n의 값");
        int n = stdIn.nextInt();

        int sum = gauss(n);

        if(sum > 0) System.out.println("1부터 " + n + "까지의 합은 " + sum + " 입니다.");

    }
}
