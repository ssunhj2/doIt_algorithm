package CH03.practice;

/**
 * 배열 안에서 일치하는 요소의 모든 index를 배열의 맨 앞부터 순서대로 저장한다.
 * 일치한 요소의 개수를 반환하는 매서드를 작성한다.
 */
public class Pr03
{
    static int searchIdxCnt(int[] arr, int n, int key, int[] idx)
    {
        int j = 0;
        for (int i = 0; i < n; i++)
        {
            if(arr[i] == key)
            {
                idx[j] = i;
                j++;
            }
        }

        return j;

    }

    public static void main(String[] args)
    {
        int[] arr = {9,1,9,2,4,7,6,9};

        int arrLength = arr.length;
        int[] resultArr = new int[arrLength];

        int key = 9;

        int searchCnt = searchIdxCnt(arr, arrLength, key, resultArr);


        if(searchCnt == 0)
        {
            System.out.println("일치하는 요소가 없다.");
        }
        else
        {
            System.out.println("일치하는 요소의 개수는 "+ searchCnt + "개 이다.");
        }

    }

}
