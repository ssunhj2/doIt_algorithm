package CH02.practice;

/**
 * 배열을 역순으로 정렬하는 과정을 출력한다.
 */
public class Pr02
{
	static void switching(int[] iArr, int index1, int index2)
	{
		System.out.println("iArr["+index1+"] 과(와) " + "iArr["+index2+"] 를 switching! ");

		int temp = iArr[index1];
		iArr[index1] = iArr[index2];
		iArr[index2] = temp;

		for (int i=0; i < iArr.length; i++)
		{
			System.out.print(iArr[i]+" ");
		}
		System.out.print("\n");
	}
	
	static void reverseArr(int[] iArr)
	{
		int arrLength = iArr.length;

		for (int i=0; i < (arrLength /2); i++)
		{
			switching(iArr, i, (arrLength-i-1));
		}
	}
	
	public static void main(String[] args) 
	{
		int[] iArr = {17, -22, 7, 2, -5, 98};

		for (int i=0; i < iArr.length; i++)
		{
			System.out.print(iArr[i]+" ");
		}
		System.out.print("\n");

		reverseArr(iArr);

		System.out.println("역순정렬 완료");
	}

}
