package CH01.practice;
import java.util.Scanner;

/**
 * 두 변수 a,b에 정수를 입력하고  b-a를 출력하는 프로그램을 작성한다.
 * 단, 변수 b에 입력한 값이 a 이하면 변수 b의 값을 다시 입력받는다.
 */
public class pr10
{
    public static void main(String[] args)
    {
        Scanner stdIn = new Scanner(System.in);
        int a;
        int b;

        System.out.println("b-a의 값을 구합니다.");

        System.out.print("a의 값");
        a  = stdIn.nextInt();

        do
        {
            System.out.print("b의 값");
            b  = stdIn.nextInt();

            if(b <= a)  System.out.println("b의 값은 a보다 큰 값을 입력해야합니다");

        } while(b <= a);

        int result = b-a;

        System.out.println("b-a 연산의 값은 " + result + " 입니다.");
    }
}
