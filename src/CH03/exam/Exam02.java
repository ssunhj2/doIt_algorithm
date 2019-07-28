package CH03.exam;

/**
 * 실습 3-2
 * 선형검색 구현 (for문 사용)
 */
public class Exam02
{
    static int lineSearch(int[] arr, int n, int key)
    {
        for (int i = 0; i < n; i++)
        {
            if(arr[i] == key) return i;
        }

        return -1;
    }

    public static void main(String[] args)
    {
        int arrLength = 6;
        int searchNum = 55;
        int[] arr = {22, 8, 55, 32, 120, 55};

        System.out.println("전체 요소 개수: "+ arrLength);
        System.out.println("검색값: " + searchNum);

        int index = lineSearch(arr, arrLength, searchNum);

        if(index == -1)
        {
            System.out.println("검색값을 찾을 수 없다.");
        }
        else
        {
            System.out.println(searchNum + " 은(는) arr["+index+"]에 있다.");
        }
    }

}
