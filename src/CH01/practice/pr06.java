package CH01.practice;
import java.util.Scanner;

/**
 * 실습 1-4
 * 1부터 n까지 정수 합 구하기 (1부터 n까지 증가하는 i 값 출력하기)
 */
public class pr06
{
    public static void main(String[] args)
    {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("1부터 n까지의 합을 구합니다.");
        System.out.print("n의 값");
        int n = stdIn.nextInt();

        int sum = 0;
        int i = 1;

        while (i <= n)
        {
            System.out.println("i = " + i); // i값 출력

            sum += i;
            i++;
        }

        System.out.println("1부터 " + n + "까지의 합은 " + sum + " 입니다.");
    }
}
