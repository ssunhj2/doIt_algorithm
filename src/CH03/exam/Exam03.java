package CH03.exam;

/**
 * 실습 3-3
 * 선형검색 구현 (보초법)
 */
public class Exam03
{
    static int lineSearchSen(int[] arr, int n, int key)
    {
        int i = 0;

        arr[n] = key;

        while(true)
        {
            if(arr[i] == key)
            {
                break;
            }

            i++;
        }

        return i == n ? -1 : i;
    }

    public static void main(String[] args)
    {
        int arrLength = 6;
        int searchNum = 557;
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
