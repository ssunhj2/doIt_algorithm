package CH01.practice;
import java.util.Scanner;

/**
 * 양의 정수를 입력하고 자리수를 출력하는 프로그램을 작성한다.
 * ex) 135 -> 그 수는 3자리 입니다.
 *     1314 -> 그 수는 4자리 입니다.
 */
public class pr11
{
    public static void main(String[] args)
    {
        Scanner stdIn = new Scanner(System.in);
        int n;

        System.out.println("자릿수를 구합니다.");

        do
        {
            System.out.print("양의 정수값 입력");
            n  = stdIn.nextInt();

            if(n <= 0)  System.out.println("양의 정수값을 입력해주세요");
        } while(n <= 0);

        int numLength = (Integer.toString(n)).length();

        System.out.println("그 수는 " + numLength + "자리 입니다.");
    }
}
