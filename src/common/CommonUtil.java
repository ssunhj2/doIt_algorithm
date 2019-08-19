package common;

public class CommonUtil 
{
	// 배열의 값을 출력한다.
	public static void arrayAddPrint(int[] intArr) 
	{
		for (int i = 0; i < intArr.length; i++) 
		{
			System.out.println("intArr["+ i + "]: " + intArr[i]);
		}
	}
	
	// int형 배열 intArr[index1]과 intArr[index2]를 교환한다.
	public static void swap(int[] intArr, int index1, int index2)
	{
		int temp = intArr[index1];
		intArr[index1] = intArr[index2];
		intArr[index2] = temp;
	}
}
