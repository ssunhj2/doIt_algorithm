package CH03.practice;

/**
 * 선형검색의 진행과정을 출력하는 프로그램을 작성한다.
 * 현재 검색하고 있는 요소 위에 * 를 출력한다.
 */
public class Pr02
{
    static int lineSearch(int[] arr, int n, int key)
    {

        System.out.print("  | ");
        for (int i = 0; i < n; i++)
        {
            System.out.print(i + " ");
        }
        System.out.println("\n--+---------------------");

        for (int i = 0; i < n; i++)
        {
            System.out.print("  |");
            System.out.printf("%"+ ((2*i)+1) + "s\n","*");

            System.out.print(i+ " |");
            for (int j = 0; j < n; j++)
            {
                System.out.print(arr[j] + " ");
            }
            System.out.print("\n");
            if(arr[i] == key) return i;
        }

        return -1;
    }

    public static void main(String[] args)
    {
        int arrLength = 7;
        int searchNum = 9;
        int[] arr = {6, 4, 3, 2, 1, 9, 8};

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
