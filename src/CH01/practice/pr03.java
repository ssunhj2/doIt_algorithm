package CH01.practice;

/**
 * 네 값의 최솟값을 구하는 min4 메서드를 작성한다.
 */
public class pr03
{
    static int min4(int a, int b, int c, int d)
    {
        int min = a;

        if(b < min) min = b;
        if(c < min) min = c;
        if(d < min) min = d;

        return min;
    }

    public static void main(String[] args)
    {
        System.out.println("min4(4,3,2,1)= " + min4(4,3,2,1));
        System.out.println("min4(4,3,2,2)= " + min4(4,3,2,2));
        System.out.println("min4(4,3,1,2)= " + min4(4,3,1,2));
        System.out.println("min4(4,1,2,3)= " + min4(4,1,2,3));
        System.out.println("min4(3,4,1,2)= " + min4(3,4,1,2));
        System.out.println("min4(3,4,4,1)= " + min4(3,4,4,1));
        System.out.println("min4(3,2,4,1)= " + min4(3,2,4,1));
        System.out.println("min4(3,2,1,4)= " + min4(3,2,1,4));
        System.out.println("min4(2,4,3,1)= " + min4(2,4,3,1));
        System.out.println("min4(2,3,4,1)= " + min4(2,3,4,1));
        System.out.println("min4(2,1,3,4)= " + min4(2,1,3,4));
        System.out.println("min4(1,3,3,4)= " + min4(1,3,3,4));
        System.out.println("min4(1,1,2,4)= " + min4(1,1,2,4));
        System.out.println("min4(1,4,2,3)= " + min4(1,4,2,3));
        System.out.println("min4(1,2,3,4)= " + min4(1,2,3,4));

    }

}
