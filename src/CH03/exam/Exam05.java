package CH03.exam;

import java.util.Arrays;

/**
 * 실습 3-5
 * Arrays 클래스의 binarySearch 메소드로 이진검색 구현한다.
 */
public class Exam05
{
    public static void main(String[] args)
    {
        int[] arr = {15, 27, 39, 87, 92, 108, 121};
        int searchText = 39;

        int index = Arrays.binarySearch(arr, searchText);

        if(index < 0)
        {
            System.out.println("검색값을 찾을 수 없다.");
        }
        else
        {
            System.out.println(searchText + " 은(는) arr["+index+"]에 있다.");
        }
    }

}
