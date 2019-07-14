package CH01.practice;
import java.util.Scanner;

/**
 * 정수 a,b를 포함하여 그 사이의 모든 정수의 합을 구하여 반환하는 메서드를 작성한다. (단, a와 b의 대소는 상관하지 않는다.)
 */
public class pr09
{
    static int sumof(int a, int b)
    {
        int sum = 0;

        if(a > b)
        {
            int temp = a;
            a = b;
            b = temp;
        }

        for(int i=a; i <=b; i++)
        {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args)
    {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("a부터 b 사이 정수의 합을 구합니다.");
        System.out.print("a의 값");
        int a = stdIn.nextInt();

        System.out.print("b의 값");
        int b = stdIn.nextInt();

        int sum = sumof(a, b);

        if(sum > 0) System.out.println("합은 " + sum + " 입니다.");

    }
}
