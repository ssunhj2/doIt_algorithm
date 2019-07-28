package CH03.practice;

/**
 * 이진검색 보초법 구현 (for문 사용)
 */
public class Pr01
{
    static int lineSearchSen(int[] arr, int n, int key)
    {
        arr[n] = key;
        int resultIdx = -1;

        for (int i = 0; i < n; i++)
        {
            if(arr[i] == key && n != i)
            {
                resultIdx = i;
                break;
            }

        }

        return resultIdx;
    }

    public static void main(String[] args)
    {
        int arrLength = 6;
        int searchNum = 120;
        int[] arr = new int[arrLength+1];

        int[] initArr = {22, 8, 55, 32, 120, 55};

        for (int i = 0; i < initArr.length; i++)
        {
            arr[i] = initArr[i];
        }

        System.out.println("전체 요소 개수: "+ arrLength);
        System.out.println("검색값: " + searchNum);

        int index = lineSearchSen(arr, arrLength, searchNum);

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
