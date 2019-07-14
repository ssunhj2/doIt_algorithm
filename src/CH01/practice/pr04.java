package CH01.practice;

/**
 * 세 값의 대소관계 13종류의 모든 조합에 대해 중앙값을 구한다.
 */
public class pr04
{
    static int med4(int a, int b, int c)
    {
        if(a >= b)
            if(b >= c)
                return b;
            else if(a <= c)
                return a;
            else
                return c;
        else if(a > c)
            return a;
        else if(b > c)
            return c;
        else return b;
    }

    public static void main(String[] args)
    {
        System.out.println("med4(3,2,1)= " + med4(3,2,1));
        System.out.println("med4(3,2,2)= " + med4(3,2,2));
        System.out.println("med4(3,1,2)= " + med4(3,1,2));
        System.out.println("med4(3,2,3)= " + med4(3,2,3));
        System.out.println("med4(2,1,3)= " + med4(2,1,3));
        System.out.println("med4(3,3,2)= " + med4(3,3,2));
        System.out.println("med4(3,3,3)= " + med4(3,3,3));
        System.out.println("med4(2,2,3)= " + med4(2,2,3));
        System.out.println("med4(2,3,1)= " + med4(2,3,1));
        System.out.println("med4(2,3,2)= " + med4(2,3,2));
        System.out.println("med4(1,3,2)= " + med4(1,3,2));
        System.out.println("med4(2,3,3)= " + med4(2,3,3));
        System.out.println("med4(1,2,3)= " + med4(1,2,3));
    }
}
