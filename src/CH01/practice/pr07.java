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


         int sum = 0;
         String result = "";

         for(int i=1; i <= n; i++)
         {
             if(i!=1) result += "+";

             sum += i;
             result += i;
         }


         System.out.println(result + " = " + sum);



    }
}
