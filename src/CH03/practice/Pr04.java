package CH03.practice;


/**
 * 이진검색 과정을 출력하는 프로그램을 작성한다.
 */
public class Pr04
{
    static int binarySearch(int[] arr, int n, int searchNum)
    {
        int pl = 0;
        int pr = n-1;

        System.out.print("  | ");
        for (int i = 0; i < n; i++)
        {
            System.out.print(i + " ");
        }
        System.out.println("\n--+---------------------");

        do
        {
            int pc = (int)Math.ceil((pl + pr) / 2);

            System.out.printf("  |<-%"+ pc+ "s+%"+pr+"s->\n", " ", " ");
            System.out.print(pc+ " | ");
            for (int i = 0; i < n; i++)
            {
                System.out.print(arr[i] + " ");
            }
            System.out.print("\n");

            if(arr[pc] == searchNum)
            {
                return pc;
            }
            else if(arr[pc] < searchNum)
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
        int[] arr = {1,2,3,5,6,8,9};
        int arrLength = arr.length;

        int searchNum = 2;

        int result = binarySearch(arr, arrLength, searchNum);

    }

}
