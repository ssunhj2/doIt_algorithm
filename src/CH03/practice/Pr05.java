package CH03.practice;

/**
 * 검색 배열에 찾는 요소값이 여러개면 맨 앞의 요소럴 탐색하는 이진검색을 구현한다.
 */
public class Pr05
{
    static int binarySearch(int[] arr, int n, int key)
    {
        int pl = 0;
        int pr = n-1;

        do
        {
            int pc = (pl + pr) / 2;

            if(arr[pc] == key)
            {
                
            }
            else if(arr[pc] < key)
            {
                pl = pc+1;
            }
            else
            {
                pr = pc-1;
            }
        }
        while(pl <= pr);

        return -1;
    }

    public static void main(String[] args)
    {
        int[] arr = {1,3,5,7,7,7,7,8,9,8,9};

        int searchNum = 7;
        System.out.println("검색값: " + searchNum);

        int index = binarySearch(arr, arr.length, searchNum);

        if(index == -1)
        {
            System.out.println("검색값을 찾을 수 없다.");
        }
        else
        {
            System.out.println(searchNum + " 의 제일 첫 index는 "+index+" 이다.");
        }
    }

}
