package CH03.practice;

import java.util.Arrays;

/**
 * Arrays 클래스의 binarySearch 메소드로 이진검색 구현한다.
 */
public class Pr06
{
    public static void main(String[] args)
    {
        int[] arr = {15, 27, 39, 87, 92, 108, 121};
        int searchText = 399;

        int index = Arrays.binarySearch(arr, searchText);

        if(index < 0)
        {
            System.out.println("삽입 포인트 값은 " + index + " 이다.");
        }
        else
        {
            System.out.println(searchText + " 은(는) arr["+index+"]에 있다.");
        }
    }

}
