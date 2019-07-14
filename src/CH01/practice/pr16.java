package CH01.practice;
import java.util.Scanner;

/**
 * n단의 피라미드를 출력하는 메서드를 작성한다.
 * ex) 4단은 아래와 같다
 *      *
 *     ***
 *    *****
 *   *******
 *
 *   [규칙]
 *   별 마지막 행 갯수 = (2n)-1
 *   중심 = 입력한 수 n
 *   별 시작 = 중심(n)-(i-1)
 *   별 끝  = 중심(n)+(i-1)
 *   별 시작과 끝의 사이값에만 *을 입력, 외에는 빈문자열 입력
 */
public class pr16
{
    static void spira(int n)
    {
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=(2*n)-1; j++)
            {
                if(n-(i-1) <= j)
                {
                    if(j <= n+(i-1)) System.out.print('*');
                    else System.out.print(' ');
                }
                else System.out.print(' ');
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

        spira(n);
    }
}
