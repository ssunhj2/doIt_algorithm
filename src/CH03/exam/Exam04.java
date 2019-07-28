package CH03.exam;

import java.util.Scanner;

/**
 * 실습 3-4
 * 이진검색 구현
 */
public class Exam04
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
                return pc;
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
        int arrLength = 6;
        System.out.println("전체 요소 개수: "+ arrLength);

        Scanner inputArr = new Scanner(System.in);
        int[] arr = new int[arrLength];

        System.out.println("숫자를 오름차순으로 입력한다.");

        System.out.print("arr[0] : ");
        arr[0] = inputArr.nextInt();

        for (int i = 1; i < arrLength; i++)
        {
           do
           {
               System.out.print("arr["+i+ "] : ");
               arr[i] = inputArr.nextInt();
           }
           while(arr[i] < arr[i-1]);
        }

        int searchNum = 39;
        System.out.println("검색값: " + searchNum);

        int index = binarySearch(arr, arrLength, searchNum);

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
