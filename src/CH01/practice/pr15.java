package CH01.practice;
import java.util.Scanner;

/**
 * 왼쪽 아래가 직각인 이등변 삼각형을 출력한다. (triangleLB)
 * 왼쪽 위가 직각인 이등변 삼각형을 출력한다. (triangleLU)
 * 오른쪽 위가 직각인 이등변 삼각형을 출력한다. (triangleRU)
 * 오른쪽 아래가 직각인 이등변 삼각형을 출력한다. (triangleRB)
 */
public class pr15
{
    // 왼쪽 아래가 직각
    static void triangleLB(int n)
    {
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=i; j++)
            {
                System.out.print('*');
            }
            System.out.println();
        }
        System.out.println();

    }

    // 왼쪽 위가 직각
    static void triangleLU(int n)
    {
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=(n-i)+1; j++)
            {
                System.out.print('*');
            }
            System.out.println();
        }
        System.out.println();
    }


    // 오른쪽 위가 직각
    static void triangleRU(int n)
    {
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n; j++)
            {
                if(i > j) System.out.print(' ');
                else System.out.print('*');
            }
            System.out.println();
        }
        System.out.println();
    }

    // 오른쪽 아래가 직각
    static void triangleRB(int n)
    {
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n; j++)
            {
                if((n-i)+1 > j) System.out.print(' ');
                else System.out.print('*');
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Scanner stdIn = new Scanner(System.in);
        int n;

        System.out.println("이등변 삼각형을 출력한다.");

        do
        {
            System.out.print("몇 단 삼각형입니까? :");
            n = stdIn.nextInt();
        } while(n <= 0);

        triangleLB(n);
        triangleLU(n);
        triangleRU(n);
        triangleRB(n);
    }
}
